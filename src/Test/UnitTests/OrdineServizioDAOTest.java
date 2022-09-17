package Test.UnitTests;

import DAO.*;
import DAO.Interfaces.*;
import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;
import Model.Categoria;
import Model.OrdineServizio;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class OrdineServizioDAOTest {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
    IServizioDAO servizioDAO = ServizioDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();

    @Before
    public void setUp() {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra"), 1);

        categoriaDAO.add(new Categoria("Mobili"));
        fornitoreDAO.add(new Fornitore("MontaggioINC", "www.montaggioinc.it"));

        Categoria categoria = categoriaDAO.findByNome("Mobili");
        Fornitore fornitore = fornitoreDAO.findByNome("MontaggioINC");

        servizioDAO.add(new Servizio("Montaggio", 13.5f), categoria.getIdCategoria(), fornitore.getIdFornitore());
        Servizio servizio = servizioDAO.findByNome("Montaggio");

        ordineServizioDAO.add(new OrdineServizio(servizio.getIdServizio(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()));
    }

    @After
    public void tearDown() throws SQLException {
        if (servizioDAO.findByNome("Montaggio") != null) {
            ordineServizioDAO.removeByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio());
        }
        servizioDAO.removeByNome("Montaggio");
        categoriaDAO.removeByName("Mobili");
        fornitoreDAO.removeByName("MontaggioINC");
        utenteDAO.removeByUsername("Frama19");
    }

    @Test
    public void testFindAll() {
        assert ordineServizioDAO.findAll().size() >= 1;
    }

    @Test
    public void testFindAllWrong() {
        assert ordineServizioDAO.findAll().size() < 1;
    }

    @Test
    public void testFindByIDServizio() {
        assert ordineServizioDAO.findByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio()).size() == 1;
    }

    @Test
    public void testFindByIDServizioWrong() {
        assert ordineServizioDAO.findByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio()).size() != 1;
    }

    @Test
    public void testFindByIDListaAcquisto() {
        assert ordineServizioDAO.findByIDListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()).size() == 1;
    }

    @Test
    public void testFindByIDListaAcquistoWrong() {
        assert ordineServizioDAO.findByIDListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()).size() != 1;
    }

    @Test
    public void findTest() {
        assert ordineServizioDAO.find(servizioDAO.findByNome("Montaggio").getIdServizio(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()) != null;
    }

    @Test
    public void findTestWrong() {
        assert ordineServizioDAO.find(servizioDAO.findByNome("Montaggio").getIdServizio(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()) == null;
    }

    @Test
    public void removeTest() {
        ordineServizioDAO.removeByID(servizioDAO.findByNome("Montaggio").getIdServizio(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto());
        assert ordineServizioDAO.findByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio()).size() == 0;
    }

    @Test
    public void removeTestWrong() {
        ordineServizioDAO.removeByID(servizioDAO.findByNome("Montaggio").getIdServizio(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto());
        assert ordineServizioDAO.findByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio()).size() != 0;
    }

    @Test
    public void removeByIDServizioTest() {
        ordineServizioDAO.removeByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio());
        assert ordineServizioDAO.findByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio()).size() == 0;
    }

    @Test
    public void removeByIDServizioTestWrong() {
        ordineServizioDAO.removeByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio());
        assert ordineServizioDAO.findByIDServizio(servizioDAO.findByNome("Montaggio").getIdServizio()).size() != 0;
    }

    @Test
    public void removeByIDListaAcquistoTest() {
        ordineServizioDAO.removeByIDListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto());
        assert ordineServizioDAO.findByIDListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()).size() == 0;
    }

    @Test
    public void removeByIDListaAcquistoTestWrong() {
        ordineServizioDAO.removeByIDListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto());
        assert ordineServizioDAO.findByIDListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()).size() != 0;
    }
}
