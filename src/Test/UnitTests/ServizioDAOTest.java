package Test.UnitTests;

import DAO.*;
import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;
import Model.Categoria;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServizioDAOTest {
    IServizioDAO servizioDAO = ServizioDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();

    @Before
    public void setUp() {
        categoriaDAO.add(new Categoria("Mobili"));
        fornitoreDAO.add(new Fornitore("MontaggioINC", "www.montaggioinc.it"));

        Categoria categoria = categoriaDAO.findByNome("Mobili");
        Fornitore fornitore = fornitoreDAO.findByNome("MontaggioINC");

        servizioDAO.add(new Servizio("Montaggio", 13.5f), categoria.getIdCategoria(), fornitore.getIdFornitore());
    }

    @After
    public void tearDown() {
        servizioDAO.removeByNome("Montaggio3");
        servizioDAO.removeByNome("Montaggio2");
        servizioDAO.removeByNome("Montaggio");
        categoriaDAO.removeByName("Mobili");
        fornitoreDAO.removeByName("MontaggioINC");
    }

    @Test
    public void testFindAll() {
        assert servizioDAO.findAll().size() == 1;
    }

    @Test
    public void addTest() {
        Categoria categoria = categoriaDAO.findByNome("Mobili");
        Fornitore fornitore = fornitoreDAO.findByNome("MontaggioINC");

        servizioDAO.add(new Servizio("Montaggio2", 13.5f), categoria.getIdCategoria(), fornitore.getIdFornitore());
        assert servizioDAO.findAll().size() == 2;
    }

    @Test
    public void removeByNomeTest() {
        servizioDAO.removeByNome("Montaggio");
        assert servizioDAO.findAll().size() == 0;
    }

    @Test
    public void removeByIDTest() {
        Servizio servizio = servizioDAO.findByNome("Montaggio");
        servizioDAO.removeByID(servizio.getIdServizio());
        assert servizioDAO.findAll().size() == 0;
    }

    @Test
    public void removeByFornitoreTest() {
        Fornitore fornitore = fornitoreDAO.findByNome("MontaggioINC");
        servizioDAO.removeByFornitore(fornitore.getIdFornitore());
        assert servizioDAO.findAll().size() == 0;
    }

    @Test
    public void updateTest() {
        Servizio servizio = servizioDAO.findByNome("Montaggio");
        servizio.setNome("Montaggio3");
        servizioDAO.update(servizio);
        assert servizioDAO.findByNome("Montaggio3") != null;
    }

    @Test
    public void findByNomeTest() {
        assert servizioDAO.findByNome("Montaggio") != null;
    }

    @Test
    public void findByIDTest() {
        Servizio servizio = servizioDAO.findByNome("Montaggio");
        assert servizioDAO.findByID(servizio.getIdServizio()) != null;
    }

    @Test
    public void findByFornitoreTest() {
        Fornitore fornitore = fornitoreDAO.findByNome("MontaggioINC");
        assert servizioDAO.findByFornitore(fornitore.getIdFornitore()).size() == 1;
    }

    @Test
    public void findByCategoriaTest() {
        Categoria categoria = categoriaDAO.findByNome("Mobili");
        assert servizioDAO.findByCategoria(categoria.getIdCategoria()).size() == 1;
    }
}
