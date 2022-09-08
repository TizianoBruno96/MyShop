package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Prodotto;
import Model.Articoli.ProdottoComposito;
import DAO.ModelFactory.ProdottoCompositoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoCompositoDAO implements IProdottoCompositoDAO {
    private static ProdottoCompositoDAO instance = new ProdottoCompositoDAO();
    private ProdottoComposito prodottoComposito;
    private static IDBConnection connection;
    private static ResultSet rs;

    private ProdottoCompositoDAO() {
        prodottoComposito = null;
        connection = null;
        rs = null;
    }

    public static ProdottoCompositoDAO getInstance() {
        return instance;
    }

    @Override
    public ProdottoComposito find(Prodotto prodottoPadre, Prodotto prodottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM prodotto_composito WHERE IdProdottoPadre = " + prodottoPadre.getIdProdotto() + " AND IdProdottoFiglio = " + prodottoFiglio.getIdProdotto();
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                prodottoComposito = new ProdottoCompositoFactory().create(rs);
                return prodottoComposito;
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
    public ProdottoComposito find(int idProdottoPadre, int idProdottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM prodottocomposito WHERE IdProdottoPadre = " + idProdottoPadre + " AND IdProdottoFiglio = " + idProdottoFiglio;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                prodottoComposito = new ProdottoCompositoFactory().create(rs);
                return prodottoComposito;
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
    public ArrayList<ProdottoComposito> findByIDFiglio(int idProdottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ProdottoComposito WHERE IdProdottoFiglio = " + idProdottoFiglio;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            ArrayList<ProdottoComposito> prodottiCompositi = new ArrayList<>();
            while(rs.next()) {
                prodottiCompositi.add(new ProdottoCompositoFactory().create(rs));
            }
            return prodottiCompositi;
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
    public ArrayList<ProdottoComposito> findByIDPadre(int idProdottoPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ProdottoComposito WHERE IdProdottoPadre = " + idProdottoPadre;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            ArrayList<ProdottoComposito> prodottiCompositi = new ArrayList<>();
            while(rs.next()) {
                prodottiCompositi.add(new ProdottoCompositoFactory().create(rs));
            }
            return prodottiCompositi;
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
    public ArrayList<ProdottoComposito> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ProdottoComposito";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<ProdottoComposito> prodottiCompositi = new ArrayList<>();
        try {
            while(rs.next()) {
                prodottoComposito = new ProdottoCompositoFactory().create(rs);
                prodottiCompositi.add(prodottoComposito);
            }
            return prodottiCompositi;
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
    public int add(ProdottoComposito prodottoComposito) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("INSERT INTO ProdottoComposito (IDProdottoPadre, IDProdottoFiglio) VALUES (" + prodottoComposito.getIdProdottoPadre() + ", " + prodottoComposito.getIdProdottoFiglio() + ")");
        return rowCount;
    }

    @Override
    public int remove(int idProdottoPadre, int idProdottoFiglio) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM ProdottoComposito WHERE IDProdottoPadre = " + idProdottoPadre + " AND IDProdottoFiglio = " + idProdottoFiglio);
        return rowCount;
    }

    @Override
    public int removeByIDFiglio(int idProdottoFiglio) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM ProdottoComposito WHERE IDProdottoFiglio = " + idProdottoFiglio);
        return rowCount;
    }

    @Override
    public int removeByIDPadre(int idProdottoPadre) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM ProdottoComposito WHERE IDProdottoPadre = " + idProdottoPadre);
        return rowCount;
    }

    @Override
    public int update(ProdottoComposito prodottoComposito) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE ProdottoComposito SET IDProdottoPadre = " + prodottoComposito.getIdProdottoPadre() + ", IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio() + " WHERE IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio());
        return rowCount;
    }
}
