package ModelFactory;

import Model.Guest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestFactory implements IFactory<Guest> {
    public Guest create(ResultSet rs) throws SQLException {
        Guest guest = new Guest();
        guest.setIdGuest(rs.getInt("idGuest"));
        guest.setIPGuest(rs.getString("IPGuest"));
        return guest;
    }
}