package Model.ModelFactory;

import Model.Magazzino;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazzinoFactory implements IFactory<Magazzino> {
    public Magazzino create(ResultSet rs) throws SQLException {
        Magazzino magazzino = new Magazzino();
        magazzino.setIdMagazzino(rs.getInt("idMagazzino"));
        magazzino.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
        magazzino.setMaxCorsia(rs.getInt("maxCorsia"));
        magazzino.setMaxScaffale(rs.getInt("maxScaffale"));
        return magazzino;
    }
}