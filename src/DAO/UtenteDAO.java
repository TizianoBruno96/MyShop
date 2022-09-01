package DAO;

import DBInterface.Command.DBOperationExecutor;
import DBInterface.Command.IDBOperation;
import DBInterface.Command.ReadOperation;
import DBInterface.DBConnection;
import DBInterface.IDBConnection;
import Model.ModelFactory.UtenteFactory;
import Model.Utenti.Utente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO implements IUtenteDAO {
    private static UtenteDAO instance = new UtenteDAO();
    private Utente utente;
    private static IDBConnection connection;
    private static ResultSet rs;

    private UtenteDAO() {
        utente = null;
        connection = null;
        rs = null;
    }

    public static UtenteDAO getInstance() {
        return instance;
    }

    @Override
    public Utente findByUsername(String username) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Username = '" + username + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                utente = new UtenteFactory().create(rs);
                return utente;
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
    public ArrayList<Utente> findAll() {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        ArrayList<Utente> utenti = new ArrayList<>();
        try {
            while(rs.next()) {
                utente = new UtenteFactory().create(rs);
                utenti.add(utente);
            }
            return utenti;
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
    public boolean isCliente(String username) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Username = '" + username + "' AND Tipo = 'CL'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                return true;
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
        return false;
    }

    @Override
    public boolean isAmministratore(String username) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Username = '" + username + "' AND Tipo = 'AM'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                return true;
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
        return false;
    }

    @Override
    public boolean isManager(String username) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Username = '" + username + "' AND Tipo = 'MN'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                return true;
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
        return false;
    }

    @Override
    public boolean checkUtente(String username, String password) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Username = '" + username + "' AND Password = '" + password + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                return true;
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
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Username = '" + username + "'";
        IDBOperation operation = new ReadOperation(sql);
        rs = executor.executeOperation(operation).getResultSet();
        try {
            rs.next();
            if(rs.getRow() == 1) {
                return true;
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
        return false;
    }

    @Override
    public int add(Utente utente) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("INSERT INTO utente (Nome, Cognome, Username, Email, Telefono, Eta, Residenza, Professione, Password, Tipo) VALUES ('" + utente.getNome() + "', '" + utente.getCognome() + "', '" + utente.getUsername() + "', '" + utente.getEmail() + "', '" + utente.getTelefono() + "', " + utente.getEta() + ", '" + utente.getResidenza() + "', '" + utente.getProfessione() + "', '" + utente.getPassword() + "', '" + utente.getTipo() + "')");
        switch (utente.getTipo()) {
            case "CL":
                rowCount += connection.executeUpdate("INSERT INTO cliente (idUtente) VALUES LAST_INSERT_ID())");
                break;
            case "AM":
                rowCount += connection.executeUpdate("INSERT INTO amministratore (idUtente) VALUES LAST_INSERT_ID())");
                break;
            case "MN":
                rowCount += connection.executeUpdate("INSERT INTO manager (idUtente) VALUES LAST_INSERT_ID())");
                break;
        }
        rowCount += connection.executeUpdate("INSERT INTO listaacquisto (idUtente) VALUES (LAST_INSERT_ID());");
        connection.close();
        return rowCount;
    }

    @Override
    public int removeByUsername(String username) throws SQLException {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("DELETE FROM ListaAcquisto WHERE idUtente = (SELECT idUtente FROM Utente WHERE Username = '" + username + "');");
        rowCount += connection.executeUpdate("DELETE FROM Cliente WHERE idUtente = (SELECT idUtente FROM Utente WHERE Username = '" + username + "');");
        rowCount += connection.executeUpdate("DELETE FROM Amministratore WHERE idUtente = (SELECT idUtente FROM Utente WHERE Username = '" + username + "');");
        rowCount += connection.executeUpdate("DELETE FROM Manager WHERE idUtente = (SELECT idUtente FROM Utente WHERE Username = '" + username + "');");
        rowCount += connection.executeUpdate("DELETE FROM Utente WHERE Username = '" + username + "';");
        connection.close();
        return rowCount;
    }

    @Override
    public int update(Utente utente) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Utente SET Nome = '" + utente.getNome() + "', Cognome = '" + utente.getCognome() + "', Username = '" + utente.getUsername() + "', Email = '" + utente.getEmail() + "', Telefono = '" + utente.getTelefono() + "', Eta = " + utente.getEta() + ", Residenza = '" + utente.getResidenza() + "', Professione = '" + utente.getProfessione() + "', Password = '" + utente.getPassword() + "', Tipo = '" + utente.getTipo() + "' WHERE Username = '" + utente.getUsername() + "';");
        connection.close();
        return rowCount;
    }

    public int updateTipo(String username, String tipo) {
        connection = DBConnection.getInstance();
        int rowCount = connection.executeUpdate("UPDATE Utente SET Tipo = '" + tipo + "' WHERE Username = '" + username + "';");
        connection.close();
        return rowCount;
    }


}