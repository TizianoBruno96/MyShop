package Test.UnitTests;

import DAO.Interfaces.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAOTest {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();

    @Before
    public void setUp() throws SQLException {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra"), 1);
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
    public void findByUsernameTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        assert utente.getUsername().equals("Frama19");
    }

    @Test
    public void findByUsernameTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        assert utente.getUsername().equals("Frama3119");
    }

    @Test
    public void addTest() {
        utenteDAO.add(new Utente("Francesco", "Marroni", "Gigiux12", "Francesco.Marroni@Studenti.unisalento.it", "0832759618", 20, "Via del bosco 20", "muratore", "Giorgio", "MN"));
        assert utenteDAO.findByUsername("Gigiux12") != null;
    }

    @Test
    public void addTestWrong() {
        utenteDAO.add(new Utente("Francesco", "Marroni", "Gigiux12", "Francesco.Marroni@Studenti.unisalento.it", "0832759618", 20, "Via del bosco 20", "muratore", "Giorgio", "MN"));
        assert utenteDAO.findByUsername("Gigiux12") == null;
    }

    @Test
    public void findAllTest() {
        ArrayList<Utente> utenti = utenteDAO.findAll();
        assert utenti.size() >= 5;
    }

    @Test
    public void findAllTestWrong() {
        ArrayList<Utente> utenti = utenteDAO.findAll();
        assert utenti.size() < 5;
    }

    @Test
    public void updateTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        utente.setPassword("Giuseppe");
        utenteDAO.update(utente);
        assert utente.getPassword().equals("Giuseppe");
    }

    @Test
    public void updateTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        utente.setPassword("Giuseppe");
        utenteDAO.update(utente);
        assert utente.getPassword().equals("Giuseppeeepino");
    }

    @Test
    public void removeByUsernameTest() throws SQLException {
        utenteDAO.removeByUsername("Frama19");
        assert utenteDAO.findByUsername("Frama19") == null;
    }

    @Test
    public void removeByUsernameTestWrong() throws SQLException {
        utenteDAO.removeByUsername("Frama19");
        assert utenteDAO.findByUsername("Frama19") != null;
    }

    @Test
    public void updateTipoTest() throws SQLException {
        utenteDAO.updateTipo("Frama19", "MN");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("MN");
        utenteDAO.updateTipo("Frama19", "CL");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("CL");
        utenteDAO.updateTipo("Frama19", "AM");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("AM");
    }

    @Test
    public void updateTipoTestWrong() throws SQLException {
        utenteDAO.updateTipo("Frama19", "MN");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("AM");
        utenteDAO.updateTipo("Frama19", "CL");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("MN");
        utenteDAO.updateTipo("Frama19", "AM");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("CL");
    }

    @Test
    public void checkUsernameTest() {
        assert utenteDAO.checkUsername("Frama19");
    }

    @Test
    public void checkUsernameTestWrong() {
        assert utenteDAO.checkUsername("Frama19120");
    }

    @Test
    public void checkUtenteTest() {
        assert utenteDAO.checkUtente("Frama19", "Gomorra");
    }

    @Test
    public void checkUtenteTestWrong() {
        assert !utenteDAO.checkUtente("Frama19", "Gomorra");
    }

    @Test
    public void isManagerTest() {
        assert !utenteDAO.isManager("Frama19");
    }

    @Test
    public void isManagerTestWrong() {
        assert utenteDAO.isManager("Frama19");
    }

    @Test
    public void isAmministratoreTest() {
        assert !utenteDAO.isAmministratore("Frama19");
    }

    @Test
    public void isAmministratoreTestWrong() {
        assert utenteDAO.isAmministratore("Frama19");
    }

    @Test
    public void isClienteTest() {
        assert utenteDAO.isCliente("Frama19");
    }

    @Test
    public void isClienteTestWrong() {
        assert !utenteDAO.isCliente("Frama19");
    }

    @Test
    public void checkEmailTest() {
        assert utenteDAO.checkEmail("francesca1922@gmail.com");
    }

    @Test
    public void checkEmailTestWrong() {
        assert !utenteDAO.checkEmail("francesca1922@gmail.com");
    }
}