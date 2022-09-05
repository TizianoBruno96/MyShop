package UnitTests;

import DAO.*;
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

    @Before
    public void setUp() {

        Categoria sedie = new Categoria("Sedie");
        Categoria tavoli = new Categoria("Tavoli");

        Produttore SedieINC = new Produttore("SedieINC", "www.sedieinc.it", "Milano", "Italia");
        Produttore TavoliINC = new Produttore("TavoliINC", "www.tavoliinc.it", "Milano", "Italia");

        //Creo le categorie
        categoriaDAO.add(sedie);
        categoriaDAO.add(tavoli);

        //Creo i produttori
        produttoreDAO.add(SedieINC);
        produttoreDAO.add(TavoliINC);

        sedie = categoriaDAO.findByNome("Sedie");
        tavoli = categoriaDAO.findByNome("Tavoli");
        SedieINC = produttoreDAO.findByNome("SedieINC");
        TavoliINC = produttoreDAO.findByNome("TavoliINC");


        //Creo i prodotti
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Rossa", "Sedia da ufficio", 10.5f), sedie, SedieINC);
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Bianca", "Sedia da ufficio", 12.4f), sedie, SedieINC);
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Blu", "Tavolo da ufficio", 15.5f), tavoli, TavoliINC);
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Magenta", "Tavolo da ufficio", 17.4f), tavoli, TavoliINC);
    }

    @After
    public void tearDown() {
        //Elimino i prodotti
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
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
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
    public void findAllTest() {
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        assert prodottoDAO.findAll().size() == 4;
    }

    @Test
    public void removeTest() {
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.remove(prodotto);
        assert prodottoDAO.findAll().size() == 3;
    }

    @Test
    public void removeByNomeTest() {
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        assert prodottoDAO.findAll().size() == 3;
    }

    @Test
    public void updateTest() {
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodotto.setNome("Sedia Da Ufficio Rossa Modificata");
        prodottoDAO.update(prodotto);
        assert prodottoDAO.findByNome("Sedia Da Ufficio Rossa Modificata").getNome().equals("Sedia Da Ufficio Rossa Modificata");
    }
}
