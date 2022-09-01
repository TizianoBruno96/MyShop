package Model.ModelFactory;

import Model.Articoli.Fornitore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FornitoreFactory implements IFactory<Fornitore> {
    @Override
    public Fornitore create(ResultSet rs) throws SQLException {
        Fornitore fornitore = new Fornitore();
        fornitore.setIdFornitore(rs.getInt("idFornitore"));
        fornitore.setNome(rs.getString("Nome"));
        fornitore.setSito(rs.getString("Sito"));
        return fornitore;
    }
}

