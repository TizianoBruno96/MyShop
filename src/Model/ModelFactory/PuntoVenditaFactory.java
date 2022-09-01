package Model.ModelFactory;

import Model.PuntoVendita;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PuntoVenditaFactory implements IFactory<PuntoVendita> {
    public PuntoVendita create(ResultSet rs) throws SQLException {
        PuntoVendita puntoVendita = new PuntoVendita();
        puntoVendita.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
        puntoVendita.setIdManager(rs.getInt("idManager"));
        puntoVendita.setIdMagazzino(rs.getInt("idMagazzino"));
        puntoVendita.setCitta(rs.getString("Citta"));
        puntoVendita.setNome(rs.getString("Nome"));
        return puntoVendita;
    }
}