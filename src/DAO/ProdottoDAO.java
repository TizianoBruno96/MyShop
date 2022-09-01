package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Articoli.Prodotto;
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

    public ArrayList<Prodotto> findByPosizione(int idPosizione) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Prodotto WHERE IdPosizione = " + idPosizione;
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
        } finally {
            connection.close();
        }
        return null;
    }

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
        } finally {
            connection.close();
        }
        return null;
    }

    public ArrayList<Prodotto> findByLista(int idLista) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Prodotto WHERE IdLista = " + idLista;
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
    public int add(Prodotto prodotto) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("INSERT INTO Prodotto (Nome, Descrizione, Costo, idProdottoPadre, idCategoria, idListaAcquisto, idPosizione, idProduttore) VALUES ('" + prodotto.getNome() + "', '" + prodotto.getDescrizione() + "', " + prodotto.getCosto() + ", " + prodotto.getIdProdottoPadre() + ", " + prodotto.getIdCategoria() + ", " + prodotto.getIdLista() + ", " + prodotto.getIdPosizione() + ", " + prodotto.getIdProduttore() + ")");
        connection.close();
        return id;
    }

    @Override
    public int removeByID(int idProdotto) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("DELETE FROM Prodotto WHERE idProdotto = " + idProdotto);
        connection.close();
        return id;
    }

    @Override
    public int update(Prodotto prodotto) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("UPDATE Prodotto SET Nome = '" + prodotto.getNome() + "', Descrizione = '" + prodotto.getDescrizione() + "', Costo = " + prodotto.getCosto() + ", idProdottoPadre = " + prodotto.getIdProdottoPadre() + ", idCategoria = " + prodotto.getIdCategoria() + ", idListaAcquisto = " + prodotto.getIdLista() + ", idPosizione = " + prodotto.getIdPosizione() + ", idProduttore = " + prodotto.getIdProduttore() + " WHERE idProdotto = " + prodotto.getIdProdotto());
        connection.close();
        return id;
    }

    @Override
    public int removeByNome(String nome) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("DELETE FROM Prodotto WHERE Nome = '" + nome + "'");
        connection.close();
        return id;
    }

    @Override
    public int removeByLista(int idLista) {
        connection = DBConnection.getInstance();
        int id = connection.executeUpdate("DELETE FROM Prodotto WHERE idListaAcquisto = " + idLista);
        connection.close();
        return id;
    }
}
