package Test.UnitTests;

import DAO.Interfaces.IProduttoreDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Produttore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProduttoreDAOTest {
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();

    @Before
    public void setUp() {
        produttoreDAO.add(new Produttore("SedieINC", "Milano", "Italia", "www.sedieinc.it"));
        produttoreDAO.add(new Produttore("TavoliINC", "Parigi", "Francia", "www.tavoliinc.it"));
    }

    @After
    public void tearDown() {
        produttoreDAO.removeByNome("SedieINC");
        produttoreDAO.removeByNome("TavoliINC");
    }

    @Test
    public void findByNomeTest() {
        Produttore produttore = produttoreDAO.findByNome("SedieINC");
        assert produttore.getNome().equals("SedieINC");
    }

    @Test
    public void findAllTest() {
        System.out.println(produttoreDAO.findAll().size());
        assert produttoreDAO.findAll().size() == 2;
    }

    @Test
    public void updateTest() {
        Produttore produttore = produttoreDAO.findByNome("SedieINC");
        produttore.setNome("TappetiINC");
        produttoreDAO.update(produttore);
        assert produttore.getNome().equals("TappetiINC");
        produttoreDAO.removeByNome("TappetiINC");
    }

    @Test
    public void removeByNomeTest() {
        produttoreDAO.removeByNome("SedieINC");
        assert produttoreDAO.findAll().size() == 1;
    }
}
