package ModelFactory;

import Model.Fornitore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FornitoreFactory implements IFactory<Fornitore> {
    @Override
    public Fornitore create(ResultSet rs) throws SQLException {
        Fornitore fornitore = new Fornitore();
        fornitore.setIdFornitore(rs.getInt("idFornitore"));
        fornitore.setNome(rs.getString("Nome"));
        return fornitore;
    }
}

