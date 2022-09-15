package Business;


import DAO.Interfaces.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;

public class InserimentoManagerBusiness {
    private static InserimentoManagerBusiness instance;
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();

    public static synchronized InserimentoManagerBusiness getInstance() {
        if (instance == null) {
            instance = new InserimentoManagerBusiness();
        }
        return instance;
    }

    public void InserisciManager(String nome, String cognome, String username, String email, String telefono, int eta, String residenza, String professione, String password) {
        Utente u = new Utente(nome, cognome, username, email, telefono, eta, residenza, professione, password, "MN");
        utenteDAO.add(u);
    }
}
