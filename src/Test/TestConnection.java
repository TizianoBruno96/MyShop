package Test;

import DBInterface.DBUser;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        DBUser dbUser = DBUser.getInstance();

        try {
            Class cls = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Ho caricato la classe: " + cls.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Non ho trovato il driver per MySQL JDBC: " + e.getMessage());
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbUser.getSchemaName() + "?serverTimezone=UTC", dbUser.getUsername(), dbUser.getPwd());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT Nome, Cognome, Username, Email FROM Utente");
            while(rs.next()) {
                System.out.println("Nome: " + rs.getString("Nome") + "");
                System.out.println("Cognome: " + rs.getString("Cognome") + "");
                System.out.println("Username: " + rs.getString("Username") + "");
                System.out.println("Email: " + rs.getString("Email") + "");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                    System.out.println("SQL State: " + e.getSQLState());
                    System.out.println("Vendor Error: " + e.getErrorCode());
                }
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Vendor Error: " + e.getErrorCode());
            }
            try {
                if (conn != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Vendor Error: " + e.getErrorCode());
            }
        }
    }
}
