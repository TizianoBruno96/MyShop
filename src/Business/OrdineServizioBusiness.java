package Business;

import DAO.Interfaces.IOrdineServizioDAO;
import DAO.OrdineServizioDAO;
import Model.OrdineServizio;
import Views.AccessoUtente;

import java.util.ArrayList;

public class OrdineServizioBusiness {
    private static OrdineServizioBusiness instance;
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();

    public static synchronized OrdineServizioBusiness getInstance() {
        if (instance == null) {
            instance = new OrdineServizioBusiness();
        }
        return instance;
    }

    public void InserisciLista(ArrayList<Integer> idServizi) {

        //ciclo sull'array
        for (int i = 0; i < idServizi.size(); i++) {
            //creo un nuovo ordineServizio
            OrdineServizio os = new OrdineServizio(idServizi.get(i), AccessoUtente.getIdPuntoVendita());
            ordineServizioDAO.add(os);
        }
    }
}
