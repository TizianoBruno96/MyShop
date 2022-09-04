package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.PuntoVendita;
import DAO.ModelFactory.PuntoVenditaFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PuntoVenditaDAO implements IPuntoVenditaDAO {
    private static PuntoVenditaDAO instance = new PuntoVenditaDAO();
    private PuntoVendita puntoVendita;
    private static IDBConnection connection;
    private static ResultSet rs;


    private PuntoVenditaDAO() {
        puntoVendita = null;
        connection = null;
        rs = null;
    }

    public static PuntoVenditaDAO getInstance() {
        return instance;
    }

    public PuntoVendita findByManager(int idManager) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM puntovendita WHERE IdManager = " + idManager;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                puntoVendita = new PuntoVenditaFactory().create(rs);
                return puntoVendita;
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

    public ArrayList<PuntoVendita> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM puntovendita";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<PuntoVendita> puntiVendita = new ArrayList<>();
        try {
            while(rs.next()) {
                puntoVendita = new PuntoVenditaFactory().create(rs);
                puntiVendita.add(puntoVendita);
            }
            return puntiVendita;
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
    public ArrayList<PuntoVendita> findByCitta(String citta) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM puntovendita WHERE Citta = '" + citta + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<PuntoVendita> puntiVendita = new ArrayList<>();
        try {
            while(rs.next()) {
                puntoVendita = new PuntoVenditaFactory().create(rs);
                puntiVendita.add(puntoVendita);
            }
            return puntiVendita;
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
    public int add(PuntoVendita puntoVendita) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO puntovendita(Citta, Nome, Indirizzo, IdUtenteManager) VALUES ('" + puntoVendita.getCitta() + "', '" + puntoVendita.getNome() + "', '" + puntoVendita.getIndirizzo() + "', " + puntoVendita.getIdUtenteManager() + ")");
        return result;
    }

    @Override
    public int update(PuntoVendita puntoVendita) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE puntovendita SET Citta = '" + puntoVendita.getCitta() + "', Nome = '" + puntoVendita.getNome() + "', Indirizzo = '" + puntoVendita.getIndirizzo() + "', IdUtenteManager = " + puntoVendita.getIdUtenteManager() + " WHERE Id = " + puntoVendita.getIdPuntoVendita());
        return result;
    }

    @Override
    public int removeByID(int idPuntoVendita) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM puntovendita WHERE idPuntoVendita = " + idPuntoVendita);
        return result;
    }

    @Override
    public int removeByIDMagazzino(int idMagazzino) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM puntovendita WHERE idMagazzino = " + idMagazzino);
        return result;
    }
}
