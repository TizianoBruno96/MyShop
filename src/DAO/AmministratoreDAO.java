package DAO;

import DAO.Interfaces.IAmministratoreDAO;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.RemoveOperation;
import DBInterface.Command.WriteOperation;

public class AmministratoreDAO implements IAmministratoreDAO {
    private static final AmministratoreDAO instance = new AmministratoreDAO();

    public static AmministratoreDAO getInstance() {
        return instance;
    }

    @Override
    public int add(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Amministratore (idUtente) VALUES (" + idUtente + ")";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Amministratore WHERE idUtente = " + idUtente;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
