package DBInterface;

import java.sql.*;

public class DBConnection implements IDBConnection {
    private static final DBUser dbUser = DBUser.getInstance();
    private static final DBConnection instance = new DBConnection();
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static int rowCount;

    private DBConnection() {
        conn = null;
        stmt = null;
        rs = null;
        rowCount = 0;
        try {
            Class cls = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Ho caricato la classe: " + cls.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Non ho trovato il driver per MySQL JDBC: " + e.getMessage());
        }
    }

    public static DBConnection getInstance() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbUser.getSchemaName() + "?serverTimezone=UTC", dbUser.getUsername(), dbUser.getPwd());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        }
        return instance;
    }

    @Override
    public ResultSet executeQuery(String sqlStatement) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlStatement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        }
        return rs;
    }

    @Override
    public int executeUpdate(String sqlStatement) {
        try {
            stmt = conn.createStatement();
            rowCount = stmt.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        }
        return rowCount;
    }

    @Override
    public void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Vendor Error: " + e.getErrorCode());
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Vendor Error: " + e.getErrorCode());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Vendor Error: " + e.getErrorCode());
            }
        }
    }
}
