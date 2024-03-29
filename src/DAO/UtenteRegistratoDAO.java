package DAO;

import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.CommandFactory;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import Model.Utenti.UtenteRegistrato;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteRegistratoDAO implements IUtenteRegistratoDAO {
    private static final UtenteRegistratoDAO instance = new UtenteRegistratoDAO();
    private static ResultSet rs;
    private UtenteRegistrato utenteRegistrato;

    private UtenteRegistratoDAO() {
        utenteRegistrato = null;
        rs = null;
    }

    public static UtenteRegistratoDAO getInstance() {
        return instance;
    }

    public ArrayList<UtenteRegistrato> findByUtente(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM UtenteRegistrato WHERE IdUtente = " + idUtente;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<UtenteRegistrato> utenti = new ArrayList<>();
        try {
            while (rs.next()) {
                utenteRegistrato = (UtenteRegistrato) ModelFactory.getFactory(ModelFactory.ModelType.UTENTE_REGISTRATO).create(rs);
                utenti.add(utenteRegistrato);
            }
            return utenti;
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return null;
    }

    public ArrayList<UtenteRegistrato> findByPuntoVendita(int idPuntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM UtenteRegistrato WHERE IdPuntoVendita = " + idPuntoVendita;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<UtenteRegistrato> utenti = new ArrayList<>();
        try {
            while (rs.next()) {
                utenteRegistrato = (UtenteRegistrato) ModelFactory.getFactory(ModelFactory.ModelType.UTENTE_REGISTRATO).create(rs);
                utenti.add(utenteRegistrato);
            }
            return utenti;
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return null;
    }

    @Override
    public int add(UtenteRegistrato utenteRegistrato) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO UtenteRegistrato (idUtente, idPuntoVendita) VALUES (" + utenteRegistrato.getIdUtente() + ", " + utenteRegistrato.getIdPuntoVendita() + ")";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(UtenteRegistrato utenteRegistrato) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE UtenteRegistrato SET idPuntoVendita = " + utenteRegistrato.getIdPuntoVendita() + " WHERE idUtente = " + utenteRegistrato.getIdUtente();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(UtenteRegistrato utenteRegistrato) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM UtenteRegistrato WHERE idUtente = " + utenteRegistrato.getIdUtente() + " AND idPuntoVendita = " + utenteRegistrato.getIdPuntoVendita();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDUtente(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM UtenteRegistrato WHERE idUtente = " + idUtente;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDPuntoVendita(int idPuntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM UtenteRegistrato WHERE idPuntoVendita = " + idPuntoVendita;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
