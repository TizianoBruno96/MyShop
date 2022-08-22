package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Magazzino;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MagazzinoDAO implements IMagazzinoDAO {
    private static MagazzinoDAO instance = new MagazzinoDAO();
    private Magazzino magazzino;
    private static IDBConnection connection;
    private static ResultSet rs;

    private MagazzinoDAO() {
        magazzino = null;
        connection = null;
        rs = null;
    }

    public static MagazzinoDAO getInstance() {
        return instance;
    }

    public Magazzino findByID(int IdMagazzino) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Magazzino WHERE idMagazzino = '" + IdMagazzino + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                magazzino = new Magazzino();
                magazzino.setIdMagazzino(rs.getInt("idMagazzino"));
                magazzino.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
                magazzino.setMaxCorsia(rs.getInt("maxCorsia"));
                magazzino.setMaxScaffale(rs.getInt("maxScaffale"));
                return magazzino;
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

    public Magazzino findByPuntoVendita(int IdPuntoVendita) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Magazzino WHERE idPuntoVendita = '" + IdPuntoVendita + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                magazzino = new Magazzino();
                magazzino.setIdMagazzino(rs.getInt("idMagazzino"));
                magazzino.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
                magazzino.setMaxCorsia(rs.getInt("maxCorsia"));
                magazzino.setMaxScaffale(rs.getInt("maxScaffale"));
                return magazzino;
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

    public ArrayList<Magazzino> findAll() {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Magazzino");
        ArrayList<Magazzino> magazzini = new ArrayList<Magazzino>();
        try {
            while(rs.next()) {
                magazzino = new Magazzino();
                magazzino.setIdMagazzino(rs.getInt("idMagazzino"));
                magazzino.setIdPuntoVendita(rs.getInt("idPuntoVendita"));
                magazzino.setMaxCorsia(rs.getInt("maxCorsia"));
                magazzino.setMaxScaffale(rs.getInt("maxScaffale"));
                magazzini.add(magazzino);
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
        return magazzini;
    }

    @Override
    public int add(Magazzino magazzino) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Magazzino (idPuntoVendita, maxCorsia, maxScaffale) VALUES ('" + magazzino.getIdPuntoVendita() + "', '" + magazzino.getMaxCorsia() + "', '" + magazzino.getMaxScaffale() + "')");
        connection.close();
        return result;
    }

    @Override
    public int removeByID(int idMagazzino) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Magazzino WHERE idMagazzino = '" + idMagazzino + "'");
        connection.close();
        return result;
    }

    @Override
    public int removeByPuntoVendita(int idPuntoVendita) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Magazzino WHERE idPuntoVendita = '" + idPuntoVendita + "'");
        connection.close();
        return result;
    }

    @Override
    public int update(Magazzino magazzino) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Magazzino SET idPuntoVendita = '" + magazzino.getIdPuntoVendita() + "', maxCorsia = '" + magazzino.getMaxCorsia() + "', maxScaffale = '" + magazzino.getMaxScaffale() + "' WHERE idMagazzino = '" + magazzino.getIdMagazzino() + "'");
        connection.close();
        return result;
    }
}
