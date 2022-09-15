package DAO;

import DAO.Interfaces.IClienteDAO;
import DBInterface.Command.CommandFactory;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;

public class ClienteDAO implements IClienteDAO {
    private static final ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    @Override
    public int add(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Cliente (idUtente) VALUES (" + idUtente + ")";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Cliente WHERE idUtente = " + idUtente;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
