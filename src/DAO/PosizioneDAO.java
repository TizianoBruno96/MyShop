package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Posizione;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PosizioneDAO implements IPosizioneDAO {
    private static PosizioneDAO instance = new PosizioneDAO();
    private Posizione posizione;
    private static IDBConnection connection;
    private static ResultSet rs;

    private PosizioneDAO() {
        posizione = null;
        connection = null;
        rs = null;
    }

    public static PosizioneDAO getInstance() {
        return instance;
    }

    public Posizione findByID(int IdPosizione) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Posizione WHERE idPosizione = '" + IdPosizione + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                posizione = new Posizione();
                posizione.setIdPosizione(rs.getInt("idPosizione"));
                posizione.setpCorsia(rs.getInt("pCorsia"));
                posizione.setpScaffale(rs.getInt("pScaffale"));
                posizione.setQuantita(rs.getInt("Quantita"));
                posizione.setIdProdotto(rs.getInt("idProdotto"));
                posizione.setIdMagazzino(rs.getInt("idMagazzino"));
                return posizione;
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

    public ArrayList<Posizione> findByMagazzino(int idMagazzino) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Posizione WHERE idMagazzino = '" + idMagazzino + "'");
        ArrayList<Posizione> listaPosizioni = new ArrayList<>();
        try {
            while(rs.next()) {
                posizione = new Posizione();
                posizione.setIdPosizione(rs.getInt("idPosizione"));
                posizione.setpCorsia(rs.getInt("pCorsia"));
                posizione.setpScaffale(rs.getInt("pScaffale"));
                posizione.setQuantita(rs.getInt("Quantita"));
                posizione.setIdProdotto(rs.getInt("idProdotto"));
                posizione.setIdMagazzino(rs.getInt("idMagazzino"));
                listaPosizioni.add(posizione);
            }
            return listaPosizioni;
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
    public int add(Posizione posizione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Posizione (pCorsia, pScaffale, Quantita, idProdotto, idMagazzino) VALUES ('" + posizione.getpCorsia() + "', '" + posizione.getpScaffale() + "', '" + posizione.getQuantita() + "', '" + posizione.getIdProdotto() + "', '" + posizione.getIdMagazzino() + "')");
        connection.close();
        return result;
    }

    @Override
    public int removeByID(int idPosizione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Posizione WHERE idPosizione = '" + idPosizione + "'");
        connection.close();
        return result;
    }

    @Override
    public int update(Posizione posizione) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Posizione SET pCorsia = '" + posizione.getpCorsia() + "', pScaffale = '" + posizione.getpScaffale() + "', Quantita = '" + posizione.getQuantita() + "', idProdotto = '" + posizione.getIdProdotto() + "', idMagazzino = '" + posizione.getIdMagazzino() + "' WHERE idPosizione = '" + posizione.getIdPosizione() + "'");
        connection.close();
        return result;
    }
}