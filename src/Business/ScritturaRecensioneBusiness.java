package Business;

import DAO.Interfaces.IRecensioneDAO;
import DAO.RecensioneDAO;
import Model.Recensione;
import Views.AccessoUtente;

public class ScritturaRecensioneBusiness {
    private static ScritturaRecensioneBusiness instance;
    IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();

    public static synchronized ScritturaRecensioneBusiness getInstance() {
        if (instance == null) {
            instance = new ScritturaRecensioneBusiness();
        }
        return instance;
    }

    public void scriviRecensione(String testo, int voto, int idProdotto) {
        Recensione recensione = new Recensione(voto, testo, idProdotto, AccessoUtente.getIdUtente());
        if (recensioneDAO.find(idProdotto, AccessoUtente.getIdUtente()) == null) {
            recensioneDAO.add(recensione);
        } else {
            recensione = recensioneDAO.find(idProdotto, AccessoUtente.getIdUtente());
            recensione.setCommento(testo);
            recensione.setVoto(voto);
            recensioneDAO.update(recensione);
        }
    }
}
