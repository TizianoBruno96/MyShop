package DBInterface.Command;

import DBInterface.DBConnection;

public class RemoveOperation implements IDBOperation {
    private final DBConnection connection = DBConnection.getInstance();
    private final String sql;

    public RemoveOperation(String sql) {
        this.sql = sql;
    }

    @Override
    public DBOperationResult execute() {
        int affectedRows = connection.executeUpdate(sql);
        DBOperationResult result = new DBOperationResult();
        result.setType("DELETE");
        result.setAffectedRows(affectedRows);
        return result;
    }
}
