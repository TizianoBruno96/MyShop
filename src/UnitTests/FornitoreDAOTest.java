package UnitTests;

import DAO.FornitoreDAO;
import DAO.IFornitoreDAO;
import Model.Articoli.Fornitore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FornitoreDAOTest {
    @Before
    public void setUp() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        fornitoreDAO.add(new Fornitore("SedieINC", "www.sedieinc.it"));
        fornitoreDAO.add(new Fornitore("TavoliINC", "www.tavoliinc.it"));
    }

    @After
    public void tearDown() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        fornitoreDAO.removeByName("SedieINC");
        fornitoreDAO.removeByName("TavoliINC");
    }

    @Test
    public void findByNameTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        Fornitore fornitore = fornitoreDAO.findByNome("SedieINC");
        assert fornitore.getNome().equals("SedieINC");
    }

    @Test
    public void findAllTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        assert fornitoreDAO.findAll().size() == 2;
    }

    @Test
    public void updateTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        Fornitore fornitore = fornitoreDAO.findByNome("SedieINC");
        fornitore.setNome("TavoliINC");
        fornitoreDAO.update(fornitore);
        assert fornitore.getNome().equals("TavoliINC");
    }

    @Test
    public void removeByNameTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        fornitoreDAO.removeByName("SedieINC");
        assert fornitoreDAO.findAll().size() == 1;
    }
}