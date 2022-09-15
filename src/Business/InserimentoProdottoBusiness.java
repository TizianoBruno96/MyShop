package Business;

import DAO.CategoriaDAO;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IPosizioneDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.Interfaces.IProduttoreDAO;
import DAO.PosizioneDAO;
import DAO.ProdottoDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.Posizione;

public class InserimentoProdottoBusiness {
    private static InserimentoProdottoBusiness istanza;
    IProdottoDAO pDAO = ProdottoDAO.getInstance();
    IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    public static synchronized InserimentoProdottoBusiness getInstance() {
        if (istanza == null) {
            istanza = new InserimentoProdottoBusiness();
        }
        return istanza;
    }


    public InserimentoProdottoBusiness confermaProdotto(String nomeProdotto, String descrizione, float costo, String nomeProduttore, String categoriaProdotto, int disponibilita, int pCorsia, int pScaffale) {
        Prodotto p = new Prodotto();
        Posizione pos = new Posizione();
        Produttore pro = new Produttore();
        Categoria c = new Categoria();


        p.setNome(nomeProdotto);
        p.setDescrizione(descrizione);
        p.setCosto(costo);
        pro = produttoreDAO.findByNome(nomeProduttore);
        p.setIdProduttore(pro.getIdProduttore());
        c = categoriaDAO.findByNome(categoriaProdotto);
        p.setIdCategoria(c.getIdCategoria());
        posizioneDAO.addProdottoInPosizione(p,pCorsia,pScaffale,1,disponibilita);

        pDAO.add(p,c,pro);




        return null;
    }
}
