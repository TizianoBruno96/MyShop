package Business;

import DAO.Interfaces.IListaAcquistoDAO;
import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.Interfaces.IOrdineServizioDAO;
import DAO.OrdineProdottoDAO;
import DAO.OrdineServizioDAO;
import Model.ListaAcquisto;
import Views.AccessoUtente;

import java.util.ArrayList;

public class ConfermaRimozioneBusiness {
    private static ConfermaRimozioneBusiness instance;

    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = DAO.ListaAcquistoDAO.getInstance();

    public static ConfermaRimozioneBusiness getInstance() {
        if (instance == null) {
            instance = new ConfermaRimozioneBusiness();
        }
        return instance;
    }

    public void confermaRimozione(ArrayList<Integer> idProdotti, ArrayList<Integer> idServizi) {
        ListaAcquisto ls = listaAcquistoDAO.findByIDUtente(AccessoUtente.getIdUtente());

        for (int idProdotto : idProdotti) {
            ordineProdottoDAO.removeByID(idProdotto, ls.getIdListaAcquisto());
        }

        for (int idServizio : idServizi) {
            ordineServizioDAO.removeByID(idServizio, ls.getIdListaAcquisto());
        }
    }
}
