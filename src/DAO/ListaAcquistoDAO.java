package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.ListaAcquisto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListaAcquistoDAO implements IListaAcquistoDAO {
    private static ListaAcquistoDAO instance = new ListaAcquistoDAO();
    private ListaAcquisto listaAcquisto;
    private static IDBConnection connection;
    private static ResultSet rs;

    private ListaAcquistoDAO() {
        listaAcquisto = null;
        connection = null;
        rs = null;
    }

    public static ListaAcquistoDAO getInstance() {
        return instance;
    }

    public ListaAcquisto findByIDUtente(int IdUtente) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM ListaAcquisto WHERE idUtente = '" + IdUtente + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                listaAcquisto = new ListaAcquisto();
                listaAcquisto.setIdUtente(rs.getInt("idUtente"));
                listaAcquisto.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
                listaAcquisto.setCostoTot(rs.getInt("CostoTotale"));
                return listaAcquisto;
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

    public ListaAcquisto findByID(int IdListaAcquisto) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM ListaAcquisto WHERE idListaAcquisto = '" + IdListaAcquisto + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                listaAcquisto = new ListaAcquisto();
                listaAcquisto.setIdUtente(rs.getInt("idUtente"));
                listaAcquisto.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
                listaAcquisto.setCostoTot(rs.getInt("CostoTotale"));
                return listaAcquisto;
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
    public int add(ListaAcquisto listaAcquisto) {
        connection = DBConnection.getInstance();

        int result = connection.executeUpdate("INSERT INTO ListaAcquisto (idUtente, CostoTotale) VALUES ('" + listaAcquisto.getIdUtente() + "' , '" + listaAcquisto.getCostoTot() + "')");
        connection.close();
        return result;
    }

    @Override
    public int removeByIDUtente(int idUtente) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM ListaAcquisto WHERE idUtente = '" + idUtente + "'");
        connection.close();
        return result;
    }

    @Override
    public int removeByID(int idListaAcquisto) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM ListaAcquisto WHERE idListaAcquisto = '" + idListaAcquisto + "'");
        connection.close();
        return result;
    }

    @Override
    public int update(ListaAcquisto listaAcquisto) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE ListaAcquisto SET idUtente = '" + listaAcquisto.getIdUtente() + "', CostoTotale = '" + listaAcquisto.getCostoTot() + "' WHERE idListaAcquisto = '" + listaAcquisto.getIdListaAcquisto() + "'");
        connection.close();
        return result;
    }

    @Override
    public int updateCostoTot(int idListaAcquisto, int costoTot) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE ListaAcquisto SET CostoTotale = '" + costoTot + "' WHERE idListaAcquisto = '" + idListaAcquisto + "'");
        connection.close();
        return result;
    }
}
