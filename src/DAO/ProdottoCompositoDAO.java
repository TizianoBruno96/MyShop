package DAO;

import DAO.Interfaces.IProdottoCompositoDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.*;
import Model.Articoli.Prodotto;
import Model.Articoli.ProdottoComposito;

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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                prodottoComposito = (ProdottoComposito) ModelFactory.getFactory(ModelFactory.ModelType.PRODOTTO_COMPOSITO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                prodottoComposito = (ProdottoComposito) ModelFactory.getFactory(ModelFactory.ModelType.PRODOTTO_COMPOSITO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            ArrayList<ProdottoComposito> prodottiCompositi = new ArrayList<>();
            while (rs.next()) {
                prodottoComposito = (ProdottoComposito) ModelFactory.getFactory(ModelFactory.ModelType.PRODOTTO_COMPOSITO).create(rs);
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
    public ArrayList<ProdottoComposito> findByIDPadre(int idProdottoPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ProdottoComposito WHERE IdProdottoPadre = " + idProdottoPadre;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            ArrayList<ProdottoComposito> prodottiCompositi = new ArrayList<>();
            while (rs.next()) {
                prodottoComposito = (ProdottoComposito) ModelFactory.getFactory(ModelFactory.ModelType.PRODOTTO_COMPOSITO).create(rs);
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
    public ArrayList<ProdottoComposito> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ProdottoComposito";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<ProdottoComposito> prodottiCompositi = new ArrayList<>();
        try {
            while (rs.next()) {
                prodottoComposito = (ProdottoComposito) ModelFactory.getFactory(ModelFactory.ModelType.PRODOTTO_COMPOSITO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(int idProdottoPadre, int idProdottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ProdottoComposito WHERE IDProdottoPadre = " + idProdottoPadre + " AND IDProdottoFiglio = " + idProdottoFiglio;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDFiglio(int idProdottoFiglio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ProdottoComposito WHERE IDProdottoFiglio = " + idProdottoFiglio;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDPadre(int idProdottoPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ProdottoComposito WHERE IDProdottoPadre = " + idProdottoPadre;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(ProdottoComposito prodottoComposito) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE ProdottoComposito SET IDProdottoPadre = " + prodottoComposito.getIdProdottoPadre() + ", IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio() + " WHERE IDProdottoPadre = " + prodottoComposito.getIdProdottoPadre() + " AND IDProdottoFiglio = " + prodottoComposito.getIdProdottoFiglio();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
