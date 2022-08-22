package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.UtenteRegistrato;
import ModelFactory.UtenteRegistratoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteRegistratoDAO implements IUtenteRegistratoDAO {
    private static UtenteRegistratoDAO instance = new UtenteRegistratoDAO();
    private UtenteRegistrato utenteRegistrato;
    private static IDBConnection connection;
    private static ResultSet rs;

    private UtenteRegistratoDAO() {
        utenteRegistrato = null;
        connection = null;
        rs = null;
    }

    public static UtenteRegistratoDAO getInstance() {
        return instance;
    }

    public ArrayList<UtenteRegistrato> findByUtente(int idUtente) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM UtenteRegistrato WHERE idUtenteRegistrato = " + idUtente);
        ArrayList<UtenteRegistrato> utenti = new ArrayList<>();
        try {
            while (rs.next()) {
                utenteRegistrato = new UtenteRegistratoFactory().create(rs);
                utenti.add(utenteRegistrato);
            }
            return utenti;
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return null;
    }

    public ArrayList<UtenteRegistrato> findByPuntoVendita(int idPuntoVendita) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM UtenteRegistrato WHERE idPuntoVendita = " + idPuntoVendita);
        ArrayList<UtenteRegistrato> utenti = new ArrayList<>();
        try {
            while (rs.next()) {
                utenteRegistrato = new UtenteRegistratoFactory().create(rs);
                utenti.add(utenteRegistrato);
            }
            return utenti;
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return null;
    }

    @Override
    public int add(UtenteRegistrato utenteRegistrato) {
        connection = DBConnection.getInstance();
        return connection.executeUpdate("INSERT INTO UtenteRegistrato (idUtenteRegistrato, idPuntoVendita) VALUES (" + utenteRegistrato.getIdUtenteRegistrato() + ", " + utenteRegistrato.getIdPuntoVendita() + ")");
    }

    @Override
    public int update(UtenteRegistrato utenteRegistrato) {
        connection = DBConnection.getInstance();
        return connection.executeUpdate("UPDATE UtenteRegistrato SET idPuntoVendita = " + utenteRegistrato.getIdPuntoVendita() + " WHERE idUtenteRegistrato = " + utenteRegistrato.getIdUtenteRegistrato());
    }

    @Override
    public int remove(UtenteRegistrato utenteRegistrato) {
        connection = DBConnection.getInstance();
        return connection.executeUpdate("DELETE FROM UtenteRegistrato WHERE idUtenteRegistrato = " + utenteRegistrato.getIdUtenteRegistrato());
    }
}
