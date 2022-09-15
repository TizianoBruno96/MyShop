package DAO;

import DAO.Interfaces.IGuestDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.*;
import Model.Guest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestDAO implements IGuestDAO {
    private static final GuestDAO instance = new GuestDAO();
    private Guest guest;
    private static ResultSet rs;

    private GuestDAO() {
        guest = null;
        rs = null;
    }

    public static GuestDAO getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Guest> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Guest";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Guest> guests = new ArrayList<>();
        try {
            while (rs.next()) {
                guest = (Guest) ModelFactory.getFactory(ModelFactory.ModelType.GUEST).create(rs);
                guests.add(guest);
            }
            return guests;
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
    public Guest findByID(int id) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Guest WHERE idGuest = " + id;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            if (rs.next()) {
                guest = (Guest) ModelFactory.getFactory(ModelFactory.ModelType.GUEST).create(rs);
                return guest;
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

    public Guest findByIP(String IP) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Guest WHERE IP = '" + IP + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            if (rs.next()) {
                guest = (Guest) ModelFactory.getFactory(ModelFactory.ModelType.GUEST).create(rs);
                return guest;
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
    public int add(Guest guest) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Guest (IP) VALUES ('" + guest.getIPGuest() + "')";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int id) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Guest WHERE idGuest = " + id;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIP(String IP) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Guest WHERE IP = '" + IP + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Guest guest) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Guest SET IP = '" + guest.getIPGuest() + "' WHERE idGuest = " + guest.getIdGuest();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
