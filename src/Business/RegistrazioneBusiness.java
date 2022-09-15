package Business;

import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;
import Model.PuntoVendita;
import Model.Utenti.Utente;

public class RegistrazioneBusiness {
    private static RegistrazioneBusiness istanza;
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();

    public static synchronized RegistrazioneBusiness getInstance() {
        if (istanza == null) {
            istanza = new RegistrazioneBusiness();
        }
        return istanza;
    }

    public RegistrazioneBusiness confermaRegistrazione(String nome, String cognome, String username, String email, String telefono, int eta, String residenza, String professione, String password, String nomePuntoVendita) {
        Utente utente = new Utente(nome, cognome, username, email, telefono, eta, residenza, professione, password);
        PuntoVendita p = puntoVenditaDAO.findByNome(nomePuntoVendita);

        //inserisco l'utente
        utenteDAO.add(utente, p.getIdPuntoVendita());
        return null;
    }
}
