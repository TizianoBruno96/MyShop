package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.ProdottoComposito;
import Model.ModelFactory.ProdottoCompositoFactory;

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
    public ProdottoComposito findByIDFiglio(int idProdottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ProdottoComposito WHERE IdProdottoFiglio = " + idProdottoFiglio;
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
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public ProdottoComposito findByIDPadre(int idProdottoPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ProdottoComposito WHERE IdProdottoPadre = " + idProdottoPadre;
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
        } finally {
            connection.close();
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
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public int add(ProdottoComposito prodottoComposito) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO ProdottoComposito (IDProdottoPadre, IDProdottoFiglio) VALUES (" + prodottoComposito.getIdProdottoPadre() + ", " + prodottoComposito.getIdProdottoFiglio() + ")");
        connection.close();
        return result;
    }

    @Override
    public int removeByIDFiglio(int idProdottoFiglio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM ProdottoComposito WHERE IDProdottoFiglio = " + idProdottoFiglio);
        connection.close();
        return result;
    }

    @Override
    public int removeByIDPadre(int idProdottoPadre) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM ProdottoComposito WHERE IDProdottoPadre = " + idProdottoPadre);
        connection.close();
        return result;
    }

    @Override
    public int update(ProdottoComposito prodottoComposito) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE ProdottoComposito SET IDProdottoPadre = " + prodottoComposito.getIdProdottoPadre() + ", IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio() + " WHERE IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio());
        connection.close();
        return result;
    }
}
