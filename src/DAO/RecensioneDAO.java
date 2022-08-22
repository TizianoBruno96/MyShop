package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Recensione;
import ModelFactory.RecensioneFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecensioneDAO implements IRecensioneDAO {
    private static RecensioneDAO instance = new RecensioneDAO();
    private Recensione recensione;
    private static IDBConnection connection;
    private static ResultSet rs;

    private RecensioneDAO() {
        recensione = null;
        connection = null;
        rs = null;
    }

    public static RecensioneDAO getInstance() {
        return instance;
    }

    public ArrayList<Recensione> findByProdotto(int idProdotto) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Recensione WHERE idProdotto = " + idProdotto);
        ArrayList<Recensione> recensioni = new ArrayList<>();
        try {
            while(rs.next()) {
                recensione = new RecensioneFactory().create(rs);
                recensioni.add(recensione);
            }
            return recensioni;
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
    public ArrayList<Recensione> findByUtente(int idUtente) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Recensione WHERE idUtente = " + idUtente);
        ArrayList<Recensione> recensioni = new ArrayList<>();
        try {
            while(rs.next()) {
                recensione = new RecensioneFactory().create(rs);
                recensioni.add(recensione);
            }
            return recensioni;
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
    public int add(Recensione recensione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Recensione (Voto, Commento, idProdotto, idUtente) VALUES (" + recensione.getVoto() + ", '" + recensione.getCommento() + "', " + recensione.getIdProdotto() + ", " + recensione.getIdUtente() + ")");
        connection.close();
        return result;
    }

    @Override
    public int update(Recensione recensione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Recensione SET Voto = " + recensione.getVoto() + ", Commento = '" + recensione.getCommento() + "', idProdotto = " + recensione.getIdProdotto() + ", idUtente = " + recensione.getIdUtente() + " WHERE idRecensione = " + recensione.getIdRecensione());
        connection.close();
        return result;
    }

    @Override
    public int remove(int idRecensione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Recensione WHERE idRecensione = " + idRecensione);
        connection.close();
        return result;
    }
}
