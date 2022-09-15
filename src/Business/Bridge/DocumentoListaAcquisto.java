package Business.Bridge;

import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.Interfaces.IOrdineServizioDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.Interfaces.IServizioDAO;
import DAO.OrdineProdottoDAO;
import DAO.OrdineServizioDAO;
import Model.Articoli.Prodotto;
import Model.Articoli.Servizio;
import Model.ListaAcquisto;
import Model.OrdineProdotto;
import Model.OrdineServizio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DocumentoListaAcquisto extends Documento {

    private final ListaAcquisto lista;

    public DocumentoListaAcquisto(ListaAcquisto lista, IPdfAPI IPdfAPI) {
        super(IPdfAPI);
        this.lista = lista;
    }

    @Override
    public void invia(String indirizzo) {
        IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
        IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
        IProdottoDAO prodottoDAO = DAO.ProdottoDAO.getInstance();
        IServizioDAO servizioDAO = DAO.ServizioDAO.getInstance();

        //Creo le liste di ordini
        List<OrdineProdotto> ordiniProdotto = ordineProdottoDAO.findByListaAcquisto(lista.getIdListaAcquisto());
        List<OrdineServizio> ordiniServizio = ordineServizioDAO.findByIDListaAcquisto(lista.getIdListaAcquisto());
        List<Prodotto> prodotti = new ArrayList<>();
        List<Servizio> servizi = new ArrayList<>();

        //Aggiungo gli articoli
        for (OrdineProdotto ordineProdotto : ordiniProdotto) {
            prodotti.add(prodottoDAO.findByID(ordineProdotto.getIdProdotto()));
        }
        for (OrdineServizio ordineServizio : ordiniServizio) {
            servizi.add(servizioDAO.findByID(ordineServizio.getIdServizio()));
        }

        //Creo il documento
        StringBuilder text = new StringBuilder("Prodotti:\n");
        for (Prodotto prodotto : prodotti) {
            text.append(prodotto.getNome()).append(" ").append(prodotto.getCosto()).append("€\n");
        }
        text.append("Servizi:\n");
        for (Servizio servizio : servizi) {
            text.append(servizio.getNome()).append(" ").append(servizio.getCosto()).append("€\n");
        }
        text.append("Totale: ").append(lista.getCostoTot()).append("€\n");
        text.append("Pagata: ").append(lista.isPagata()).append("\n");

        try {
            File tempFile = File.createTempFile("MyShopCart", ".pdf", new File(indirizzo));
            IPdfAPI.creaPdf(String.valueOf(text), indirizzo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
