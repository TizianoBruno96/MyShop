package Business;

import DAO.CategoriaDAO;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IPosizioneDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.Interfaces.IProduttoreDAO;
import DAO.PosizioneDAO;
import DAO.ProdottoDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.IProdotto;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.Posizione;

public class ConfermaInserimentoProdottoBusiness {
    IProdottoDAO pDAO = ProdottoDAO.getInstance();
    IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();


    private static ConfermaInserimentoProdottoBusiness istanza;
    public static synchronized  ConfermaInserimentoProdottoBusiness getInstance(){
        if (istanza == null) {
            istanza = new ConfermaInserimentoProdottoBusiness();
        }
        return istanza;
    }


    public ConfermaInserimentoProdottoBusiness confermaProdotto( String nomeProdotto,String descrizione,float costo,String nomeProduttore,String categoriaProdotto,int Disponibilita,int pCorsia,int pScaffale){
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
        //pos = posizioneDAO.

        //



        return null;
    }
}
