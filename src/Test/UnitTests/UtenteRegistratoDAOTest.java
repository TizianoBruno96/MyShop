package Test.UnitTests;

import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class UtenteRegistratoDAOTest {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IUtenteRegistratoDAO utenteRegistratoDAO = DAO.UtenteRegistratoDAO.getInstance();
    IPuntoVenditaDAO puntoVenditaDAO = DAO.PuntoVenditaDAO.getInstance();

    @Before
    public void setUp() {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra"), 1);
        utenteDAO.add(new Utente("Francesco", "Marroni", "Gigiux12", "Francesco.Marroni@Studenti.unisalento.it", "0832759618", 20, "Via del bosco 20", "muratore", "Giorgio"), 1);
    }

    @After
    public void tearDown() throws SQLException {
        if (utenteDAO.findByUsername("Frama19") != null) {
            utenteDAO.removeByUsername("Frama19");
        }
        if (utenteDAO.findByUsername("Gigiux12") != null) {
            utenteDAO.removeByUsername("Gigiux12");
        }
    }

    @Test
    public void findByUtenteTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        assert utenteRegistratoDAO.findByUtente(utente.getIdUtente()).size() >= 1;
    }

    @Test
    public void findByUtenteTestWrong() {
        Utente utente = utenteDAO.findByUsername("Gigiux12");
        assert utenteRegistratoDAO.findByUtente(utente.getIdUtente()).size() < 1;
    }

    @Test
    public void findByPuntoVenditaTest() {
        assert utenteRegistratoDAO.findByPuntoVendita(1).size() >= 2;
    }

    @Test
    public void findByPuntoVenditaTestWrong() {
        System.out.println(utenteRegistratoDAO.findByPuntoVendita(1).size());
        assert utenteRegistratoDAO.findByPuntoVendita(1).size() < 2;
    }
}
