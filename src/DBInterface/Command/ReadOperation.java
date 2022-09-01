package DBInterface.Command;

import DBInterface.DBConnection;

import java.sql.ResultSet;

public class ReadOperation implements IDBOperation {

    private DBConnection connection = DBConnection.getInstance();

    public ReadOperation(String sql) {
        this.sql = sql;
    }

    private String sql;

    @Override
    public DBOperationResult execute() {
        ResultSet resultSet = connection.executeQuery(sql);
        DBOperationResult result = new DBOperationResult();
        result.setType("SELECT");
        result.setResultSet(resultSet);
        return result;
    }
}
