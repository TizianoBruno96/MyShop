package Business;

import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteRegistratoDAO;
import Model.PuntoVendita;
import Model.Utenti.UtenteRegistrato;

public class InserimentoPuntoVenditaBusiness {
    private static InserimentoPuntoVenditaBusiness istanza;
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();

    public static synchronized InserimentoPuntoVenditaBusiness getInstance() {
        if (istanza == null) {
            istanza = new InserimentoPuntoVenditaBusiness();
        }
        return istanza;
    }

    public static void InserisciPuntoVendita(String citta, String nome, String indirizzo, int idUtenteManager) {
        IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
        IUtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();

        //Creo e inserisco il punto vendita
        PuntoVendita pv = new PuntoVendita(citta, nome, indirizzo);
        puntoVenditaDAO.add(pv, idUtenteManager);

        //Aggiorno il manager
        pv = puntoVenditaDAO.findByManager(idUtenteManager);
        utenteRegistratoDAO.add(new UtenteRegistrato(idUtenteManager, pv.getIdPuntoVendita()));
    }
}