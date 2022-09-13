package DAO;

import DAO.Interfaces.IMagazzinoDAO;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.ModelFactory.PuntoVenditaFactory;
import DBInterface.Command.*;
import Model.Magazzino;
import Model.PuntoVendita;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PuntoVenditaDAO implements IPuntoVenditaDAO {
    private static final PuntoVenditaDAO instance = new PuntoVenditaDAO();
    private PuntoVendita puntoVendita;
    private static ResultSet rs;

    private PuntoVenditaDAO() {
        puntoVendita = null;
        rs = null;
    }

    public static PuntoVenditaDAO getInstance() {
        return instance;
    }

    @Override
    public PuntoVendita findByID(int idPuntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM PuntoVendita WHERE idPuntoVendita = " + idPuntoVendita;
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

    public PuntoVendita findByManager(int idManager) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM puntovendita WHERE IdUtenteManager = " + idManager;
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

    @Override
    public PuntoVendita findByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM PuntoVendita WHERE Nome = '" + nome + "'";
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
    public int add(PuntoVendita puntoVendita, int idManager) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO puntovendita(Citta, Nome, Indirizzo, IdUtenteManager) VALUES ('" + puntoVendita.getCitta() + "', '" + puntoVendita.getNome() + "', '" + puntoVendita.getIndirizzo() + "', " + idManager + ")";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int add(PuntoVendita puntoVendita, Magazzino magazzino, int idManager) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO puntovendita(Citta, Nome, Indirizzo, IdUtenteManager) VALUES ('" + puntoVendita.getCitta() + "', '" + puntoVendita.getNome() + "', '" + puntoVendita.getIndirizzo() + "', " + idManager + ")";
        IDBOperation operation = new WriteOperation(sql);
        int rowCount = executor.executeOperation(operation).getAffectedRows();

        //aggiungo il magazzino
        PuntoVendita puntoVenditaTemp = findByManager(idManager);
        IMagazzinoDAO magazzinoDAO = MagazzinoDAO.getInstance();
        rowCount += magazzinoDAO.add(magazzino, puntoVenditaTemp.getIdPuntoVendita());
        return rowCount;
    }

    @Override
    public int update(PuntoVendita puntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE puntovendita SET Citta = '" + puntoVendita.getCitta() + "', Nome = '" + puntoVendita.getNome() + "', Indirizzo = '" + puntoVendita.getIndirizzo() + "', IdUtenteManager = " + puntoVendita.getIdUtenteManager() + " WHERE idPuntoVendita = " + puntoVendita.getIdPuntoVendita();
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idPuntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM puntovendita WHERE idPuntoVendita = " + idPuntoVendita;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDManager(int idManager) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM puntovendita WHERE IdUtenteManager = " + idManager;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
