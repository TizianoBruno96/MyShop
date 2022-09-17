package Business;

import DAO.Interfaces.IListaAcquistoDAO;
import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.Interfaces.IOrdineServizioDAO;
import DAO.ListaAcquistoDAO;
import DAO.OrdineProdottoDAO;
import DAO.OrdineServizioDAO;
import Model.ListaAcquisto;
import Views.AccessoUtente;

public class ConfermaAcquistoBusiness {
    private static ConfermaAcquistoBusiness instance;
    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();

    public static synchronized ConfermaAcquistoBusiness getInstance() {
        if (instance == null) {
            instance = new ConfermaAcquistoBusiness();
        }
        return instance;
    }

    public void confermaAcquisto() {
        ListaAcquisto ls = listaAcquistoDAO.findByIDUtente(AccessoUtente.getIdUtente());
        ordineProdottoDAO.removeByIDListaAcquisto(ls.getIdListaAcquisto());
        ordineServizioDAO.removeByIDListaAcquisto(ls.getIdListaAcquisto());
    }
}
