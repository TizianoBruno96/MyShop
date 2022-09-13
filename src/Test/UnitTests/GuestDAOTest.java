package Test.UnitTests;

import DAO.GuestDAO;
import DAO.Interfaces.IGuestDAO;
import Model.Guest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuestDAOTest {
    IGuestDAO guestDAO = GuestDAO.getInstance();

    @Before
    public void setUp() {
        guestDAO.add(new Guest("192.168.1.1"));
        guestDAO.add(new Guest("193.165.2.3"));
    }

    @After
    public void tearDown() {
        if (guestDAO.findByIP("192.168.1.1") != null)
            guestDAO.removeByID(guestDAO.findByIP("192.168.1.1").getIdGuest());

        if (guestDAO.findByIP("193.165.2.3") != null)
            guestDAO.removeByID(guestDAO.findByIP("193.165.2.3").getIdGuest());

        if(guestDAO.findByIP("195.162.0.1") != null)
            guestDAO.removeByID(guestDAO.findByIP("195.162.0.1").getIdGuest());

        if (guestDAO.findByIP("192.169.1.1") != null)
            guestDAO.removeByID(guestDAO.findByIP("192.169.1.1").getIdGuest());
    }

    @Test
    public void testFindAll() {
        assert guestDAO.findAll().size() >= 2;
    }
    @Test
    public void testFindAllWrong() {
        assert guestDAO.findAll().size() < 2;
    }

    @Test
    public void testFindByIP() {
        assert guestDAO.findByIP("192.168.1.1").getIPGuest().equals("192.168.1.1");
    }
    @Test
    public void testFindByIPWrong() {
        assert guestDAO.findByIP("192.168.1.1").getIPGuest().equals("192.168.1.142");
    }

    @Test
    public void testFindByID() {
        assert guestDAO.findByID(guestDAO.findByIP("192.168.1.1").getIdGuest()).getIPGuest().equals("192.168.1.1");
    }
    @Test
    public void testFindByIDWrong() {
        assert guestDAO.findByID(guestDAO.findByIP("192.168.1.1").getIdGuest()).getIPGuest().equals("192.168.1.145");
    }

    @Test
    public void addTest() {
        guestDAO.add(new Guest("195.162.0.1"));
        assert guestDAO.findByIP("195.162.0.1") != null;
    }
    @Test
    public void addTestWrong() {
        guestDAO.add(new Guest("195.162.0.1"));
        assert guestDAO.findByIP("195.162.0.1") == null;
    }

    @Test
    public void removeByIPTest() {
        guestDAO.removeByIP("192.168.1.1");
        assert guestDAO.findByIP("192.168.1.1") == null;
    }
    @Test
    public void removeByIPTestWrong() {
        guestDAO.removeByIP("192.168.1.1");
        assert guestDAO.findByIP("192.168.1.1") != null;
    }

    @Test
    public void removeByIDTest() {
        guestDAO.removeByID(guestDAO.findByIP("192.168.1.1").getIdGuest());
        assert guestDAO.findByIP("192.168.1.1") == null;
    }
    @Test
    public void removeByIDTestWrong() {
        guestDAO.removeByID(guestDAO.findByIP("192.168.1.1").getIdGuest());
        assert guestDAO.findByIP("192.168.1.1") != null;
    }

    @Test
    public void updateTest() {
        Guest guest = guestDAO.findByIP("192.168.1.1");
        guest.setIPGuest("192.169.1.1");
        guestDAO.update(guest);
        assert guestDAO.findByIP("192.169.1.1") != null;
        assert guestDAO.findByIP("192.168.1.1") == null;
    }
    @Test
    public void updateTestWrong() {
        Guest guest = guestDAO.findByIP("192.168.1.1");
        guest.setIPGuest("192.169.1.1");
        guestDAO.update(guest);
        assert guestDAO.findByIP("192.169.1.1555") != null;
        assert guestDAO.findByIP("192.168.1.4142") == null;
    }
}
