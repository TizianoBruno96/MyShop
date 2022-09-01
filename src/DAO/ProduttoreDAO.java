package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Produttore;
import Model.ModelFactory.ProduttoreFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduttoreDAO implements IProduttoreDAO {
    private static ProduttoreDAO instance = new ProduttoreDAO();
    private Produttore produttore;
    private static IDBConnection connection;
    private static ResultSet rs;

    private ProduttoreDAO() {
        produttore = null;
        connection = null;
        rs = null;
    }

    public static ProduttoreDAO getInstance() {
        return instance;
    }

    @Override
    public Produttore findByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Produttore WHERE Nome = '" + nome + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                produttore = new ProduttoreFactory().create(rs);
                return produttore;
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
    public ArrayList<Produttore> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Produttore";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Produttore> produttori = new ArrayList<>();
        try {
            while(rs.next()) {
                produttore = new ProduttoreFactory().create(rs);
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
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public int add(Produttore produttore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Produttore (Nome, Citta, Nazione, SitoWeb) VALUES ('" + produttore.getNome() + "', '" + produttore.getCitta() + "', '" + produttore.getNazione() + "', '" + produttore.getSitoWeb() + "')");
        connection.close();
        return result;
    }

    @Override
    public int removeByID(int idProduttore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Produttore WHERE idProduttore = " + idProduttore);
        connection.close();
        return result;
    }

    @Override
    public int update(Produttore produttore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Produttore SET Nome = '" + produttore.getNome() + "', Citta = '" + produttore.getCitta() + "', Nazione = '" + produttore.getNazione() + "', SitoWeb = '" + produttore.getSitoWeb() + "' WHERE idProduttore = " + produttore.getIdProduttore());
        connection.close();
        return result;
    }

    @Override
    public int removeByNome(String nome) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Produttore WHERE Nome = '" + nome + "'");
        connection.close();
        return result;
    }
}