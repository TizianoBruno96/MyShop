package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Foto;
import DAO.ModelFactory.FotoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FotoDAO implements IFotoDAO {
    private static FotoDAO instance = new FotoDAO();
    private Foto foto;
    private static IDBConnection connection;
    private static ResultSet rs;

    private FotoDAO() {
        foto = null;
        connection = null;
        rs = null;
    }

    public static FotoDAO getInstance() {
        return instance;
    }

    @Override
    public Foto findByID(int idFoto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM foto WHERE idFoto = " + idFoto;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                foto = new FotoFactory().create(rs);
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
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                foto = new FotoFactory().create(rs);
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
    public ArrayList<Foto> findByProdotto(int idProdotto) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Foto WHERE idProdotto = " + idProdotto);
        ArrayList<Foto> fotoList = new ArrayList<Foto>();
        try {
            while(rs.next()) {
                foto = new FotoFactory().create(rs);
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
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("INSERT INTO Foto (Nome, Valore, idProdotto) VALUES ('" + foto.getNome() + "', '" + foto.getValore() + "', '" + foto.getIdProdotto() + "')");
        return rowCount;
    }

    @Override
    public int removeByID(int idFoto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Foto WHERE idFoto = " + idFoto);
        return rowCount;
    }

    @Override
    public int removeByNome(String Nome) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Foto WHERE Nome = '" + Nome + "'");
        return rowCount;
    }

    @Override
    public int update(Foto foto) {
        connection = DBConnection.getInstance();
        return connection.executeUpdate("UPDATE Foto SET Nome = '" + foto.getNome() + "' WHERE idFoto = " + foto.getIdFoto());
    }
}
