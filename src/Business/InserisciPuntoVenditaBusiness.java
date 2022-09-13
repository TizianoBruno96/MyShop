package Business;

import DAO.IPuntoVenditaDAO;
import DAO.IUtenteDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;
import Model.PuntoVendita;
import Model.Utenti.Utente;

public class InserisciPuntoVenditaBusiness {
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    private static InserisciPuntoVenditaBusiness istanza;
    public static synchronized InserisciPuntoVenditaBusiness getInstance(){
        if (istanza == null) {
            istanza = new InserisciPuntoVenditaBusiness();
        }
        return istanza;
    }
    public InserisciPuntoVenditaBusiness InserisciPuntoVendita(String Citta, String Nome, String Indirizzo,int IdUtenteManager){
        PuntoVendita pv = new PuntoVendita();
        pv.setCitta(Citta);
        pv.setNome(Nome);
        pv.setIndirizzo(Indirizzo);
        pv.setIdUtenteManager(IdUtenteManager);

        puntoVenditaDAO.add(pv,IdUtenteManager);

        return null;
    }
}

