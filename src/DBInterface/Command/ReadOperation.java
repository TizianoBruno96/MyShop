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
    public ResultSet execute() {
        return connection.executeQuery(sql);
    }
}
