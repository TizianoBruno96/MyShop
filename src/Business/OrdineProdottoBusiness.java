package Business;

import DAO.Interfaces.IListaAcquistoDAO;
import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.ListaAcquistoDAO;
import DAO.OrdineProdottoDAO;
import Model.Articoli.Prodotto;
import Model.ListaAcquisto;
import Model.OrdineProdotto;
import Views.AccessoUtente;

import java.util.ArrayList;

public class OrdineProdottoBusiness {
    private static OrdineProdottoBusiness instance;
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
    IProdottoDAO prodottoDAO = DAO.ProdottoDAO.getInstance();

    public static synchronized OrdineProdottoBusiness getInstance() {
        if (instance == null) {
            instance = new OrdineProdottoBusiness();
        }
        return instance;
    }

    public void InserisciLista(ArrayList<Integer> idProdotti, ArrayList<Integer> quantita) {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(AccessoUtente.getIdUtente());
        //ciclo su ambo gli array
        for (int i = 0; i < idProdotti.size(); i++) {
            //creo un nuovo ordineProdotto
            Prodotto prodotto = prodottoDAO.findByID(idProdotti.get(i));
            OrdineProdotto op = new OrdineProdotto(idProdotti.get(i), listaAcquisto.getIdListaAcquisto(), quantita.get(i));
            if (ordineProdottoDAO.find(prodotto, listaAcquisto) != null) {
                op = ordineProdottoDAO.find(prodotto, listaAcquisto);
                int quantitaAttuale = op.getQuantita();
                op.setQuantita(quantitaAttuale + 1);
                ordineProdottoDAO.update(op);
            }
            else ordineProdottoDAO.add(op);
        }
    }
}
