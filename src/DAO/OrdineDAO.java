package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Servizio;
import Model.ModelFactory.OrdineFactory;
import Model.Ordine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAO implements IOrdineDAO {
    private static OrdineDAO instance = new OrdineDAO();
    private Ordine ordine;
    private static IDBConnection connection;
    private static ResultSet rs;

    private OrdineDAO() {
        ordine = null;
        connection = null;
        rs = null;
    }

    public static OrdineDAO getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Ordine> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Ordine";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Ordine> ordini = new ArrayList<>();
        try {
            while(rs.next()) {
                ordine = new OrdineFactory().create(rs);
                ordini.add(ordine);
            }
            return ordini;
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
    public ArrayList<Ordine> findByListaAcquisto(int idListaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Ordine WHERE idListaAcquisto = " + idListaAcquisto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Ordine> ordini = new ArrayList<>();
        try {
            while(rs.next()) {
                ordine = new OrdineFactory().create(rs);
                ordini.add(ordine);
            }
            return ordini;
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
    public ArrayList<Ordine> findByProdotto(int idProdotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Ordine WHERE idProdotto = " + idProdotto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Ordine> ordini = new ArrayList<>();
        try {
            while(rs.next()) {
                ordine = new OrdineFactory().create(rs);
                ordini.add(ordine);
            }
            return ordini;
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
    public int add(Ordine ordine) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("INSERT INTO Ordine (idProdotto, idListaAcquisto) VALUES (" + ordine.getIdProdotto() + ", " + ordine.getIdListaAcquisto() + ")");
        connection.close();
        return rowCount;
    }

    @Override
    public int removeByIDProdotto(int idProdotto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Ordine WHERE idProdotto = " + idProdotto);
        connection.close();
        return rowCount;
    }

    @Override
    public int removeByIDListaAcquisto(int idListaAcquisto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Ordine WHERE idListaAcquisto = " + idListaAcquisto);
        connection.close();
        return rowCount;
    }

    @Override
    public int removeByID(int idProdotto, int idListaAcquisto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Ordine WHERE idProdotto = " + idProdotto + " AND idListaAcquisto = " + idListaAcquisto);
        connection.close();
        return rowCount;
    }

    @Override
    public int updateByProdotto(Ordine ordine) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Ordine SET idListaAcquisto = " + ordine.getIdListaAcquisto() + " WHERE idProdotto = " + ordine.getIdProdotto());
        connection.close();
        return rowCount;
    }

    @Override
    public int updateByListaAcquisto(Ordine ordine) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Ordine SET idProdotto = " + ordine.getIdProdotto() + " WHERE idListaAcquisto = " + ordine.getIdListaAcquisto());
        connection.close();
        return rowCount;
    }
}
