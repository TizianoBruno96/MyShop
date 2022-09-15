package DAO;

import DAO.Interfaces.IFornitoreDAO;
import DAO.ModelFactory.FornitoreFactory;
import DBInterface.Command.*;
import Model.Articoli.Fornitore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornitoreDAO implements IFornitoreDAO {
    private static final FornitoreDAO instance = new FornitoreDAO();
    private Fornitore fornitore;
    private static ResultSet rs;

    private FornitoreDAO() {
        fornitore = null;
        rs = null;
    }

    public static FornitoreDAO getInstance() {
        return instance;
    }

    @Override
    public Fornitore findByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM fornitore WHERE nome = '" + nome + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();

        try {
            rs.next();
            if (rs.getRow() == 1) {
                fornitore = new FornitoreFactory().create(rs);
                return fornitore;
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
    public Fornitore findByID(int idFornitore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM fornitore WHERE idFornitore = " + idFornitore;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();

        try {
            rs.next();
            if (rs.getRow() == 1) {
                fornitore = new FornitoreFactory().create(rs);
                return fornitore;
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
        String sql = "SELECT * FROM fornitore WHERE nome = '" + nome + "'";
        IDBOperation operation = new ReadOperation(sql);
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
    public ArrayList<Fornitore> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM fornitore";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Fornitore> fornitori = new ArrayList<>();
        try {
            while (rs.next()) {
                fornitore = new FornitoreFactory().create(rs);
                fornitori.add(fornitore);
            }
            return fornitori;
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
    public int add(Fornitore fornitore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO fornitore (nome, sito) VALUES ('" + fornitore.getNome() + "', '" + fornitore.getSito() + "')";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByName(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Fornitore WHERE Nome = '" + nome + "'";
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Fornitore fornitore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Fornitore SET Nome = '" + fornitore.getNome() + "' WHERE idFornitore = " + fornitore.getIdFornitore();
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
