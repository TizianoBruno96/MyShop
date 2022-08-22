package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Servizio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServizioDAO implements IServizioDAO {
    private static ServizioDAO instance = new ServizioDAO();
    private Servizio servizio;
    private static IDBConnection connection;
    private static ResultSet rs;

    private ServizioDAO() {
        servizio = null;
        connection = null;
        rs = null;
    }

    public static ServizioDAO getInstance() {
        return instance;
    }

    public Servizio findByNome(String nome) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Servizio WHERE Nome = '" + nome + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                servizio = new Servizio();
                servizio.setIdServizio(rs.getInt("idServizio"));
                servizio.setNome(rs.getString("Nome"));
                servizio.setIdCategoria(rs.getInt("idCategoria"));
                servizio.setIdFornitore(rs.getInt("idFornitore"));
                return servizio;
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

    public ArrayList<Servizio> findAll() {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Servizio");
        ArrayList<Servizio> servizi = new ArrayList<>();
        try {
            while(rs.next()) {
                servizio = new Servizio();
                servizio.setIdServizio(rs.getInt("idServizio"));
                servizio.setNome(rs.getString("Nome"));
                servizio.setIdCategoria(rs.getInt("idCategoria"));
                servizio.setIdFornitore(rs.getInt("idFornitore"));
                servizi.add(servizio);
            }
            return servizi;
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
    public int add(Servizio servizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Servizio (Nome, idCategoria, idFornitore) VALUES ('" + servizio.getNome() + "', " + servizio.getIdCategoria() + ", " + servizio.getIdFornitore() + ")");
        connection.close();
        return result;
    }

    @Override
    public int update(Servizio servizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Servizio SET Nome = '" + servizio.getNome() + "', idCategoria = " + servizio.getIdCategoria() + ", idFornitore = " + servizio.getIdFornitore() + " WHERE idServizio = " + servizio.getIdServizio());
        connection.close();
        return result;
    }

    @Override
    public int remove(Servizio servizio) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Servizio WHERE idServizio = " + servizio.getIdServizio());
        connection.close();
        return result;
    }
}
