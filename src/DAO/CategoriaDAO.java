package DAO;

import DAO.Interfaces.ICategoriaDAO;
import DBInterface.Command.*;
import Model.Categoria;
import DAO.ModelFactory.CategoriaFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO implements ICategoriaDAO {
    private static final CategoriaDAO instance = new CategoriaDAO();
    private Categoria categoria;
    private static ResultSet rs;

    private CategoriaDAO() {
        categoria = null;
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
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM categoria WHERE idCategoriaPadre = " + idCategoria;
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
    public int add(Categoria categoria) {
        DBOperationExecutor executor = new DBOperationExecutor();

        int rowCount;
        if(categoria.getIdCategoriaPadre() == null) {
            String sql = "INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', NULL)";
            IDBOperation operation = new WriteOperation(sql);
            rowCount = executor.executeOperation(operation).getAffectedRows();
        } else {
            String sql = "INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoria.getIdCategoriaPadre() + ")";
            IDBOperation operation = new WriteOperation(sql);
            rowCount = executor.executeOperation(operation).getAffectedRows();
        }
        return rowCount;
    }

    @Override
    public int addCategoriaFiglia(Categoria categoria, Categoria categoriaPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoriaPadre.getIdCategoria() + ")";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByName(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Categoria WHERE Nome = '" + nome + "'";
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Categoria categoria) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Categoria SET Nome = '" + categoria.getNome() + "' WHERE idCategoria = " + categoria.getIdCategoria();
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
