package Test.UnitTests;

import DAO.*;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import Model.PuntoVendita;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class PuntoVenditaDAOTest {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();

    @Before
    public void setUp() {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra", "MN"), 1);
        Utente utente = utenteDAO.findByUsername("Frama19");

        puntoVenditaDAO.add(new PuntoVendita("Milano", "MilanoShop", "Piazzale Loreto 27"), utente.getIdUtente());
    }

    @After
    public void tearDown() throws SQLException {
        puntoVenditaDAO.removeByIDManager(utenteDAO.findByUsername("Frama19").getIdUtente());
        utenteDAO.removeByUsername("Frama19");
    }

    @Test
    public void findByIDManagerTest() {
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente());
        assert puntoVendita != null;
    }

    @Test
    public void findByIDTest() {
        PuntoVendita puntoVendita = puntoVenditaDAO.findByID(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        assert puntoVendita.getNome().equals("MilanoShop");
    }

    @Test
    public void findByCittaTest() {
        ArrayList<PuntoVendita> puntiVendita = puntoVenditaDAO.findByCitta("Milano");
        assert puntiVendita.size() == 1;
    }

    @Test
    public void updateTest() {
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente());
        puntoVendita.setNome("MilanoShop2");
        puntoVenditaDAO.update(puntoVendita);
        assert puntoVenditaDAO.findByID(puntoVendita.getIdPuntoVendita()).getNome().equals("MilanoShop2");
    }

    @Test
    public void removeTest() {
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente());
        puntoVenditaDAO.removeByID(puntoVendita.getIdPuntoVendita());
        assert puntoVenditaDAO.findByID(puntoVendita.getIdPuntoVendita()) == null;
    }

    @Test
    public void findAllTest() {
        ArrayList<PuntoVendita> puntiVendita = puntoVenditaDAO.findAll();
        assert puntiVendita.size() > 0;
    }

    @Test
    public void findByNomeTest() {
        PuntoVendita puntoVendita = puntoVenditaDAO.findByNome("MilanoShop");
        assert puntoVendita != null;
    }
}
