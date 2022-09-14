package Test.UnitTests;

import DAO.FornitoreDAO;
import DAO.Interfaces.IFornitoreDAO;
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
        fornitoreDAO.removeByName("TavoliINC2");
    }

    @Test
    public void findByNameTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        Fornitore fornitore = fornitoreDAO.findByNome("SedieINC");
        assert fornitore.getNome().equals("SedieINC");
    }
    @Test
    public void findByNameTestWrong() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        Fornitore fornitore = fornitoreDAO.findByNome("SedieINC");
        assert fornitore.getNome().equals("SedieINC2");
    }

    @Test
    public void findAllTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        assert fornitoreDAO.findAll().size() >= 2;
    }
    @Test
    public void findAllTestWrong() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        assert fornitoreDAO.findAll().size() == 1;
    }

    @Test
    public void updateTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        Fornitore fornitore = fornitoreDAO.findByNome("SedieINC");
        fornitore.setNome("TavoliINC2");
        fornitoreDAO.update(fornitore);
        assert fornitore.getNome().equals("TavoliINC2");
    }
    @Test
    public void updateTestWrong() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        Fornitore fornitore = fornitoreDAO.findByNome("SedieINC");
        fornitore.setNome("TavoliINC2");
        fornitoreDAO.update(fornitore);
        assert fornitore.getNome().equals("TavoliINC4");
    }

    @Test
    public void removeByNameTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        fornitoreDAO.removeByName("SedieINC");
        assert fornitoreDAO.findAll().size() >= 1;
    }
    @Test
    public void removeByNameTestWrong() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        fornitoreDAO.removeByName("SedieINC");
        assert fornitoreDAO.findAll().size() == 0;
    }

    @Test
    public void checkNomeTest() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        assert fornitoreDAO.checkNome("SedieINC");
    }
    @Test
    public void checkNomeTestWrong() {
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
        assert !fornitoreDAO.checkNome("SedieINC");
    }
}