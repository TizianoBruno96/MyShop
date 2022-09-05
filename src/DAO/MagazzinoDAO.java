package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Magazzino;
import DAO.ModelFactory.MagazzinoFactory;
import Model.PuntoVendita;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MagazzinoDAO implements IMagazzinoDAO {
    private static MagazzinoDAO instance = new MagazzinoDAO();
    private Magazzino magazzino;
    private static IDBConnection connection;
    private static ResultSet rs;

    private MagazzinoDAO() {
        magazzino = null;
        connection = null;
        rs = null;
    }

    public static MagazzinoDAO getInstance() {
        return instance;
    }

    public Magazzino findByID(int IdMagazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Magazzino WHERE IdMagazzino = " + IdMagazzino;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                magazzino = new MagazzinoFactory().create(rs);
                return magazzino;
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

    public Magazzino findByPuntoVendita(int IdPuntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Magazzino WHERE IdPuntoVendita = " + IdPuntoVendita;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                magazzino = new MagazzinoFactory().create(rs);
                return magazzino;
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
    public ArrayList<Magazzino> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Magazzino";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Magazzino> magazzini = new ArrayList<Magazzino>();
        try {
            while(rs.next()) {
                magazzino = new MagazzinoFactory().create(rs);
                magazzini.add(magazzino);
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        return magazzini;
    }

    @Override
    public int add(Magazzino magazzino, int idPuntoVendita) {
        connection = DBConnection.getInstance();
        IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
        //Controllo se esiste già un magazzino per quel punto vendita
        if(MagazzinoDAO.getInstance().findByPuntoVendita(idPuntoVendita) != null) {
            return -1;
        }

        int rowCount = connection.executeUpdate("INSERT INTO Magazzino (idPuntoVendita, maxCorsia, maxScaffale) VALUES ('" + idPuntoVendita + "', '" + magazzino.getMaxCorsia() + "', '" + magazzino.getMaxScaffale() + "')");
        magazzino = MagazzinoDAO.getInstance().findByPuntoVendita(idPuntoVendita);
        rowCount += posizioneDAO.addPosizioniInMagazzino(magazzino);
        return rowCount;
    }

    @Override
    public int removeByID(int idMagazzino) {
        connection = DBConnection.getInstance();
        //Rimuovo tutte le posizioni del magazzino
        IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
        posizioneDAO.removeByMagazzino(idMagazzino);
        //Rimuovo il magazzino
        int rowCount = connection.executeUpdate("DELETE FROM Magazzino WHERE idMagazzino = '" + idMagazzino + "'");
        return rowCount;
    }

    @Override
    public int removeByPuntoVendita(int idPuntoVendita) {
        connection = DBConnection.getInstance();
        //Rimuovo tutte le posizioni del magazzino
        IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
        posizioneDAO.removeByMagazzino(MagazzinoDAO.getInstance().findByPuntoVendita(idPuntoVendita).getIdMagazzino());
        //Rimuovo il magazzino
        int rowCount = connection.executeUpdate("DELETE FROM Magazzino WHERE idPuntoVendita = '" + idPuntoVendita + "'");
        return rowCount;
    }

    @Override
    public int update(Magazzino magazzino) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Magazzino SET idPuntoVendita = '" + magazzino.getIdPuntoVendita() + "', maxCorsia = '" + magazzino.getMaxCorsia() + "', maxScaffale = '" + magazzino.getMaxScaffale() + "' WHERE idMagazzino = '" + magazzino.getIdMagazzino() + "'");
        return rowCount;
    }
}
