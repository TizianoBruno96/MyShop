package DAO;

import DAO.Interfaces.IProdottoDAO;
import DBInterface.Command.*;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import DAO.ModelFactory.ProdottoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO implements IProdottoDAO {
    private static final ProdottoDAO instance = new ProdottoDAO();
    private Prodotto prodotto;
    private static ResultSet rs;

    private ProdottoDAO() {
        prodotto = null;
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
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO Prodotto (Nome, Descrizione, Costo, IdCategoria, IdProduttore) VALUES ('" + prodotto.getNome() + "', '" + prodotto.getDescrizione() + "', " + prodotto.getCosto() + ", " + categoria.getIdCategoria() + ", " + produttore.getIdProduttore() + ")";
        IDBOperation operation = new WriteOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByID(int idProdotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Prodotto WHERE IDProdotto = " + idProdotto;
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int update(Prodotto prodotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Prodotto SET Nome = '" + prodotto.getNome() + "', Descrizione = '" + prodotto.getDescrizione() + "', Costo = " + prodotto.getCosto() + ", IdCategoria = " + prodotto.getIdCategoria() + ", IdProduttore = " + prodotto.getIdProduttore() + " WHERE idProdotto = " + prodotto.getIdProdotto();
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    public int updateCategoria(Prodotto prodotto, Categoria categoria) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Prodotto SET IdCategoria = " + categoria.getIdCategoria() + " WHERE idProdotto = " + prodotto.getIdProdotto();
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    public int updateProduttore(Prodotto prodotto, Produttore produttore) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Prodotto SET IdProduttore = " + produttore.getIdProduttore() + " WHERE IdProdotto = " + prodotto.getIdProdotto();
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int removeByNome(String nome) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Prodotto WHERE Nome = '" + nome + "'";
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    @Override
    public int remove(Prodotto prodotto) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "DELETE FROM Prodotto WHERE idProdotto = " + prodotto.getIdProdotto() + " AND Nome = '" + prodotto.getNome() + "' AND Descrizione = '" + prodotto.getDescrizione() + "' AND Costo = " + prodotto.getCosto() + " AND IdCategoria = " + prodotto.getIdCategoria() + " AND IdProduttore = " + prodotto.getIdProduttore();
        IDBOperation operation = new RemoveOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }
}
