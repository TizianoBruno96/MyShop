package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.PuntoVendita;
import ModelFactory.PuntoVenditaFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PuntoVenditaDAO implements IPuntoVenditaDAO {
    private static PuntoVenditaDAO instance = new PuntoVenditaDAO();
    private PuntoVendita puntoVendita;
    private static IDBConnection connection;
    private static ResultSet rs;


    private PuntoVenditaDAO() {
        puntoVendita = null;
        connection = null;
        rs = null;
    }

    public static PuntoVenditaDAO getInstance() {
        return instance;
    }

    public PuntoVendita findByManager(int idManager) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM PuntoVendita WHERE idManager = " + idManager);
        try {
            rs.next();
            if(rs.getRow() == 1) {
                puntoVendita = new PuntoVenditaFactory().create(rs);
                return puntoVendita;
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

    public ArrayList<PuntoVendita> findAll() {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM PuntoVendita");
        ArrayList<PuntoVendita> puntiVendita = new ArrayList<>();
        try {
            while(rs.next()) {
                puntoVendita = new PuntoVenditaFactory().create(rs);
                puntiVendita.add(puntoVendita);
            }
            return puntiVendita;
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
    public ArrayList<PuntoVendita> findByCitta(String citta) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM PuntoVendita WHERE Citta = '" + citta + "'");
        ArrayList<PuntoVendita> puntiVendita = new ArrayList<>();
        try {
            while(rs.next()) {
                puntoVendita = new PuntoVenditaFactory().create(rs);
                puntiVendita.add(puntoVendita);
            }
            return puntiVendita;
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
    public int add(PuntoVendita puntoVendita) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO PuntoVendita (idManager, idMagazzino, Citta, Nome) VALUES (" + puntoVendita.getIdManager() + ", " + puntoVendita.getIdMagazzino() + ", '" + puntoVendita.getCitta() + "', '" + puntoVendita.getNome() + "')");
        connection.close();
        return result;
    }

    @Override
    public int update(PuntoVendita puntoVendita) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE PuntoVendita SET idManager = " + puntoVendita.getIdManager() + ", idMagazzino = " + puntoVendita.getIdMagazzino() + ", Citta = '" + puntoVendita.getCitta() + "', Nome = '" + puntoVendita.getNome() + "' WHERE idPuntoVendita = " + puntoVendita.getIdPuntoVendita());
        connection.close();
        return result;
    }

    @Override
    public int remove(int idPuntoVendita) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM PuntoVendita WHERE idPuntoVendita = " + idPuntoVendita);
        connection.close();
        return result;
    }
}
