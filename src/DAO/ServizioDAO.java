package DAO;

import DAO.Interfaces.IServizioDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.CommandFactory;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServizioDAO implements IServizioDAO {
    private static final ServizioDAO instance = new ServizioDAO();
    private static ResultSet rs;
    private Servizio servizio;

    private ServizioDAO() {
        servizio = null;
        rs = null;
    }

    public static ServizioDAO getInstance() {
        return instance;
    }

    @Override
    public Servizio findByID(int idServizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Servizio WHERE IdServizio = " + idServizio;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                servizio = (Servizio) ModelFactory.getFactory(ModelFactory.ModelType.SERVIZIO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                servizio = (Servizio) ModelFactory.getFactory(ModelFactory.ModelType.SERVIZIO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Servizio> servizi = new ArrayList<>();
        try {
            while (rs.next()) {
                servizio = (Servizio) ModelFactory.getFactory(ModelFactory.ModelType.SERVIZIO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Servizio> servizi = new ArrayList<>();
        try {
            while (rs.next()) {
                servizio = (Servizio) ModelFactory.getFactory(ModelFactory.ModelType.SERVIZIO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Servizio> servizi = new ArrayList<>();
        try {
            while (rs.next()) {
                servizio = (Servizio) ModelFactory.getFactory(ModelFactory.ModelType.SERVIZIO).create(rs);
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
    public boolean checkNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Servizio WHERE Nome = '" + nome + "'";
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
    public int add(Servizio servizio, int idCategoria, int idFornitore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Servizio (Nome, IdCategoria, IdFornitore, Costo) VALUES ('" + servizio.getNome() + "', " + idCategoria + ", " + idFornitore + ", " + servizio.getCosto() + ")";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Servizio servizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Servizio SET Nome = '" + servizio.getNome() + "', IdCategoria = " + servizio.getIdCategoria() + ", IdFornitore = " + servizio.getIdFornitore() + ", Costo = " + servizio.getCosto() + " WHERE IdServizio = " + servizio.getIdServizio();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idServizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Servizio WHERE IdServizio = " + idServizio;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Servizio WHERE Nome = '" + nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByFornitore(int idFornitore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Servizio WHERE IdFornitore = " + idFornitore;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByFornitore(Fornitore Fornitore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Servizio WHERE IdFornitore = " + Fornitore.getIdFornitore();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
