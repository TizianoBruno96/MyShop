package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Servizio;
import Model.ModelFactory.ServizioFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServizioDAO implements IServizioDAO {
    private static ServizioDAO instance = new ServizioDAO();
    private Servizio servizio;
    private static IDBConnection connection;
    private static ResultSet rs;

    private ServizioDAO() {
        servizio = null;
        connection = null;
        rs = null;
    }

    public static ServizioDAO getInstance() {
        return instance;
    }

    public Servizio findByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Servizio WHERE Nome = '" + nome + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                servizio = new ServizioFactory().create(rs);
                return servizio;
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

    public ArrayList<Servizio> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Servizio";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Servizio> servizi = new ArrayList<>();
        try {
            while(rs.next()) {
                servizio = new ServizioFactory().create(rs);
                servizi.add(servizio);
            }
            return servizi;
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
    public ArrayList<Servizio> findByFornitore(int idFornitore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Servizio WHERE IdFornitore = " + idFornitore;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Servizio> servizi = new ArrayList<>();
        try {
            while(rs.next()) {
                servizio = new ServizioFactory().create(rs);
                servizi.add(servizio);
            }
            return servizi;
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
    public int add(Servizio servizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Servizio (Nome, idCategoria, idFornitore) VALUES ('" + servizio.getNome() + "', " + servizio.getIdCategoria() + ", " + servizio.getIdFornitore() + ")");
        connection.close();
        return result;
    }

    @Override
    public int update(Servizio servizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Servizio SET Nome = '" + servizio.getNome() + "', idCategoria = " + servizio.getIdCategoria() + ", idFornitore = " + servizio.getIdFornitore() + " WHERE idServizio = " + servizio.getIdServizio());
        connection.close();
        return result;
    }

    @Override
    public int remove(Servizio servizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Servizio WHERE idServizio = " + servizio.getIdServizio());
        connection.close();
        return result;
    }
}
