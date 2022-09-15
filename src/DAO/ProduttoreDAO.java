package DAO;

import DAO.Interfaces.IProduttoreDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.*;
import Model.Articoli.Produttore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduttoreDAO implements IProduttoreDAO {
    private static final ProduttoreDAO instance = new ProduttoreDAO();
    private Produttore produttore;
    private static ResultSet rs;

    private ProduttoreDAO() {
        produttore = null;
        rs = null;
    }

    public static ProduttoreDAO getInstance() {
        return instance;
    }

    @Override
    public Produttore findByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Produttore WHERE Nome = '" + nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                produttore = (Produttore) ModelFactory.getFactory(ModelFactory.ModelType.PRODUTTORE).create(rs);
                return produttore;
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
    public Produttore findByID(int idProduttore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Produttore WHERE idProduttore = '" + idProduttore + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                produttore = (Produttore) ModelFactory.getFactory(ModelFactory.ModelType.PRODUTTORE).create(rs);
                return produttore;
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
    public boolean checkNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Produttore WHERE Nome = '" + nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                return true;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkSito(String sito) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Produttore WHERE Sito = '" + sito + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                return true;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Produttore> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Produttore";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Produttore> produttori = new ArrayList<>();
        try {
            while (rs.next()) {
                produttore = (Produttore) ModelFactory.getFactory(ModelFactory.ModelType.PRODUTTORE).create(rs);
                produttori.add(produttore);
            }
            return produttori;
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
    public int add(Produttore produttore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Produttore (Nome, Citta, Nazione, Sito) VALUES ('" + produttore.getNome() + "', '" + produttore.getCitta() + "', '" + produttore.getNazione() + "', '" + produttore.getSito() + "')";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idProduttore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Produttore WHERE idProduttore = '" + idProduttore + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Produttore produttore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Produttore SET Nome = '" + produttore.getNome() + "', Citta = '" + produttore.getCitta() + "', Nazione = '" + produttore.getNazione() + "', Sito = '" + produttore.getSito() + "' WHERE idProduttore = " + produttore.getIdProduttore();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Produttore WHERE Nome = '" + nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}