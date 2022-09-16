package Business;

import DAO.Interfaces.IListaAcquistoDAO;
import DAO.Interfaces.IOrdineServizioDAO;
import DAO.OrdineServizioDAO;
import Model.OrdineServizio;
import Views.AccessoUtente;

import java.util.ArrayList;

public class OrdineServizioBusiness {
    private static OrdineServizioBusiness instance;
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = DAO.ListaAcquistoDAO.getInstance();

    public static synchronized OrdineServizioBusiness getInstance() {
        if (instance == null) {
            instance = new OrdineServizioBusiness();
        }
        return instance;
    }

    public void InserisciLista(ArrayList<Integer> idServizi) {
        int idLista = listaAcquistoDAO.findByIDUtente(AccessoUtente.getIdUtente()).getIdListaAcquisto();

        //ciclo sull'array
        for (Integer integer : idServizi) {
            //creo un nuovo ordineServizio
            OrdineServizio os = new OrdineServizio(integer, idLista);
            //controllo che l'ordine non esista già
            if (ordineServizioDAO.find(integer, idLista) != null) return;
            ordineServizioDAO.add(os);
        }
    }
}
