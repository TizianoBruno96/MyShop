package Test;

import DAO.IListaAcquistoDAO;
import DAO.IUtenteDAO;
import DAO.ListaAcquistoDAO;
import DAO.UtenteDAO;
import Model.ListaAcquisto;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class ListaAcquistoDAOTest {
    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();

    @Before
    public void setUp() {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra"), 1);
    }

    @After
    public void tearDown() throws SQLException {
        utenteDAO.removeByUsername("Frama19");
    }

    @Test
    public void findByIDUtenteTest() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        assert listaAcquisto.getIdUtente() == utenteDAO.findByUsername("Frama19").getIdUtente();
    }

    @Test
    public void findByIDTest() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        ListaAcquisto listaAcquisto1 = listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto());
        assert listaAcquisto1.getIdListaAcquisto() == listaAcquisto.getIdListaAcquisto();
    }

    @Test
    public void removeByIDUtenteTest() throws SQLException {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        listaAcquistoDAO.removeByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()) == null;
    }

    @Test
    public void removeByIDTest() throws SQLException {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        listaAcquistoDAO.removeByID(listaAcquisto.getIdListaAcquisto());
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()) == null;
    }

    @Test
    public void updateTest() throws SQLException {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        listaAcquisto.setCostoTot(100);
        listaAcquistoDAO.update(listaAcquisto);
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()).getCostoTot() == 100;
    }
}
