package DBInterface.Command;

import DBInterface.DBConnection;

public class UpdateOperation implements IDBOperation {
    private DBConnection connection = DBConnection.getInstance();
    private String sql;

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
