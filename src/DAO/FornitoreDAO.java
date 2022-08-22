package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Fornitore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FornitoreDAO implements IFornitoreDAO{
    private static FornitoreDAO instance = new FornitoreDAO();
    private Fornitore fornitore;
    private static IDBConnection connection;
    private static ResultSet rs;

    private FornitoreDAO() {
        fornitore = null;
        connection = null;
        rs = null;
    }

    public static FornitoreDAO getInstance() {
        return instance;
    }

    @Override
    public Fornitore findByNome(String nome) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Fornitore WHERE Nome = '" + nome + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                fornitore = new Fornitore();
                fornitore.setNome(rs.getString("Nome"));
                fornitore.setIdFornitore(rs.getInt("idFornitore"));
                return fornitore;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public ArrayList<Fornitore> findAll() {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Fornitore");
        ArrayList<Fornitore> fornitori = new ArrayList<>();
        try {
            while(rs.next()) {
                fornitore = new Fornitore();
                fornitore.setNome(rs.getString("Nome"));
                fornitore.setIdFornitore(rs.getInt("idFornitore"));
                fornitori.add(fornitore);
                return fornitori;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public int add(Fornitore fornitore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Fornitore (Nome) VALUES ('" + fornitore.getNome() + "')");
        connection.close();
        return result;
    }

    @Override
    public int removeByName(String nome) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Fornitore WHERE Nome = '" + nome + "'");
        connection.close();
        return result;
    }

    @Override
    public int update(Fornitore fornitore) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Fornitore SET Nome = '" + fornitore.getNome() + "' WHERE idFornitore = " + fornitore.getIdFornitore());
        connection.close();
        return result;
    }
}
