package DAO.ModelFactory;

import Model.Utenti.Utente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteFactory implements IFactory<Utente> {
    @Override
    public Utente create(ResultSet rs) throws SQLException {
        Utente utente = new Utente();
        utente.setIdUtente(rs.getInt("idUtente"));
        utente.setNome(rs.getString("Nome"));
        utente.setCognome(rs.getString("Cognome"));
        utente.setUsername(rs.getString("Username"));
        utente.setEmail(rs.getString("Email"));
        utente.setTelefono(rs.getString("Telefono"));
        utente.setEta(rs.getInt("Eta"));
        utente.setResidenza(rs.getString("Residenza"));
        utente.setProfessione(rs.getString("Professione"));
        utente.setPassword(rs.getString("Password"));
        utente.setTipo(rs.getString("Tipo"));
        return utente;
    }
}