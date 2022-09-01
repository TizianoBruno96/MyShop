package Model.ModelFactory;

import Model.Utenti.UtenteRegistrato;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteRegistratoFactory implements IFactory<UtenteRegistrato> {
    public UtenteRegistrato create(ResultSet rs) throws SQLException {
        UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setIdUtenteRegistrato(rs.getInt("idUtenteRegistrato"));
        utenteRegistrato.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
        return utenteRegistrato;
    }
}