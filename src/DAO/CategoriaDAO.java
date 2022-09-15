package DAO;

import DAO.Interfaces.ICategoriaDAO;
import DAO.ModelFactory.ModelFactory;
import DBInterface.Command.CommandFactory;
import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import Model.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO implements ICategoriaDAO {
    private static final CategoriaDAO instance = new CategoriaDAO();
    private static ResultSet rs;
    private Categoria categoria;

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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                categoria = (Categoria) ModelFactory.getFactory(ModelFactory.ModelType.CATEGORIA).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if (rs.getRow() == 1) {
                categoria = (Categoria) ModelFactory.getFactory(ModelFactory.ModelType.CATEGORIA).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while (rs.next()) {
                categoria = (Categoria) ModelFactory.getFactory(ModelFactory.ModelType.CATEGORIA).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while (rs.next()) {
                categoria = (Categoria) ModelFactory.getFactory(ModelFactory.ModelType.CATEGORIA).create(rs);
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
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while (rs.next()) {
                categoria = (Categoria) ModelFactory.getFactory(ModelFactory.ModelType.CATEGORIA).create(rs);
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
        String sql = "SELECT * FROM Categoria WHERE idCategoriaPadre = " + idCategoria;
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.READ, sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Categoria> categorie = new ArrayList<>();
        try {
            while (rs.next()) {
                categoria = (Categoria) ModelFactory.getFactory(ModelFactory.ModelType.CATEGORIA).create(rs);
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
        if (categoria.getIdCategoriaPadre() == null) {
            String sql = "INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', NULL)";
            IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
            return executor.executeOperation(operation).getAffectedRows();
        } else {
            String sql = "INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoria.getIdCategoriaPadre() + ")";
            IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
            return executor.executeOperation(operation).getAffectedRows();
        }
    }

    @Override
    public int addCategoriaFiglia(Categoria categoria, Categoria categoriaPadre) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Categoria (Nome, idCategoriaPadre) VALUES ('" + categoria.getNome() + "', " + categoriaPadre.getIdCategoria() + ")";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.WRITE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByName(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Categoria WHERE Nome = '" + nome + "'";
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.REMOVE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Categoria categoria) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Categoria SET Nome = '" + categoria.getNome() + "' WHERE idCategoria = " + categoria.getIdCategoria();
        IDBOperation operation = CommandFactory.getCommand(CommandFactory.CommandType.UPDATE, sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
