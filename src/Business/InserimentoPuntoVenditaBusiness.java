package Business;

import DAO.Interfaces.IMagazzinoDAO;
import DAO.Interfaces.IPosizioneDAO;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.MagazzinoDAO;
import DAO.PosizioneDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteRegistratoDAO;
import Model.Magazzino;
import Model.PuntoVendita;
import Model.Utenti.UtenteRegistrato;

public class InserimentoPuntoVenditaBusiness {
    private static InserimentoPuntoVenditaBusiness istanza;
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();
    IMagazzinoDAO magazzinoDAO = MagazzinoDAO.getInstance();
    IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();

    public static synchronized InserimentoPuntoVenditaBusiness getInstance() {
        if (istanza == null) {
            istanza = new InserimentoPuntoVenditaBusiness();
        }
        return istanza;
    }

    public void InserisciPuntoVendita(String citta, String nome, String indirizzo, int idUtenteManager, int maxCorsia,int maxScaffale) {
        //Creo e inserisco il punto vendita
        PuntoVendita pv = new PuntoVendita(citta, nome, indirizzo);
        Magazzino m = new Magazzino(maxCorsia,maxScaffale);
        puntoVenditaDAO.add(pv,m, idUtenteManager);
        posizioneDAO.addPosizioniInMagazzino(magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(idUtenteManager).getIdPuntoVendita()));

        //Aggiorno il manager
        pv = puntoVenditaDAO.findByManager(idUtenteManager);
        utenteRegistratoDAO.add(new UtenteRegistrato(idUtenteManager, pv.getIdPuntoVendita()));
    }
}