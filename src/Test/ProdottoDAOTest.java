package Test;

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
        //Creo le categorie
        categoriaDAO.add(new Categoria("Sedie"));
        categoriaDAO.add(new Categoria("Tavoli"));

        //Creo i produttori
        produttoreDAO.add(new Produttore("SedieINC", "www.sedieinc.it", "Milano", "Italia"));
        produttoreDAO.add(new Produttore("TavoliINC", "www.tavoliinc.it", "Milano", "Italia"));

        //Creo i prodotti
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Rossa", "Sedia da ufficio", 10.5f), "Sedie", "SedieINC");
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Bianca", "Sedia da ufficio", 12.4f), "Sedie", "SedieINC");
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Blu", "Tavolo da ufficio", 15.5f), "Tavoli", "TavoliINC");
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Magenta", "Tavolo da ufficio", 17.4f), "Tavoli", "TavoliINC");
    }

    @After
    public void tearDown() {
        //Elimino i prodotti
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.removeByNome("Sedia Da Ufficio Bianca");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Blu");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Magenta");

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
    }
}
