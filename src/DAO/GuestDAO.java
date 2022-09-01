package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Guest;
import Model.ModelFactory.GuestFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestDAO implements IGuestDAO {
    private static GuestDAO instance = new GuestDAO();
    private Guest guest;
    private static IDBConnection connection;
    private static ResultSet rs;

    private GuestDAO() {
        guest = null;
        connection = null;
        rs = null;
    }

    public static GuestDAO getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Guest> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Guest";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Guest> guests = new ArrayList<>();
        try {
            while(rs.next()) {
                guest = new GuestFactory().create(rs);
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
        } finally {
            connection.close();
        }
        return null;
    }

    public Guest findByIP(String email) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Guest WHERE email = '" + email + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                guest = new GuestFactory().create(rs);
                return guest;
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
    public int add(Guest guest) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Guest (IPGuest) VALUES ('" + guest.getIPGuest() + "')");
        connection.close();
        return result;
    }

    @Override
    public int removeByName(String nome) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Guest WHERE IPGuest = '" + nome + "'");
        connection.close();
        return result;
    }

    @Override
    public int update(Guest guest) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Guest SET IPGuest = '" + guest.getIPGuest() + "' WHERE idGuest = " + guest.getIdGuest());
        connection.close();
        return result;
    }
}
