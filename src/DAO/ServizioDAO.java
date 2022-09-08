package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;
import DAO.ModelFactory.ServizioFactory;

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

    @Override
    public Servizio findByID(int idServizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Servizio WHERE IdServizio = " + idServizio;
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
        }
        return null;
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
        }
        return null;
    }

    @Override
    public ArrayList<Servizio> findByCategoria(int idCategoria) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Servizio WHERE IdCategoria = " + idCategoria;
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
        }
        return null;
    }

    @Override
    public int add(Servizio servizio, int idCategoria, int idFornitore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Servizio (Nome, IdCategoria, IdFornitore, Costo) VALUES ('" + servizio.getNome() + "', " + idCategoria + ", " + idFornitore + ", " + servizio.getCosto() + ")");
        return result;
    }

    @Override
    public int update(Servizio servizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Servizio SET Nome = '" + servizio.getNome() + "', IdCategoria = " + servizio.getIdCategoria() + ", IdFornitore = " + servizio.getIdFornitore() + ", Costo = " + servizio.getCosto() + " WHERE IdServizio = " + servizio.getIdServizio());
        return result;
    }

    @Override
    public int removeByID(int idServizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Servizio WHERE idServizio = " + idServizio);
        return result;
    }

    @Override
    public int removeByNome(String nome) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Servizio WHERE Nome = '" + nome + "'");
        return result;
    }

    @Override
    public int removeByFornitore(int idFornitore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Servizio WHERE IdFornitore = " + idFornitore);
        return result;
    }

    @Override
    public int removeByFornitore(Fornitore Fornitore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Servizio WHERE IdFornitore = " + Fornitore.getIdFornitore());
        return result;
    }
}
