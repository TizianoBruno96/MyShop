package DBInterface;

import java.sql.ResultSet;

public interface IDBConnection {
    ResultSet executeQuery(String sqlStatement);

    int executeUpdate(String sqlStatement);

    void close();
}
