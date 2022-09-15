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
import Model.Articoli.ProdottoComposito;
import Model.Articoli.Produttore;
import Model.Categoria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProdottoCompositoDAOTest {
    IProdottoCompositoDAO prodottoCompositoDAO = ProdottoCompositoDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();

    @Before
    public void setUp() {
        categoriaDAO.add(new Categoria("Sedie"));
        produttoreDAO.add(new Produttore("SedieINC", "www.sedieinc.it", "Milano", "Italia"));
        Categoria sedie = categoriaDAO.findByNome("Sedie");
        Produttore SedieINC = produttoreDAO.findByNome("SedieINC");

        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Rossa", "Sedia da ufficio", 10.5f), sedie, SedieINC);
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Bianca", "Sedia da ufficio", 12.4f), sedie, SedieINC);
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");

        prodottoCompositoDAO.add(new ProdottoComposito(padre.getIdProdotto(), figlio.getIdProdotto()));
    }

    @After
    public void tearDown() {
        if (prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null && prodottoDAO.findByNome("Sedia Da Ufficio Bianca") != null)
            prodottoCompositoDAO.remove(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), prodottoDAO.findByNome("Sedia Da Ufficio Bianca").getIdProdotto());
        if (prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null && prodottoDAO.findByNome("Sedia Da Ufficio Verde") != null)
            prodottoCompositoDAO.remove(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), prodottoDAO.findByNome("Sedia Da Ufficio Verde").getIdProdotto());


        prodottoDAO.removeByNome("Sedia Da Ufficio Verde");
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.removeByNome("Sedia Da Ufficio Bianca");
        categoriaDAO.removeByName("Sedie");
        produttoreDAO.removeByNome("SedieINC");
    }

    @Test
    public void addTest() {
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Verde", "Sedia da ufficio", 10.8f), categoriaDAO.findByNome("Sedie"), produttoreDAO.findByNome("SedieINC"));

        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Verde");

        prodottoCompositoDAO.add(new ProdottoComposito(padre.getIdProdotto(), figlio.getIdProdotto()));
        assert (prodottoCompositoDAO.find(padre.getIdProdotto(), figlio.getIdProdotto()) != null);
    }

    @Test
    public void addTestWrong() {
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Verde", "Sedia da ufficio", 10.8f), categoriaDAO.findByNome("Sedie"), produttoreDAO.findByNome("SedieINC"));

        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Verde");

        prodottoCompositoDAO.add(new ProdottoComposito(padre.getIdProdotto(), figlio.getIdProdotto()));
        assert (prodottoCompositoDAO.find(padre.getIdProdotto(), figlio.getIdProdotto()) == null);
    }

    @Test
    public void findByIDFiglioTest() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        assert prodottoCompositoDAO.findByIDFiglio(figlio.getIdProdotto()).get(0).getIdProdottoPadre() == padre.getIdProdotto();
    }

    @Test
    public void findByIDFiglioTestWrong() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        assert prodottoCompositoDAO.findByIDFiglio(figlio.getIdProdotto()).get(0).getIdProdottoPadre() != padre.getIdProdotto();
    }

    @Test
    public void findByIDPadreTest() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        assert prodottoCompositoDAO.findByIDPadre(padre.getIdProdotto()).get(0).getIdProdottoFiglio() == figlio.getIdProdotto();
    }

    @Test
    public void findByIDPadreTestWrong() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        assert prodottoCompositoDAO.findByIDPadre(padre.getIdProdotto()).get(0).getIdProdottoFiglio() != figlio.getIdProdotto();
    }

    @Test
    public void findAllTest() {
        assert prodottoCompositoDAO.findAll().size() >= 1;
    }

    @Test
    public void findAllTestWrong() {
        assert prodottoCompositoDAO.findAll().size() < 1;
    }

    @Test
    public void removeTest() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        prodottoCompositoDAO.remove(padre.getIdProdotto(), figlio.getIdProdotto());
        assert prodottoCompositoDAO.find(padre.getIdProdotto(), figlio.getIdProdotto()) == null;
    }

    @Test
    public void removeTestWrong() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        prodottoCompositoDAO.remove(padre.getIdProdotto(), figlio.getIdProdotto());
        assert prodottoCompositoDAO.find(padre.getIdProdotto(), figlio.getIdProdotto()) != null;
    }

    @Test
    public void removeByIDPadreTest() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoCompositoDAO.removeByIDPadre(padre.getIdProdotto());
        assert prodottoCompositoDAO.findByIDPadre(padre.getIdProdotto()).size() == 0;
    }

    @Test
    public void removeByIDPadreTestWrong() {
        Prodotto padre = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        prodottoCompositoDAO.removeByIDPadre(padre.getIdProdotto());
        assert prodottoCompositoDAO.findByIDPadre(padre.getIdProdotto()).size() != 0;
    }

    @Test
    public void removeByIDFiglioTest() {
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        prodottoCompositoDAO.removeByIDFiglio(figlio.getIdProdotto());
        assert prodottoCompositoDAO.findAll().size() == 0;
    }

    @Test
    public void removeByIDFiglioTestWrong() {
        Prodotto figlio = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        prodottoCompositoDAO.removeByIDFiglio(figlio.getIdProdotto());
        assert prodottoCompositoDAO.findAll().size() != 0;
    }
}
