package Test;

import DAO.*;
import DAO.Interfaces.IMagazzinoDAO;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import Model.Magazzino;
import Model.PuntoVendita;
import Model.Utenti.Utente;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        IMagazzinoDAO magazzinoDAO = MagazzinoDAO.getInstance();

        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra", "MN"), 1);
        Utente utente = utenteDAO.findByUsername("Frama19");

        puntoVenditaDAO.add(new PuntoVendita("Milano", "MilanoShop", "Piazzale Loreto 27"), utente.getIdUtente());
        magazzinoDAO.add(new Magazzino(10, 15), puntoVenditaDAO.findByManager(utente.getIdUtente()).getIdPuntoVendita());

        Utente u = utenteDAO.findByUsername("TBruno");
        System.out.println(u);

        magazzinoDAO.removeByPuntoVendita(puntoVenditaDAO.findByManager(utente.getIdUtente()).getIdPuntoVendita());
        puntoVenditaDAO.removeByIDManager(utente.getIdUtente());
        utenteDAO.removeByUsername("Frama19");

    }
}
