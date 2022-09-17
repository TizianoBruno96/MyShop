package Business;

import DAO.Interfaces.IRecensioneDAO;
import DAO.RecensioneDAO;
import Model.Recensione;

import java.util.List;

public class EliminaRecensioneBusiness {
    private static EliminaRecensioneBusiness instance;
    IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();

    public static EliminaRecensioneBusiness getinstance() {
        if (instance == null) {
            instance = new EliminaRecensioneBusiness();
        }
        return instance;
    }

    public void eliminaRecensioni(int[] idRecensioni) {
        for (int i : idRecensioni) {
            recensioneDAO.remove(i);
        }
    }
}
