package DBInterface.Command;

import DBInterface.DBConnection;

public class WriteOperation implements IDBOperation {
    private final DBConnection connection = DBConnection.getInstance();
    private final String sql;

    public WriteOperation(String sql) {
        this.sql = sql;
    }

    @Override
    public DBOperationResult execute() {
        int affectedRows = connection.executeUpdate(sql);
        DBOperationResult result = new DBOperationResult();
        result.setType("INSERT");
        result.setAffectedRows(affectedRows);
        return result;
    }
}