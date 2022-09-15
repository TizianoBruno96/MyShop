package DAO;

import DAO.Interfaces.IAmministratoreDAO;
import DBInterface.Command.*;

public class AmministratoreDAO implements IAmministratoreDAO {
    private static final AmministratoreDAO instance = new AmministratoreDAO();

    public static AmministratoreDAO getInstance() {
        return instance;
    }

    @Override
    public int add(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Amministratore (idUtente) VALUES (" + idUtente + ")";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Amministratore WHERE idUtente = " + idUtente;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
