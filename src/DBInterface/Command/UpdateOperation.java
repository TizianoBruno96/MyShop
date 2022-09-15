package DBInterface.Command;

import DBInterface.DBConnection;

public class UpdateOperation implements IDBOperation {
    private final DBConnection connection = DBConnection.getInstance();
    private final String sql;

    public UpdateOperation(String sql) {
        this.sql = sql;
    }

    @Override
    public DBOperationResult execute() {
        int affectedRows = connection.executeUpdate(sql);
        DBOperationResult result = new DBOperationResult();
        result.setType("UPDATE");
        result.setAffectedRows(affectedRows);
        return result;
    }
}
