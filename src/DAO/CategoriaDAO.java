package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Categoria;
import Model.ModelFactory.CategoriaFactory;

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
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM categoria WHERE nome = '" + nome + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                categoria = new CategoriaFactory().create(rs);
                return categoria;
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
    public Categoria findByID(int idCategoria) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM categoria WHERE idCategoria = '" + idCategoria + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                categoria = new CategoriaFactory().create(rs);
                return categoria;
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
    public ArrayList<Categoria> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM categoria";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while(rs.next()) {
                categoria = new CategoriaFactory().create(rs);
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
        }
        return null;
    }

    @Override
    public ArrayList<Categoria> findByCategoriaPadre(int idCategoriaPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM categoria WHERE idCategoriaPadre = " + idCategoriaPadre;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while(rs.next()) {
                categoria = new CategoriaFactory().create(rs);
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
        }
        return null;
    }

    @Override
    public ArrayList<Categoria> findByCategoriaPadre(String nomeCategoriaPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM categoria WHERE idCategoriaPadre = (SELECT idCategoria FROM categoria WHERE nome = '" + nomeCategoriaPadre + "')";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while(rs.next()) {
                categoria = new CategoriaFactory().create(rs);
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
        }
        return null;
    }

    @Override
    public ArrayList<Categoria> findSottoCategorie(int idCategoria) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Categoria WHERE idCategoriaPadre = " + idCategoria);
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while(rs.next()) {
                categoria = new CategoriaFactory().create(rs);
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
        }
        return null;
    }

    @Override
    public int add(Categoria categoria) {
        connection = DBConnection.getInstance();
        int rowCount;
        if(categoria.getIdCategoriaPadre() == null) {
            rowCount = connection.executeUpdate("INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', NULL)");
        } else {
            rowCount = connection.executeUpdate("INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoria.getIdCategoriaPadre() + ")");
        }
        return rowCount;
    }

    @Override
    public int addCategoriaFiglia(Categoria categoria, String nomeCategoriaPadre) {
        connection = DBConnection.getInstance();
        Categoria categoriaPadre = this.findByNome(nomeCategoriaPadre);
        System.out.println("INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoriaPadre.getIdCategoria() + ")");
        int rowCount = connection.executeUpdate("INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoriaPadre.getIdCategoria() + ")");
        return rowCount;
    }

    @Override
    public int removeByName(String nome) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("DELETE FROM Categoria WHERE Nome = '" + nome + "'");
        return result;
    }

    @Override
    public int update(Categoria categoria) {
        connection = DBConnection.getInstance();
        int result = connection.executeUpdate("UPDATE Categoria SET Nome = '" + categoria.getNome() + "', idCategoriaPadre = " + categoria.getIdCategoriaPadre() + " WHERE idCategoria = " + categoria.getIdCategoria());
        return result;
    }
}
