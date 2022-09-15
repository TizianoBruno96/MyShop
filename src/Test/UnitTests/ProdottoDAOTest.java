package Test.UnitTests;

import DAO.CategoriaDAO;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IProdottoCompositoDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.Interfaces.IProduttoreDAO;
import DAO.ProdottoCompositoDAO;
import DAO.ProdottoDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProdottoDAOTest {
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IProdottoCompositoDAO prodottoCompositoDAO = ProdottoCompositoDAO.getInstance();

    @Before
    public void setUp() {
        //Creo le categorie
        categoriaDAO.add(new Categoria("Sedie"));
        categoriaDAO.add(new Categoria("Tavoli"));

        //Creo i produttori
        produttoreDAO.add(new Produttore("SedieINC", "www.sedieinc.it", "Milano", "Italia"));
        produttoreDAO.add(new Produttore("TavoliINC", "www.tavoliinc.it", "Milano", "Italia"));

        Categoria sedie = categoriaDAO.findByNome("Sedie");
        Categoria tavoli = categoriaDAO.findByNome("Tavoli");
        Produttore SedieINC = produttoreDAO.findByNome("SedieINC");
        Produttore TavoliINC = produttoreDAO.findByNome("TavoliINC");


        //Creo i prodotti
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Rossa", "Sedia da ufficio", 10.5f), sedie, SedieINC);
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Bianca", "Sedia da ufficio", 12.4f), sedie, SedieINC);
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Blu", "Tavolo da ufficio", 15.5f), tavoli, TavoliINC);
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Magenta", "Tavolo da ufficio", 17.4f), tavoli, TavoliINC);
    }

    @After
    public void tearDown() {
        //Elimino i prodotti compositi
        if (prodottoDAO.findByNome("Sedia Da Ufficio Verde") != null && prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null)
            prodottoCompositoDAO.remove(prodottoDAO.findByNome("Sedia Da Ufficio Verde").getIdProdotto(), prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto());

        //Elimino i prodotti
        prodottoDAO.removeByNome("Sedia Da Ufficio Verde");
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.removeByNome("Sedia Da Ufficio Bianca");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Blu");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Magenta");

        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa Modificata");

        //Elimino le categorie
        categoriaDAO.removeByName("Sedie");
        categoriaDAO.removeByName("Tavoli");

        //Elimino i produttori
        produttoreDAO.removeByNome("SedieINC");
        produttoreDAO.removeByNome("TavoliINC");
    }

    @Test
    public void findbyNomeTest() {
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        assert prodotto.getNome().equals("Sedia Da Ufficio Rossa");
        Prodotto prodotto2 = prodottoDAO.findByNome("Tavolo Da Ufficio Magenta");
        assert prodotto2.getNome().equals("Tavolo Da Ufficio Magenta");
        Prodotto prodotto3 = prodottoDAO.findByNome("Tavolo Da Ufficio Blu");
        assert prodotto3.getNome().equals("Tavolo Da Ufficio Blu");
        Prodotto prodotto4 = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        assert prodotto4.getNome().equals("Sedia Da Ufficio Bianca");
    }

    @Test
    public void findbyNomeTestWrong() {
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        assert prodotto.getNome().equals("Sedia Da Ufficio Rossa3");
        Prodotto prodotto2 = prodottoDAO.findByNome("Tavolo Da Ufficio Magenta");
        assert prodotto2.getNome().equals("Tavolo Da Ufficio Magenta1");
        Prodotto prodotto3 = prodottoDAO.findByNome("Tavolo Da Ufficio Blu");
        assert prodotto3.getNome().equals("Tavolo Da Ufficio Blu4");
        Prodotto prodotto4 = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        assert prodotto4.getNome().equals("Sedia Da Ufficio Bianca5");
    }

    @Test
    public void findAllTest() {
        assert prodottoDAO.findAll().size() >= 4;
    }

    @Test
    public void findAllTestWrong() {
        assert prodottoDAO.findAll().size() < 4;
    }

    @Test
    public void removeTest() {
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.remove(prodotto);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa") == null;
    }

    @Test
    public void removeTestWrong() {
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.remove(prodotto);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null;
    }

    @Test
    public void removeByNomeTest() {
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa") == null;
    }

    @Test
    public void removeByNomeTestWrong() {
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null;
    }

    @Test
    public void updateTest() {
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodotto.setNome("Sedia Da Ufficio Rossa Modificata");
        prodottoDAO.update(prodotto);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa Modificata").getNome().equals("Sedia Da Ufficio Rossa Modificata");
    }

    @Test
    public void updateTestWrong() {
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodotto.setNome("Sedia Da Ufficio Rossa Modificata");
        prodottoDAO.update(prodotto);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa Modificata").getNome().equals("Sedia Da Ufficio Rossa Modificata4");
    }

    @Test
    public void findByCategoriaTest() {
        Categoria sedie = categoriaDAO.findByNome("Sedie");
        assert prodottoDAO.findByCategoria(sedie.getIdCategoria()).size() >= 2;
    }

    @Test
    public void findByCategoriaTestWrong() {
        Categoria sedie = categoriaDAO.findByNome("Sedie");
        assert prodottoDAO.findByCategoria(sedie.getIdCategoria()).size() < 2;
    }

    @Test
    public void checkNomeTest() {
        assert prodottoDAO.checkNome("Sedia Da Ufficio Rossa");
    }

    @Test
    public void checkNomeTestWrong() {
        assert !prodottoDAO.checkNome("Sedia Da Ufficio Rossa");
    }

    @Test
    public void findByProduttoreTest() {
        Produttore sedie = produttoreDAO.findByNome("SedieINC");
        assert prodottoDAO.findByProduttore(sedie.getIdProduttore()).size() >= 2;
    }

    @Test
    public void findByProduttoreTestWrong() {
        Produttore sedie = produttoreDAO.findByNome("SedieINC");
        assert prodottoDAO.findByProduttore(sedie.getIdProduttore()).size() < 2;
    }

    @Test
    public void updateCategoriaTest() {
        Categoria tavoli = categoriaDAO.findByNome("Tavoli");
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.updateCategoria(prodotto, tavoli);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdCategoria() == tavoli.getIdCategoria();
    }

    @Test
    public void updateCategoriaTestWrong() {
        Categoria tavoli = categoriaDAO.findByNome("Tavoli");
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.updateCategoria(prodotto, tavoli);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdCategoria() != tavoli.getIdCategoria();
    }

    @Test
    public void updateProduttoreTest() {
        Produttore sedie = produttoreDAO.findByNome("SedieINC");
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.updateProduttore(prodotto, sedie);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProduttore() == sedie.getIdProduttore();
    }

    @Test
    public void updateProduttoreTestWrong() {
        Produttore sedie = produttoreDAO.findByNome("SedieINC");
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.updateProduttore(prodotto, sedie);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProduttore() != sedie.getIdProduttore();
    }
}
