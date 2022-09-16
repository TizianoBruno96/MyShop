package Business;

import DAO.Interfaces.*;
import DAO.ListaAcquistoDAO;
import DAO.OrdineProdottoDAO;
import DAO.OrdineServizioDAO;
import DAO.UtenteDAO;
import Model.ListaAcquisto;

public class RimozioneUtenteBusiness {
    private static RimozioneUtenteBusiness instance;
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
    IRecensioneDAO recensioneDAO = DAO.RecensioneDAO.getInstance();

    public static RimozioneUtenteBusiness getInstance() {
        if (instance == null) {
            instance = new RimozioneUtenteBusiness();
        }
        return instance;
    }

    public void rimuoviUtente(String username) {
        ListaAcquisto ls = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername(username).getIdUtente());

        try {
            recensioneDAO.removeByUtente(utenteDAO.findByUsername(username).getIdUtente());
            ordineServizioDAO.removeByIDListaAcquisto(ls.getIdListaAcquisto());
            ordineProdottoDAO.removeByIDListaAcquisto(ls.getIdListaAcquisto());
            utenteDAO.removeByUsername(username);
        } catch (Exception e) {
            System.out.println("Errore rimozione utente");
        }
    }
}
