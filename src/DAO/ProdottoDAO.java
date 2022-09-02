package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.ModelFactory.ProdottoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO implements IProdottoDAO {
    private static final ProdottoDAO instance = new ProdottoDAO();
    private Prodotto prodotto;
    private static IDBConnection connection;
    private static ResultSet rs;

    private ProdottoDAO() {
        prodotto = null;
        connection = null;
        rs = null;
    }

    public static ProdottoDAO getInstance() {
        return instance;
    }

    @Override
    public Prodotto findByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Prodotto WHERE Nome = '" + nome + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                prodotto = new ProdottoFactory().create(rs);
                return prodotto;
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
    public ArrayList<Prodotto> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Prodotto";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try {
            while (rs.next()) {
                prodotto = new ProdottoFactory().create(rs);
                prodotti.add(prodotto);
            }
            return prodotti;
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
    public ArrayList<Prodotto> findByCategoria(int idCategoria) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Prodotto WHERE IdCategoria = " + idCategoria;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try {
            while (rs.next()) {
                prodotto = new ProdottoFactory().create(rs);
                prodotti.add(prodotto);
            }
            return prodotti;
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
    public ArrayList<Prodotto> findByProduttore(int idProduttore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Prodotto WHERE IdProduttore = " + idProduttore;
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try {
            while (rs.next()) {
                prodotto = new ProdottoFactory().create(rs);
                prodotti.add(prodotto);
            }
            return prodotti;
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
    public int add(Prodotto prodotto, String nomeCategoria, String nomeProduttore) {
        connection = DBConnection.getInstance();
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();

        Categoria categoria = categoriaDAO.findByNome(nomeCategoria);
        Produttore produttore = produttoreDAO.findByNome(nomeProduttore);

        String sqlStatement = "INSERT INTO Prodotto (Nome, Descrizione, Costo, IdCategoria, IdProduttore) VALUES ('" + prodotto.getNome() + "', '" + prodotto.getDescrizione() + "', " + prodotto.getCosto() + ", " + categoria.getIdCategoria() + ", " + produttore.getIdProduttore() + ")";
        System.out.println(sqlStatement);
        int rowCount = connection.executeUpdate(sqlStatement);
        return rowCount;
    }

    @Override
    public int addFiglio(Prodotto prodotto, String nomeCategoria, String nomeProduttore, String nomeProdottoPadre) {
        connection = DBConnection.getInstance();
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();

        Categoria categoria = categoriaDAO.findByNome(nomeCategoria);
        Produttore produttore = produttoreDAO.findByNome(nomeProduttore);
        Prodotto prodottoPadre = prodottoDAO.findByNome(nomeProdottoPadre);
        int rowCount = connection.executeUpdate("INSERT INTO Prodotto (Nome, Descrizione, Costo, IdCategoria, IdProduttore, IdProdottoPadre) VALUES ('" + prodotto.getNome() + "', '" + prodotto.getDescrizione() + "', " + prodotto.getCosto() + ", " + categoria.getIdCategoria() + ", " + produttore.getIdProduttore() + ", " + prodottoPadre.getIdProdotto() + ")");
        return rowCount;
    }

    @Override
    public int removeByID(int idProdotto) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("DELETE FROM Prodotto WHERE idProdotto = " + idProdotto);
        return id;
    }

    @Override
    public int update(Prodotto prodotto) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("UPDATE Prodotto SET Nome = '" + prodotto.getNome() + "', Descrizione = '" + prodotto.getDescrizione() + "', Costo = " + prodotto.getCosto() + ", IdCategoria = " + prodotto.getIdCategoria() + ", IdProduttore = " + prodotto.getIdProduttore() + " WHERE idProdotto = " + prodotto.getIdProdotto());
        return id;
    }

    @Override
    public int removeByNome(String nome) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("DELETE FROM Prodotto WHERE Nome = '" + nome + "'");
        return id;
    }
}
