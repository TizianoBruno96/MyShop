package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.ListaAcquisto;
import DAO.ModelFactory.ListaAcquistoFactory;
import Model.Ordine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ListaAcquistoDAO implements IListaAcquistoDAO {
    private static ListaAcquistoDAO instance = new ListaAcquistoDAO();
    private ListaAcquisto listaAcquisto;
    private static IDBConnection connection;
    private static ResultSet rs;

    private ListaAcquistoDAO() {
        listaAcquisto = null;
        connection = null;
        rs = null;
    }

    public static ListaAcquistoDAO getInstance() {
        return instance;
    }

    public ListaAcquisto findByIDUtente(int IdUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ListaAcquisto WHERE IdUtente = " + IdUtente;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                listaAcquisto = new ListaAcquistoFactory().create(rs);
                return listaAcquisto;
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

    public ListaAcquisto findByID(int IdListaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ListaAcquisto WHERE IdListaAcquisto = " + IdListaAcquisto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                listaAcquisto = new ListaAcquistoFactory().create(rs);
                return listaAcquisto;
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
    public int add(ListaAcquisto listaAcquisto) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO ListaAcquisto (IdUtente, CostoTotale, isPagata) VALUES (" + listaAcquisto.getIdUtente() + ", " + listaAcquisto.getCostoTot() + ", " + listaAcquisto.isPagata() + ")");
        return result;
    }

    @Override
    public int removeByIDUtente(int idUtente) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM ListaAcquisto WHERE idUtente = '" + idUtente + "'");
        return result;
    }

    @Override
    public int removeByID(int idListaAcquisto) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM ListaAcquisto WHERE idListaAcquisto = '" + idListaAcquisto + "'");
        return result;
    }

    @Override
    public int update(ListaAcquisto listaAcquisto) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE ListaAcquisto SET IdUtente = " + listaAcquisto.getIdUtente() + ", CostoTotale = " + listaAcquisto.getCostoTot() + ", isPagata = " + listaAcquisto.isPagata() + " WHERE IdListaAcquisto = " + listaAcquisto.getIdListaAcquisto());
        return result;
    }

    @Override
    public int updateCostoTot(ListaAcquisto listaAcquisto, int costoTot) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE ListaAcquisto SET CostoTotale = '" + costoTot + "' WHERE idListaAcquisto = '" + listaAcquisto.getIdListaAcquisto() + "'");
        return result;
    }

    @Override
    public int updateCostoTot(ListaAcquisto listaAcquisto) {
        connection = DBConnection.getInstance();
        IOrdineDAO ordineDAO = OrdineDAO.getInstance();
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        DecimalFormat format = new DecimalFormat("0.00", dfs);
        dfs.setDecimalSeparator(',');

        float tot = 0;
        for (Ordine o : ordineDAO.findByListaAcquisto(listaAcquisto.getIdListaAcquisto())) {
            tot += o.getQuantita() * prodottoDAO.findByID(o.getIdProdotto()).getCosto();
        }
        System.out.println("tot: " + tot);
        System.out.println("format: " + format.format(tot));

        //TODO sistemare il formato del costo totale
        int rowCount = connection.executeUpdate("UPDATE ListaAcquisto SET CostoTotale = " + tot + " WHERE IdListaAcquisto = " + listaAcquisto.getIdListaAcquisto());
        return rowCount;
    }
}
