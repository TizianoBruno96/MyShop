package Business;

import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;
import Model.PuntoVendita;
import Model.Utenti.Utente;

public class RegistrazioneBusiness {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    private static RegistrazioneBusiness istanza;
    public static synchronized RegistrazioneBusiness getInstance(){
        if (istanza == null) {
            istanza = new RegistrazioneBusiness();
        }
        return istanza;
    }

    public RegistrazioneBusiness confermaRegistrazione(String Nome, String Cognome, String Username, String Email, String Telefono, int Eta, String Residenza, String Professione, String Password,String nomePuntoVendita){
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
        u.setTipo("CL");
        //associo il punto vendita al cliente
        IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
        //PuntoVendita p = puntoVenditaDAO.findByNome(nomePuntoVendita);

        /*f (p == null){

        }
        utenteDAO.add(u,p.getIdPuntoVendita());
*/
        return null;
    }

}
