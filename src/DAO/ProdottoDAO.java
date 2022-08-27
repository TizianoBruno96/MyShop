package DAO;

import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.Prodotto;
import ModelFactory.ProdottoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDAO implements IProdottoDAO {
    private static ProdottoDAO instance = new ProdottoDAO();
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
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE Nome = '" + nome + "'");
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
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto");
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
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE idPosizione = " + idPosizione);
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
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE idCategoria = " + idCategoria);
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
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE idProduttore = " + idProduttore);
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
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE idListaAcquisto = " + idLista);
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

    public ArrayList<Prodotto> findByProdottoPadre(int idProdottoPadre) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE idProdottoPadre = " + idProdottoPadre);
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
    public ArrayList<Prodotto> findByProdottoPadre(String nomeProdottoPadre) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE nomeProdottoPadre = '" + nomeProdottoPadre + "'");
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
    public ArrayList<Prodotto> findSottoProdotti(int idProdotto) {
        connection = DBConnection.getInstance();
        rs = connection.executeQuery("SELECT * FROM Prodotto WHERE idProdottoPadre = " + idProdotto);
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
