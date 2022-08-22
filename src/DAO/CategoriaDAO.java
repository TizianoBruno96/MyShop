package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Categoria;
import Model.Utente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO implements ICategoriaDAO {
    private static CategoriaDAO instance = new CategoriaDAO();
    private Categoria categoria;
    private static IDBConnection connection;
    private static ResultSet rs;

    private CategoriaDAO() {
        categoria = null;
        connection = null;
        rs = null;
    }

    public static CategoriaDAO getInstance() {
        return instance;
    }

    @Override
    public Categoria findByNome(String nome) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Categoria WHERE Nome = '" + nome + "'");
        try {
            rs.next();
            if(rs.getRow() == 1) {
                categoria = new Categoria();
                categoria.setNome(rs.getString("Nome"));
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setIdCategoriaPadre(rs.getInt("idCategoriaPadre"));
                return categoria;
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
    public ArrayList<Categoria> findAll() {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Categoria");
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while(rs.next()) {
                categoria = new Categoria();
                categoria.setNome(rs.getString("Nome"));
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setIdCategoriaPadre(rs.getInt("idCategoriaPadre"));
                categorie.add(categoria);
            }
            return categorie;
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
    public ArrayList<Categoria> findByCategoriaPadre(int idCategoriaPadre) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Categoria WHERE idCategoriaPadre = " + idCategoriaPadre);
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while(rs.next()) {
                categoria = new Categoria();
                categoria.setNome(rs.getString("Nome"));
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setIdCategoriaPadre(rs.getInt("idCategoriaPadre"));
                categorie.add(categoria);
            }
            return categorie;
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
    public int add(Categoria categoria) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoria.getIdCategoriaPadre() + ")");
        connection.close();
        return result;
    }

    @Override
    public int removeByName(String nome) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Categoria WHERE Nome = '" + nome + "'");
        connection.close();
        return result;
    }

    @Override
    public int update(Categoria categoria) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Categoria SET Nome = '" + categoria.getNome() + "', idCategoriaPadre = " + categoria.getIdCategoriaPadre() + " WHERE idCategoria = " + categoria.getIdCategoria());
        connection.close();
        return result;
    }
}
