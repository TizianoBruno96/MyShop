package DAO;

import DAO.Interfaces.*;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.*;
import Model.ListaAcquisto;
import Model.OrdineProdotto;
import Model.OrdineServizio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaAcquistoDAO implements IListaAcquistoDAO {
    private static final ListaAcquistoDAO instance = new ListaAcquistoDAO();
    private ListaAcquisto listaAcquisto;
    private static ResultSet rs;

    private ListaAcquistoDAO() {
        listaAcquisto = null;
        rs = null;
    }

    public static ListaAcquistoDAO getInstance() {
        return instance;
    }

    public ListaAcquisto findByIDUtente(int IdUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM ListaAcquisto WHERE IdUtente = " + IdUtente;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                listaAcquisto = (ListaAcquisto) ModelFactory.getFactory(ModelFactory.ModelType.LISTA_ACQUISTO).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                listaAcquisto = (ListaAcquisto) ModelFactory.getFactory(ModelFactory.ModelType.LISTA_ACQUISTO).create(rs);
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
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO ListaAcquisto (IdUtente, CostoTotale, isPagata) VALUES (" + listaAcquisto.getIdUtente() + ", " + listaAcquisto.getCostoTot() + ", " + listaAcquisto.isPagata() + ")";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByIDUtente(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ListaAcquisto WHERE IdUtente = " + idUtente;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idListaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM ListaAcquisto WHERE IdListaAcquisto = " + idListaAcquisto;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(ListaAcquisto listaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE ListaAcquisto SET CostoTotale = " + listaAcquisto.getCostoTot() + ", isPagata = " + listaAcquisto.isPagata() + " WHERE IdListaAcquisto = " + listaAcquisto.getIdListaAcquisto();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int updateCostoTot(ListaAcquisto listaAcquisto, int costoTot) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE ListaAcquisto SET CostoTotale = " + costoTot + " WHERE IdListaAcquisto = " + listaAcquisto.getIdListaAcquisto();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int updateCostoTot(ListaAcquisto listaAcquisto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        IOrdineProdottoDAO ordineDAO = OrdineProdottoDAO.getInstance();
        IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        IServizioDAO servizioDAO = ServizioDAO.getInstance();

        float tot = 0;
        for (OrdineProdotto o : ordineDAO.findByListaAcquisto(listaAcquisto.getIdListaAcquisto())) {
            tot += o.getQuantita() * prodottoDAO.findByID(o.getIdProdotto()).getCosto();
        }
        for (OrdineServizio o : ordineServizioDAO.findByIDListaAcquisto(listaAcquisto.getIdListaAcquisto())) {
            tot += servizioDAO.findByID(o.getIdServizio()).getCosto();
        }

        String sql = "UPDATE ListaAcquisto SET CostoTotale = " + tot + " WHERE IdListaAcquisto = " + listaAcquisto.getIdListaAcquisto();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
