package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Prodotto;
import Model.Magazzino;
import Model.Posizione;
import DAO.ModelFactory.PosizioneFactory;

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

    @Override
    public Posizione findByID(int IdPosizione) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Posizione WHERE IdPosizione = " + IdPosizione;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                posizione = new PosizioneFactory().create(rs);
                return posizione;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Posizione> findByMagazzino(int idMagazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Posizione WHERE IdMagazzino = " + idMagazzino;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Posizione> listaPosizioni = new ArrayList<>();
        try {
            while(rs.next()) {
                posizione = new PosizioneFactory().create(rs);
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
        }
        return null;
    }

    @Override
    public int addPosizioniInMagazzino(Magazzino magazzino) {
        int rowCount = 0;
        System.out.println("ID: " + magazzino.getIdMagazzino());
        System.out.println("MaxScaffale: " + magazzino.getMaxScaffale());
        System.out.println("MaxCorsia: " + magazzino.getMaxCorsia());
        for(int i = 0; i < magazzino.getMaxCorsia(); i++) {
            for(int j = 0; j < magazzino.getMaxScaffale(); j++) {
                rowCount += add(new Posizione(i, j, 0), magazzino.getIdMagazzino());
            }
        }
        return rowCount;
    }

    @Override
    public int addProdottoInPosizione(Prodotto prodotto, Posizione posizione, int idMagazzino, int quantita) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Posizione SET IdProdotto = " + prodotto.getIdProdotto() + ", Quantita = " + quantita + " WHERE IdMagazzino = " + idMagazzino + " AND pCorsia = " + posizione.getpCorsia() + " AND pScaffale = " + posizione.getpScaffale());
        return rowCount;
    }

    @Override
    public int add(Posizione posizione, int idMagazzino) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("INSERT INTO Posizione (pCorsia, pScaffale, Quantita, idProdotto, idMagazzino) VALUES ('" + posizione.getpCorsia() + "', '" + posizione.getpScaffale() + "', '" + posizione.getQuantita() + "', NULL, '" + idMagazzino + "')");
        return rowCount;
    }

    @Override
    public int removeByID(int idPosizione) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Posizione WHERE idPosizione = '" + idPosizione + "'");
        return rowCount;
    }

    @Override
    public int removeByMagazzino(int idMagazzino) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Posizione WHERE idMagazzino = '" + idMagazzino + "'");
        return rowCount;
    }

    @Override
    public int update(Posizione posizione) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Posizione SET pCorsia = '" + posizione.getpCorsia() + "', pScaffale = '" + posizione.getpScaffale() + "', Quantita = '" + posizione.getQuantita() + "', idProdotto = '" + posizione.getIdProdotto() + "', idMagazzino = '" + posizione.getIdMagazzino() + "' WHERE idPosizione = '" + posizione.getIdPosizione() + "'");
        return rowCount;
    }
}
