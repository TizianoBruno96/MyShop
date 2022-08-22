package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Utente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO implements IUtenteDAO {
    private static UtenteDAO instance = new UtenteDAO();
    private Utente utente;
    private static IDBConnection connection;
    private static ResultSet rs;

    private UtenteDAO() {
        utente = null;
        connection = null;
        rs = null;
    }

    public static UtenteDAO getInstance() {
        return instance;
    }

    @Override
    public Utente findByUsername(String username) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Utente WHERE Username = '" + username + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                utente = new Utente();
                utente.setIdUtente(rs.getInt("idUtente"));
                utente.setName(rs.getString("Nome"));
                utente.setSurname(rs.getString("Cognome"));
                utente.setUsername(rs.getString("Username"));
                utente.setEmail(rs.getString("Email"));
                utente.setTelefono(rs.getString("Telefono"));
                utente.setEta(rs.getInt("Età"));
                utente.setResidenza(rs.getString("Residenza"));
                utente.setProfessione(rs.getString("Professione"));
                utente.setPassword(rs.getString("Password"));
                utente.setTipo(rs.getString("Tipo"));
                utente.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
                utente.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
                return utente;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public ArrayList<Utente> findAll() {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT Nome, Cognome, Username, Email FROM Utente;");
        ArrayList<Utente> utenti = new ArrayList<>();
        try {
            while(rs.next()) {
                utente = new Utente();
                utente.setIdUtente(rs.getInt("idUtente"));
                utente.setName(rs.getString("Nome"));
                utente.setSurname(rs.getString("Cognome"));
                utente.setUsername(rs.getString("Username"));
                utente.setEmail(rs.getString("Email"));
                utente.setTelefono(rs.getString("Telefono"));
                utente.setEta(rs.getInt("Età"));
                utente.setResidenza(rs.getString("Residenza"));
                utente.setProfessione(rs.getString("Professione"));
                utente.setPassword(rs.getString("Password"));
                utente.setTipo(rs.getString("Tipo"));
                utente.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
                utente.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
                utenti.add(utente);
            }
            return utenti;
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public int add(Utente utente) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("INSERT INTO Utente (Nome, Cognome, Username, Email, Telefono, Età, Residenza, Professione, Password, Tipo, idPuntoVendita, idListaAcquisto) VALUES ('" + utente.getName() + "', '" + utente.getSurname() + "', '" + utente.getUsername() + "', '" + utente.getEmail() + "', '" + utente.getTelefono() + "', " + utente.getEta() + ", '" + utente.getResidenza() + "', '" + utente.getProfessione() + "', '" + utente.getPassword() + "', '" + utente.getTipo() + "', " + utente.getIdPuntoVendita() + ", " + utente.getIdListaAcquisto() + ");");
        connection.close();
        return rowCount;
    }

    @Override
    public int removeByID(String username) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Utente WHERE Username = '" + username + "';");
        connection.close();
        return rowCount;
    }

    @Override
    public int update(Utente utente) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Utente SET Nome = '" + utente.getName() + "', Cognome = '" + utente.getSurname() + "', Username = '" + utente.getUsername() + "', Email = '" + utente.getEmail() + "', Telefono = '" + utente.getTelefono() + "', Età = " + utente.getEta() + ", Residenza = '" + utente.getResidenza() + "', Professione = '" + utente.getProfessione() + "', Password = '" + utente.getPassword() + "', Tipo = '" + utente.getTipo() + "', idPuntoVendita = " + utente.getIdPuntoVendita() + ", idListaAcquisto = " + utente.getIdListaAcquisto() + " WHERE idUtente = " + utente.getIdUtente() + ";");
        connection.close();
        return rowCount;
    }
}
