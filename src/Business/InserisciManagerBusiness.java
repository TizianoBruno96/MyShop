package Business;


import DAO.Interfaces.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;

public class InserisciManagerBusiness {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    private static InserisciManagerBusiness istanza;
    public static synchronized InserisciManagerBusiness getInstance(){
        if (istanza == null) {
            istanza = new InserisciManagerBusiness();
        }
        return istanza;
    }
    public InserisciManagerBusiness InserisciManager(String Nome, String Cognome, String Username, String Email, String Telefono, int Eta, String Residenza, String Professione, String Password){
        Utente u = new Utente();
        u.setNome(Nome);
        u.setCognome(Cognome);
        u.setUsername(Username);
        u.setEmail(Email);
        u.setTelefono(Telefono);
        u.setEta(Eta);
        u.setResidenza(Residenza);
        u.setProfessione(Professione);
        u.setPassword(Password);
        u.setTipo("MN");

        utenteDAO.add(u);

        return null;
    }
}
