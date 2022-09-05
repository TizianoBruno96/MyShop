package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Fornitore;
import DAO.ModelFactory.FornitoreFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornitoreDAO implements IFornitoreDAO{
    private static final FornitoreDAO instance = new FornitoreDAO();
    private Fornitore fornitore;
    private static IDBConnection connection;
    private static ResultSet rs;

    private FornitoreDAO() {
        fornitore = null;
        connection = null;
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
            if(rs.getRow() == 1) {
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
            if(rs.getRow() == 1) {
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
    public ArrayList<Fornitore> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM fornitore";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Fornitore> fornitori = new ArrayList<>();
        try {
            while(rs.next()) {
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
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO fornitore (nome, sito) VALUES ('" + fornitore.getNome() + "', '" + fornitore.getSito() + "')");
        return result;
    }

    @Override
    public int removeByName(String nome) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Fornitore WHERE Nome = '" + nome + "'");
        return result;
    }

    @Override
    public int update(Fornitore fornitore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Fornitore SET Nome = '" + fornitore.getNome() + "' WHERE idFornitore = " + fornitore.getIdFornitore());
        return result;
    }
}
