package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Recensione;
import DAO.ModelFactory.RecensioneFactory;

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

    @Override
    public Recensione findByID(int idRecensione) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Recensione WHERE IdRecensione = " + idRecensione;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                recensione = new RecensioneFactory().create(rs);
                return recensione;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Recensione find(int idProdotto, int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Recensione WHERE IdProdotto = " + idProdotto + " AND IdUtente = " + idUtente;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                recensione = new RecensioneFactory().create(rs);
                return recensione;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Recensione> findByProdotto(int idProdotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Recensione WHERE IdProdotto = " + idProdotto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
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
        }
        return null;
    }

    @Override
    public ArrayList<Recensione> findByUtente(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Recensione WHERE IdUtente = " + idUtente;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
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
        }
        return null;
    }

    @Override
    public int add(Recensione recensione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Recensione (Voto, Commento, Data, IdProdotto, IdUtente) VALUES (" + recensione.getVoto() + ", '" + recensione.getCommento() + "', '" + recensione.getData() + "', " + recensione.getIdProdotto() + ", " + recensione.getIdUtente() + ")");
        return result;
    }

    @Override
    public int update(Recensione recensione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Recensione SET Voto = " + recensione.getVoto() + ", Commento = '" + recensione.getCommento() + "', Data = '" + recensione.getData() + "' WHERE idProdotto = " + recensione.getIdProdotto() + " AND idUtente = " + recensione.getIdUtente() + " AND idRecensione = " + recensione.getIdRecensione());
        return result;
    }

    @Override
    public int remove(int idRecensione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Recensione WHERE idRecensione = " + idRecensione);
        return result;
    }

    @Override
    public int removeByProdottoAndUtente(int idProdotto, int idUtente) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Recensione WHERE IdProdotto = " + idProdotto + " AND IdUtente = " + idUtente);
        return result;
    }
}
