package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Prodotto;
import Model.Articoli.ProdottoComposito;
import Model.Articoli.Produttore;
import Model.Categoria;
import DAO.ModelFactory.ProdottoFactory;

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
        }
        return null;
    }

    public Prodotto findByID(int idProdotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Prodotto WHERE IDProdotto = '" + idProdotto + "'";
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
    public int add(Prodotto prodotto, Categoria categoria, Produttore produttore) {
        connection = DBConnection.getInstance();
        String sqlStatement = "INSERT INTO Prodotto (Nome, Descrizione, Costo, IdCategoria, IdProduttore) VALUES ('" + prodotto.getNome() + "', '" + prodotto.getDescrizione() + "', " + prodotto.getCosto() + ", " + categoria.getIdCategoria() + ", " + produttore.getIdProduttore() + ")";
        int rowCount = connection.executeUpdate(sqlStatement);
        return rowCount;
    }

    @Override
    public int removeByID(int idProdotto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Prodotto WHERE IdProdotto = " + idProdotto);
        return rowCount;
    }

    @Override
    public int update(Prodotto prodotto) {
        connection = DBConnection.getInstance();
        String sqlStatement = "UPDATE Prodotto SET Nome = '" + prodotto.getNome() + "', Descrizione = '" + prodotto.getDescrizione() + "', Costo = " + prodotto.getCosto() + " WHERE IdProdotto = " + prodotto.getIdProdotto();
        int rowCount = connection.executeUpdate("UPDATE Prodotto SET Nome = '" + prodotto.getNome() + "', Descrizione = '" + prodotto.getDescrizione() + "', Costo = " + prodotto.getCosto() + ", IdCategoria = " + prodotto.getIdCategoria() + ", IdProduttore = " + prodotto.getIdProduttore() + " WHERE idProdotto = " + prodotto.getIdProdotto());
        return rowCount;
    }

    public int updateCategoria(Prodotto prodotto, Categoria categoria) {
        connection = DBConnection.getInstance();
        String sqlStatement = "UPDATE Prodotto SET IdCategoria = " + categoria.getIdCategoria() + " WHERE IdProdotto = " + prodotto.getIdProdotto();
        int rowCount = connection.executeUpdate(sqlStatement);
        return rowCount;
    }

    public int updateProduttore(Prodotto prodotto, Produttore produttore) {
        connection = DBConnection.getInstance();
        String sqlStatement = "UPDATE Prodotto SET IdProduttore = " + produttore.getIdProduttore() + " WHERE IdProdotto = " + prodotto.getIdProdotto();
        int rowCount = connection.executeUpdate(sqlStatement);
        return rowCount;
    }

    @Override
    public int removeByNome(String nome) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Prodotto WHERE Nome = '" + nome + "'");
        return rowCount;
    }

    @Override
    public int remove(Prodotto prodotto) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM Prodotto WHERE idProdotto = " + prodotto.getIdProdotto() + " AND Nome = '" + prodotto.getNome() + "' AND Descrizione = '" + prodotto.getDescrizione() + "' AND Costo = " + prodotto.getCosto() + " AND IdCategoria = " + prodotto.getIdCategoria() + " AND IdProduttore = " + prodotto.getIdProduttore());
        return rowCount;
    }
}
