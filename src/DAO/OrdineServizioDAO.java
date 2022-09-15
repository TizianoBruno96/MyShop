package DAO;

import DAO.Interfaces.IOrdineServizioDAO;
import DAO.ModelFactory.OrdineServizioFactory;
import DBInterface.Command.*;
import Model.Articoli.Servizio;
import Model.ListaAcquisto;
import Model.OrdineServizio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineServizioDAO implements IOrdineServizioDAO {
    private static final OrdineServizioDAO instance = new OrdineServizioDAO();
    private OrdineServizio ordineServizio;
    private static ResultSet rs;

    private OrdineServizioDAO() {
        ordineServizio = null;
        rs = null;
    }

    public static OrdineServizioDAO getInstance() {
        return instance;
    }

    @Override
    public ArrayList<OrdineServizio> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineServizio";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<OrdineServizio> ordini = new ArrayList<>();
        try {
            while (rs.next()) {
                ordineServizio = new OrdineServizioFactory().create(rs);
                ordini.add(ordineServizio);
            }
            return ordini;
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
    public ArrayList<OrdineServizio> findByIDServizio(int idServizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineServizio WHERE idServizio = " + idServizio;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<OrdineServizio> ordini = new ArrayList<>();
        try {
            while (rs.next()) {
                ordineServizio = new OrdineServizioFactory().create(rs);
                ordini.add(ordineServizio);
            }
            return ordini;
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
    public ArrayList<OrdineServizio> findByIDListaAcquisto(int idListaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineServizio WHERE idListaAcquisto = " + idListaAcquisto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<OrdineServizio> ordini = new ArrayList<>();
        try {
            while (rs.next()) {
                ordineServizio = new OrdineServizioFactory().create(rs);
                ordini.add(ordineServizio);
            }
            return ordini;
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
    public OrdineServizio find(Servizio servizio, ListaAcquisto listaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM OrdineServizio WHERE idServizio = " + servizio.getIdServizio() + " AND idListaAcquisto = " + listaAcquisto.getIdListaAcquisto();
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            if (rs.next()) {
                ordineServizio = new OrdineServizioFactory().create(rs);
                return ordineServizio;
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
    public int add(OrdineServizio ordineServizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO OrdineServizio (idServizio, idListaAcquisto) VALUES (" + ordineServizio.getIdServizio() + ", " + ordineServizio.getIdListaAcquisto() + ")";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDServizio(int idServizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM OrdineServizio WHERE idServizio = " + idServizio;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDListaAcquisto(int idListaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM OrdineServizio WHERE idListaAcquisto = " + idListaAcquisto;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idServizio, int idListaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM OrdineServizio WHERE idServizio = " + idServizio + " AND idListaAcquisto = " + idListaAcquisto;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Servizio servizio) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE OrdineServizio SET idServizio = " + servizio.getIdServizio() + " WHERE idServizio = " + servizio.getIdServizio();
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
