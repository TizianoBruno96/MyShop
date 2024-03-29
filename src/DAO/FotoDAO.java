package DAO;

import DAO.Interfaces.IFotoDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.CommandFactory;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import Model.Articoli.Foto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FotoDAO implements IFotoDAO {
    private static final FotoDAO instance = new FotoDAO();
    private static ResultSet rs;
    private Foto foto;

    private FotoDAO() {
        foto = null;
        rs = null;
    }

    public static FotoDAO getInstance() {
        return instance;
    }

    @Override
    public Foto findByID(int idFoto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM foto WHERE idFoto = " + idFoto;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                foto = (Foto) ModelFactory.getFactory(ModelFactory.ModelType.FOTO).create(rs);
                return foto;
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
    public Foto findByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM foto WHERE nome = '" + nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                foto = (Foto) ModelFactory.getFactory(ModelFactory.ModelType.FOTO).create(rs);
                return foto;
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
    public boolean checkNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM foto WHERE nome = '" + nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                return true;
            }
        } catch (SQLException e) {
            //handle any errors
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Foto> findByProdotto(int idProdotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Foto WHERE idProdotto = " + idProdotto;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Foto> fotoList = new ArrayList<Foto>();
        try {
            while (rs.next()) {
                foto = (Foto) ModelFactory.getFactory(ModelFactory.ModelType.FOTO).create(rs);
                fotoList.add(foto);
            }
            return fotoList;
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
    public int add(Foto foto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Foto (Nome, Valore, idProdotto) VALUES ('" + foto.getNome() + "', '" + foto.getValore() + "', '" + foto.getIdProdotto() + "')";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idFoto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Foto WHERE idFoto = " + idFoto;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByNome(String Nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Foto WHERE Nome = '" + Nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Foto foto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Foto SET Nome = '" + foto.getNome() + "' WHERE idFoto = " + foto.getIdFoto();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
