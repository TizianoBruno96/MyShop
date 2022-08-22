package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Foto;
import ModelFactory.FotoFactory;

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
    public Foto findByValore(String Valore) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Foto WHERE Valore = '" + Valore + "'");
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
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public Foto findByName(String Nome) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Foto WHERE Nome = '" + Nome + "'");
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
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public int add(Foto foto) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Foto (Nome, Valore, idProdotto) VALUES ('" + foto.getNome() + "', '" + foto.getValore() + "', '" + foto.getIdProdotto() + "')");
        return result;
    }

    @Override
    public int removeByPath(String Valore) {
        connection = DBConnection.getInstance();
        return connection.executeUpdate("DELETE FROM Foto WHERE Nome = '" + Valore + "'");
    }

    @Override
    public int update(Foto foto) {
        connection = DBConnection.getInstance();
        return connection.executeUpdate("UPDATE Foto SET Nome = '" + foto.getValore() + "' WHERE idFoto = " + foto.getIdFoto());
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
        return fotoList;
    }

    //TODO: sistemare codice per le foto (ho indicato il path ma le foto sono di tipo blob, ossia binary large object)
}
