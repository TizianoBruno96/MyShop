package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import DAO.ModelFactory.OrdineProdottoFactory;
import Model.Articoli.Prodotto;
import Model.ListaAcquisto;
import Model.OrdineProdotto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineProdottoDAO implements IOrdineProdottoDAO {
    private static OrdineProdottoDAO instance = new OrdineProdottoDAO();
    private OrdineProdotto ordineProdotto;
    private static IDBConnection connection;
    private static ResultSet rs;

    private OrdineProdottoDAO() {
        ordineProdotto = null;
        connection = null;
        rs = null;
    }

    public static OrdineProdottoDAO getInstance() {
        return instance;
    }

    @Override
    public ArrayList<OrdineProdotto> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineProdotto";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<OrdineProdotto> ordini = new ArrayList<>();
        try {
            while(rs.next()) {
                ordineProdotto = new OrdineProdottoFactory().create(rs);
                ordini.add(ordineProdotto);
            }
            return ordini;
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
    public ArrayList<OrdineProdotto> findByListaAcquisto(int idListaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineProdotto WHERE idListaAcquisto = " + idListaAcquisto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<OrdineProdotto> ordini = new ArrayList<>();
        try {
            while(rs.next()) {
                ordineProdotto = new OrdineProdottoFactory().create(rs);
                ordini.add(ordineProdotto);
            }
            return ordini;
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
    public ArrayList<OrdineProdotto> findByProdotto(int idProdotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineProdotto WHERE idProdotto = " + idProdotto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<OrdineProdotto> ordini = new ArrayList<>();
        try {
            while(rs.next()) {
                ordineProdotto = new OrdineProdottoFactory().create(rs);
                ordini.add(ordineProdotto);
            }
            return ordini;
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
    public OrdineProdotto find(Prodotto prodotto, ListaAcquisto listaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineProdotto WHERE idProdotto = " + prodotto.getIdProdotto() + " AND idListaAcquisto = " + listaAcquisto.getIdListaAcquisto();
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            if(rs.next()) {
                ordineProdotto = new OrdineProdottoFactory().create(rs);
                return ordineProdotto;
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
    public int add(OrdineProdotto ordineProdotto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("INSERT INTO OrdineProdotto (idProdotto, idListaAcquisto, Quantita) VALUES (" + ordineProdotto.getIdProdotto() + ", " + ordineProdotto.getIdListaAcquisto() + ", " + ordineProdotto.getQuantita() + ")");
        return rowCount;
    }

    @Override
    public int removeByIDProdotto(int idProdotto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM OrdineProdotto WHERE idProdotto = " + idProdotto);
        return rowCount;
    }

    @Override
    public int removeByIDListaAcquisto(int idListaAcquisto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM OrdineProdotto WHERE idListaAcquisto = " + idListaAcquisto);
        return rowCount;
    }

    @Override
    public int removeByID(int idProdotto, int idListaAcquisto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM OrdineProdotto WHERE idProdotto = " + idProdotto + " AND idListaAcquisto = " + idListaAcquisto);
        return rowCount;
    }

    @Override
    public int update(OrdineProdotto ordineProdotto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE OrdineProdotto SET Quantita = " + ordineProdotto.getQuantita() + " WHERE idProdotto = " + ordineProdotto.getIdProdotto() + " AND idListaAcquisto = " + ordineProdotto.getIdListaAcquisto());
        return rowCount;
    }
}
