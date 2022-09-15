package DAO;

import DAO.Interfaces.IMagazzinoDAO;
import DAO.ModelFactory.MagazzinoFactory;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.*;
import Model.Magazzino;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MagazzinoDAO implements IMagazzinoDAO {
    private static final MagazzinoDAO instance = new MagazzinoDAO();
    private Magazzino magazzino;
    private static ResultSet rs;

    private MagazzinoDAO() {
        magazzino = null;
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
            if (rs.getRow() == 1) {
                magazzino = (Magazzino) ModelFactory.getFactory("MAGAZZINO").create(rs);
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
            if (rs.getRow() == 1) {
                magazzino = (Magazzino) ModelFactory.getFactory("MAGAZZINO").create(rs);
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
            while (rs.next()) {
                magazzino = (Magazzino) ModelFactory.getFactory("MAGAZZINO").create(rs);
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
        DBOperationExecutor executor = new DBOperationExecutor();
        if (MagazzinoDAO.getInstance().findByPuntoVendita(idPuntoVendita) != null) {
            return -1;
        }
        String sql = "INSERT INTO Magazzino (idPuntoVendita, maxCorsia, maxScaffale) VALUES ('" + idPuntoVendita + "', '" + magazzino.getMaxCorsia() + "', '" + magazzino.getMaxScaffale() + "')";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idMagazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Magazzino WHERE idMagazzino = '" + idMagazzino + "'";
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByPuntoVendita(int idPuntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Magazzino WHERE idPuntoVendita = '" + idPuntoVendita + "'";
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Magazzino magazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Magazzino SET idPuntoVendita = '" + magazzino.getIdPuntoVendita() + "', maxCorsia = '" + magazzino.getMaxCorsia() + "', maxScaffale = '" + magazzino.getMaxScaffale() + "' WHERE idMagazzino = '" + magazzino.getIdMagazzino() + "'";
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
