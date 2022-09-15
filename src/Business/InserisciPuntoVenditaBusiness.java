package Business;


import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;
import DAO.UtenteRegistratoDAO;
import Model.Posizione;
import Model.PuntoVendita;
import Model.Utenti.Utente;
import Model.Utenti.UtenteRegistrato;

public class InserisciPuntoVenditaBusiness {
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();
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
        PuntoVendita pv2 = puntoVenditaDAO.findByManager(IdUtenteManager);
        utenteRegistratoDAO.add(new UtenteRegistrato(IdUtenteManager,pv2.getIdPuntoVendita()));

        return null;
    }
}

