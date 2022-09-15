package DBInterface.Command;

import DBInterface.DBConnection;

import java.sql.ResultSet;

public class ReadOperation implements IDBOperation {

    private final DBConnection connection = DBConnection.getInstance();
    private final String sql;

    public ReadOperation(String sql) {
        this.sql = sql;
    }

    @Override
    public DBOperationResult execute() {
        ResultSet resultSet = connection.executeQuery(sql);
        DBOperationResult result = new DBOperationResult();
        result.setType("SELECT");
        result.setResultSet(resultSet);
        return result;
    }
}
