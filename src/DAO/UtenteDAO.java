package DAO;

import DAO.Interfaces.IUtenteDAO;
import DAO.ModelFactory.UtenteFactory;
import DBInterface.Command.*;
import Model.ListaAcquisto;
import Model.Utenti.Utente;
import Model.Utenti.UtenteRegistrato;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO implements IUtenteDAO {
    private static final UtenteDAO instance = new UtenteDAO();
    private Utente utente;
    private static ResultSet rs;

    private UtenteDAO() {
        utente = null;
        rs = null;
    }

    public static UtenteDAO getInstance() {
        return instance;
    }

    @Override
    public Utente findByID(int idUtente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE IdUtente = " + idUtente;
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
        }
        return null;
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
            return null;
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
        }
        return false;
    }

    @Override
    public boolean checkEmail(String email) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "SELECT * FROM Utente WHERE Email = '" + email + "'";
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
        }
        return false;
    }

    @Override
    public int add(Utente utente, int idPuntoVendita) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO utente (Nome, Cognome, Username, Email, Telefono, Eta, Residenza, Professione, Password, Tipo) VALUES ('" + utente.getNome() + "', '" + utente.getCognome() + "', '" + utente.getUsername() + "', '" + utente.getEmail() + "', '" + utente.getTelefono() + "', " + utente.getEta() + ", '" + utente.getResidenza() + "', '" + utente.getProfessione() + "', '" + utente.getPassword() + "', '" + utente.getTipo() + "')";
        IDBOperation operation = new WriteOperation(sql);
        int rowCount = executor.executeOperation(operation).getAffectedRows();

        //inserisco la tabella di tipo dell'utente
        ClienteDAO clienteDAO = ClienteDAO.getInstance();
        ManagerDAO managerDAO = ManagerDAO.getInstance();
        AmministratoreDAO amministratoreDAO = AmministratoreDAO.getInstance();

        utente = this.findByUsername(utente.getUsername());
        switch (utente.getTipo()) {
            case "AM" ->
                    rowCount += amministratoreDAO.add(utente.getIdUtente());
            case "MN" ->
                    rowCount += managerDAO.add(utente.getIdUtente());
            default ->
                    rowCount += clienteDAO.add(utente.getIdUtente());

        }
        //Associo l'utente al punto vendita
        UtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();
        rowCount += utenteRegistratoDAO.add(new UtenteRegistrato(utente.getIdUtente(), idPuntoVendita));

        //creo la lista di acquisto dell'utente
        ListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
        rowCount += listaAcquistoDAO.add(new ListaAcquisto(utente.getIdUtente(), 0, false));
        return rowCount;
    }

    @Override
    public int add(Utente utente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "INSERT INTO utente (Nome, Cognome, Username, Email, Telefono, Eta, Residenza, Professione, Password, Tipo) VALUES ('" + utente.getNome() + "', '" + utente.getCognome() + "', '" + utente.getUsername() + "', '" + utente.getEmail() + "', '" + utente.getTelefono() + "', " + utente.getEta() + ", '" + utente.getResidenza() + "', '" + utente.getProfessione() + "', '" + utente.getPassword() + "', '" + utente.getTipo() + "')";
        IDBOperation operation = new WriteOperation(sql);
        int rowCount = executor.executeOperation(operation).getAffectedRows();

        Utente utente1 = this.findByUsername(utente.getUsername());

        //inserisco la tabella di tipo dell'utente
        ManagerDAO managerDAO = ManagerDAO.getInstance();
        AmministratoreDAO amministratoreDAO = AmministratoreDAO.getInstance();
        switch (utente.getTipo()) {
            case "AM" ->
                    rowCount += amministratoreDAO.add(utente1.getIdUtente());
            case "MN" ->
                    rowCount += managerDAO.add(utente1.getIdUtente());
        }
        //creo la lista di acquisto dell'utente
        ListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
        rowCount += listaAcquistoDAO.add(new ListaAcquisto(utente1.getIdUtente(), 0, false));
        return rowCount;
    }

    @Override
    public int removeByUsername(String username) {
        DBOperationExecutor executor = new DBOperationExecutor();
        Utente utente = this.findByUsername(username);
        if (utente == null) {
            return 0;
        }

        //rimuovo la lista acquisto associata all'utente
        ListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
        int rowCount = listaAcquistoDAO.removeByIDUtente(utente.getIdUtente());

        //rimuovo la tabella di tipo dell'utente
        ClienteDAO clienteDAO = ClienteDAO.getInstance();
        ManagerDAO managerDAO = ManagerDAO.getInstance();
        AmministratoreDAO amministratoreDAO = AmministratoreDAO.getInstance();
        switch (utente.getTipo()) {
            case "AM" ->
                    rowCount += amministratoreDAO.remove(utente.getIdUtente());
            case "MN" ->
                    rowCount += managerDAO.remove(utente.getIdUtente());
            default ->
                    rowCount += clienteDAO.remove(utente.getIdUtente());
        }

        //rimuovo la tabella utenteRegistrato
        UtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();
        rowCount += utenteRegistratoDAO.removeByIDUtente(utente.getIdUtente());

        //rimuovo l'utente
        String sql = "DELETE FROM utente WHERE idUtente = " + utente.getIdUtente();
        IDBOperation operation = new RemoveOperation(sql);
        rowCount += executor.executeOperation(operation).getAffectedRows();
        return rowCount;
    }

    @Override
    public int update(Utente utente) {
        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Utente SET Nome = '" + utente.getNome() + "', Cognome = '" + utente.getCognome() + "', Username = '" + utente.getUsername() + "', Email = '" + utente.getEmail() + "', Telefono = '" + utente.getTelefono() + "', Eta = " + utente.getEta() + ", Residenza = '" + utente.getResidenza() + "', Professione = '" + utente.getProfessione() + "', Password = '" + utente.getPassword() + "', Tipo = '" + utente.getTipo() + "' WHERE idUtente = '" + utente.getIdUtente() + "';";
        IDBOperation operation = new UpdateOperation(sql);
        return executor.executeOperation(operation).getAffectedRows();
    }

    public int updateTipo(String username, String tipo) {
        Utente utente = this.findByUsername(username);
        if (utente == null) {
            return 0;
        }

        DBOperationExecutor executor = new DBOperationExecutor();
        String sql = "UPDATE Utente SET Tipo = '" + tipo + "' WHERE Username = '" + username + "';";
        IDBOperation operation = new UpdateOperation(sql);
        int rowCount = executor.executeOperation(operation).getAffectedRows();

        //Aggiorno la tabella di tipo dell'utente
        ClienteDAO clienteDAO = ClienteDAO.getInstance();
        ManagerDAO managerDAO = ManagerDAO.getInstance();
        AmministratoreDAO amministratoreDAO = AmministratoreDAO.getInstance();
        switch (tipo) {
            case "AM" -> {
                amministratoreDAO.add(utente.getIdUtente());
                //Rimuovo l'utente dagli altri tipi
                managerDAO.remove(utente.getIdUtente());
                clienteDAO.remove(utente.getIdUtente());
            }
            case "MN" -> {
                managerDAO.add(utente.getIdUtente());
                //Rimuovo l'utente dagli altri tipi
                amministratoreDAO.remove(utente.getIdUtente());
                clienteDAO.remove(utente.getIdUtente());
            }
            default -> {
                clienteDAO.add(utente.getIdUtente());
                //Rimuovo l'utente dagli altri tipi
                amministratoreDAO.remove(utente.getIdUtente());
                managerDAO.remove(utente.getIdUtente());
            }
        }
        return rowCount;
    }
}