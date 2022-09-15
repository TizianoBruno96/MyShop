package DAO;

import DAO.Interfaces.IManagerDAO;
import DBInterface.Command.CommandFactory;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;

public class ManagerDAO implements IManagerDAO {
    private static final ManagerDAO instance = new ManagerDAO();

    public static ManagerDAO getInstance() {
        return instance;
    }

    @Override
    public int add(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Manager (idUtente) VALUES (" + idUtente + ")";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Manager WHERE idUtente = " + idUtente;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}

