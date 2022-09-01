package Test;

import DAO.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAOTest {
    @Before
    public void setUp() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra"), 1);
    }

    @After
    public void tearDown() throws SQLException {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        utenteDAO.removeByUsername("Frama19");
    }

    @Test
    public void findByUsernameTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        Utente utente = utenteDAO.findByUsername("Frama19");
        assert utente.getUsername().equals("Frama19");
    }

    @Test
    public void findAllTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        ArrayList<Utente> utenti = utenteDAO.findAll();
        assert utenti.size() == 5;
    }

    @Test
    public void updateTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        Utente utente = utenteDAO.findByUsername("Frama19");
        utente.setPassword("Giuseppe");
        utenteDAO.update(utente);
        assert utente.getPassword().equals("Giuseppe");
    }

    @Test
    public void removeByUsernameTest() throws SQLException {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        utenteDAO.removeByUsername("Frama19");
        assert utenteDAO.findByUsername("Frama19") == null;
    }

    @Test
    public void updateTipoTest() throws SQLException {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        utenteDAO.updateTipo("Frama19", "MN");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("MN");
        utenteDAO.updateTipo("Frama19", "CL");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("CL");
        utenteDAO.updateTipo("Frama19", "AM");
        assert utenteDAO.findByUsername("Frama19").getTipo().equals("AM");
    }

    @Test
    public void checkUsernameTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        assert utenteDAO.checkUsername("Frama19");
    }

    @Test
    public void checkUtenteTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        assert utenteDAO.checkUtente("Frama19", "Gomorra");
    }

    @Test
    public void isManagerTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        assert !utenteDAO.isManager("Frama19");
    }

    @Test
    public void isAmministratoreTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        assert !utenteDAO.isAmministratore("Frama19");
    }

    @Test
    public void isClienteTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        assert utenteDAO.isCliente("Frama19");
    }
}