package Test;

import DAO.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtenteDAOTest {
    @Before
    public void setUp() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        utenteDAO.add(new Utente("Valentino", "Rossi", "VRossi", "valeRossi69420@gmail.com", "3494445555", 46, "catania", "Pilota di moto", "1234", "UA"));
    }

    @After
    public void tearDown() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        utenteDAO.removeByID("VRossi");
    }

    @Test
    public void findByUsernameTest() {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        Utente utente = utenteDAO.findByUsername("VRossi");
        assert utente.getUsername().equals("VRossi");
    }
}