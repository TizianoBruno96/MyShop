package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.ModelFactory.UtenteFactory;
import Model.Utenti.Utente;

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
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Username = '" + username + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                utente = new UtenteFactory().create(rs);
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
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Utente> utenti = new ArrayList<>();
        try {
            while(rs.next()) {
                utente = new UtenteFactory().create(rs);
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
        rowCount += connection.executeUpdate("INSERT INTO ListaAcquisto (idUtente) VALUES (LAST_INSERT_ID());");
        rowCount += connection.executeUpdate("UPDATE Utente SET idListaAcquisto = LAST_INSERT_ID() WHERE idUtente = LAST_INSERT_ID();");
        connection.close();
        return rowCount;
    }

    @Override
    public int removeByUsername(String username) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM ListaAcquisto WHERE idUtente = (SELECT idUtente FROM Utente WHERE Username = '" + username + "');");
        rowCount += connection.executeUpdate("DELETE FROM Utente WHERE Username = '" + username + "';");
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