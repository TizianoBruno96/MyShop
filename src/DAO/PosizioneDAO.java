package DAO;

import DAO.Interfaces.IPosizioneDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.*;
import Model.Articoli.Prodotto;
import Model.Magazzino;
import Model.Posizione;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PosizioneDAO implements IPosizioneDAO {
    private static final PosizioneDAO instance = new PosizioneDAO();
    private Posizione posizione;
    private static ResultSet rs;

    private PosizioneDAO() {
        posizione = null;
        rs = null;
    }

    public static PosizioneDAO getInstance() {
        return instance;
    }

    @Override
    public Posizione findByID(int IdPosizione) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Posizione WHERE IdPosizione = " + IdPosizione;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                posizione = (Posizione) ModelFactory.getFactory(ModelFactory.ModelType.POSIZIONE).create(rs);
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
    public Posizione find(int pCorsia, int pScaffale, int idMagazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Posizione WHERE pCorsia = " + pCorsia + " AND pScaffale = " + pScaffale + " AND IdMagazzino = " + idMagazzino;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                posizione = (Posizione) ModelFactory.getFactory(ModelFactory.ModelType.POSIZIONE).create(rs);
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
    public ArrayList<Posizione> findByProdotto(Prodotto prodotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Posizione WHERE IdProdotto = " + prodotto.getIdProdotto();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Posizione> posizioni = new ArrayList<>();
        try {
            while (rs.next()) {
                posizione = (Posizione) ModelFactory.getFactory(ModelFactory.ModelType.POSIZIONE).create(rs);
                posizioni.add(posizione);
            }
            return posizioni;
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
    public ArrayList<Posizione> find(int idProdotto, int idMagazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Posizione WHERE IdProdotto = " + idProdotto + " AND IdMagazzino = " + idMagazzino;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Posizione> posizioni = new ArrayList<>();
        try {
            while (rs.next()) {
                posizione = (Posizione) ModelFactory.getFactory(ModelFactory.ModelType.POSIZIONE).create(rs);
                posizioni.add(posizione);
            }
            return posizioni;
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Posizione> listaPosizioni = new ArrayList<>();
        try {
            while (rs.next()) {
                posizione = (Posizione) ModelFactory.getFactory(ModelFactory.ModelType.POSIZIONE).create(rs);
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
        for (int i = 1; i < magazzino.getMaxCorsia() + 1; i++) {
            for (int j = 1; j < magazzino.getMaxScaffale() + 1; j++) {
                rowCount += add(new Posizione(i, j, 0), magazzino.getIdMagazzino());
            }
        }
        return rowCount;
    }

    @Override
    public int addProdottoInPosizione(Prodotto prodotto, int corsia, int scaffale, int idMagazzino, int quantita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Posizione SET IdProdotto = " + prodotto.getIdProdotto() + ", Quantita = " + quantita + " WHERE IdMagazzino = " + idMagazzino + " AND pCorsia = " + corsia + " AND pScaffale = " + scaffale;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int add(Posizione posizione, int idMagazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Posizione (pCorsia, pScaffale, Quantita, idProdotto, idMagazzino) VALUES ('" + posizione.getpCorsia() + "', '" + posizione.getpScaffale() + "', '" + posizione.getQuantita() + "', NULL, '" + idMagazzino + "')";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idPosizione) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Posizione WHERE idPosizione = " + idPosizione;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByMagazzino(int idMagazzino) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Posizione WHERE idMagazzino = " + idMagazzino;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Posizione posizione) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Posizione SET pCorsia = " + posizione.getpCorsia() + ", pScaffale = " + posizione.getpScaffale() + ", Quantita = " + posizione.getQuantita() + ", idProdotto = " + posizione.getIdProdotto() + " WHERE idPosizione = " + posizione.getIdPosizione();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int updateQuantita(Posizione posizione, int quantita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Posizione SET Quantita = " + quantita + " WHERE idPosizione = " + posizione.getIdPosizione();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}