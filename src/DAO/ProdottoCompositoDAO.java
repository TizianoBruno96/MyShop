package DAO;

import DAO.Interfaces.IProdottoCompositoDAO;
import DBInterface.Command.*;
import Model.Articoli.Prodotto;
import Model.Articoli.ProdottoComposito;
import DAO.ModelFactory.ProdottoCompositoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoCompositoDAO implements IProdottoCompositoDAO {
    private static final ProdottoCompositoDAO instance = new ProdottoCompositoDAO();
    private ProdottoComposito prodottoComposito;
    private static ResultSet rs;

    private ProdottoCompositoDAO() {
        prodottoComposito = null;
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
            if (rs.getRow() == 1) {
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
            if (rs.getRow() == 1) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO ProdottoComposito (IDProdottoPadre, IDProdottoFiglio) VALUES (" + prodottoComposito.getIdProdottoPadre() + ", " + prodottoComposito.getIdProdottoFiglio() + ")";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(int idProdottoPadre, int idProdottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ProdottoComposito WHERE IDProdottoPadre = " + idProdottoPadre + " AND IDProdottoFiglio = " + idProdottoFiglio;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDFiglio(int idProdottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ProdottoComposito WHERE IDProdottoFiglio = " + idProdottoFiglio;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDPadre(int idProdottoPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ProdottoComposito WHERE IDProdottoPadre = " + idProdottoPadre;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(ProdottoComposito prodottoComposito) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE ProdottoComposito SET IDProdottoPadre = " + prodottoComposito.getIdProdottoPadre() + ", IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio() + " WHERE IDProdottoPadre = " + prodottoComposito.getIdProdottoPadre() + " AND IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio();
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
