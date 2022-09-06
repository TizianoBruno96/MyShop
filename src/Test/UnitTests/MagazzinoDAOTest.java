package Test.UnitTests;

import DAO.*;
import Model.Magazzino;
import Model.PuntoVendita;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class MagazzinoDAOTest {
    IMagazzinoDAO magazzinoDAO = MagazzinoDAO.getInstance();
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();

    @Before
    public void setUp() {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra", "MN"), 1);
        Utente utente = utenteDAO.findByUsername("Frama19");

        puntoVenditaDAO.add(new PuntoVendita("Milano", "MilanoShop", "Piazzale Loreto 27"), utente.getIdUtente());
        magazzinoDAO.add(new Magazzino(10, 15), puntoVenditaDAO.findByManager(utente.getIdUtente()).getIdPuntoVendita());
    }

    @After
    public void tearDown() throws SQLException {

        magazzinoDAO.removeByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        puntoVenditaDAO.removeByIDManager(utenteDAO.findByUsername("Frama19").getIdUtente());
        utenteDAO.removeByUsername("Frama19");
    }

    @Test
    public void findByPuntoVenditaTest() {
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        assert magazzino.getMaxCorsia() == 10;
        assert magazzino.getMaxScaffale() == 15;
    }

    @Test
    public void updateTest() {
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        magazzino.setMaxCorsia(20);
        magazzino.setMaxScaffale(25);
        magazzinoDAO.update(magazzino);
        magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        assert magazzino.getMaxCorsia() == 20;
        assert magazzino.getMaxScaffale() == 25;
    }

    @Test
    public void removeByPuntoVenditaTest() {
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        magazzinoDAO.removeByPuntoVendita(magazzino.getIdPuntoVendita());
        magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        assert magazzino == null;
    }

    @Test
    public void addTest() {
        magazzinoDAO.removeByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        magazzinoDAO.add(new Magazzino(14, 12), puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        assert magazzino.getMaxCorsia() == 14;
        assert magazzino.getMaxScaffale() == 12;
    }

    @Test
    public void removeByIDTest() {
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        magazzinoDAO.removeByID(magazzino.getIdMagazzino());
        magazzino = magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        assert magazzino == null;
    }

    @Test
    public void findAllTest() {
        assert magazzinoDAO.findAll().size() == puntoVenditaDAO.findAll().size();
    }
}
