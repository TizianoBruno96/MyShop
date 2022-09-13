package DAO;

import DAO.Interfaces.IClienteDAO;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.RemoveOperation;
import DBInterface.Command.WriteOperation;

public class ClienteDAO implements IClienteDAO {
    private static final ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    @Override
    public int add(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Cliente (idUtente) VALUES (" + idUtente + ")";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Cliente WHERE idUtente = " + idUtente;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
