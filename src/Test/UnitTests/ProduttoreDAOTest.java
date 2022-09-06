package Test.UnitTests;

import DAO.IProduttoreDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Produttore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProduttoreDAOTest {
    @Before
    public void setUp() {
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        produttoreDAO.add(new Produttore("SedieINC", "Milano", "Italia", "www.sedieinc.it"));
        produttoreDAO.add(new Produttore("TavoliINC", "Parigi", "Francia", "www.tavoliinc.it"));
    }

    @After
    public void tearDown() {
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        produttoreDAO.removeByNome("SedieINC");
        produttoreDAO.removeByNome("TavoliINC");
    }

    @Test
    public void findByNomeTest() {
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        Produttore produttore = produttoreDAO.findByNome("SedieINC");
        assert produttore.getNome().equals("SedieINC");
    }

    @Test
    public void findAllTest() {
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        System.out.println(produttoreDAO.findAll().size());
        assert produttoreDAO.findAll().size() == 2;
    }

    @Test
    public void updateTest() {
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        Produttore produttore = produttoreDAO.findByNome("SedieINC");
        produttore.setNome("TappetiINC");
        produttoreDAO.update(produttore);
        assert produttore.getNome().equals("TappetiINC");
        produttoreDAO.removeByNome("TappetiINC");
    }

    @Test
    public void removeByNomeTest() {
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        produttoreDAO.removeByNome("SedieINC");
        assert produttoreDAO.findAll().size() == 1;
    }
}
