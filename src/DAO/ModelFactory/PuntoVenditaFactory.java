package DAO.ModelFactory;

import Model.PuntoVendita;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PuntoVenditaFactory implements IFactory<PuntoVendita> {
    public PuntoVendita create(ResultSet rs) throws SQLException {
        PuntoVendita puntoVendita = new PuntoVendita();
        puntoVendita.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
        puntoVendita.setCitta(rs.getString("Citta"));
        puntoVendita.setNome(rs.getString("Nome"));
        puntoVendita.setIndirizzo(rs.getString("Indirizzo"));
        puntoVendita.setIdUtenteManager(rs.getInt("idUtenteManager"));
        return puntoVendita;
    }
}