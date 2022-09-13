package Test;

import DAO.*;
import DAO.Interfaces.*;

import java.sql.SQLException;

public class Remove {
    public static void main(String[] args) throws SQLException {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

        if(utenteDAO.findByUsername("Frama19") != null && prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null) {
            //Elimino le recensioni
            recensioneDAO.removeByProdottoAndUtente(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente());
        }
        if (utenteDAO.findByUsername("Nikhammer") != null && prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null) {
            recensioneDAO.removeByProdottoAndUtente(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Nikhammer").getIdUtente());
        }

        //Elimino i prodotti
        if (prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null) {
            prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        }
        if (prodottoDAO.findByNome("Sedia Da Ufficio Verde") != null) {
            prodottoDAO.removeByNome("Sedia Da Ufficio Verde");
        }
        if (prodottoDAO.findByNome("Sedia Da Ufficio Bianca") != null) {
            prodottoDAO.removeByNome("Sedia Da Ufficio Bianca");
        }
        if (prodottoDAO.findByNome("Tavolo Da Ufficio Blu") != null) {
            prodottoDAO.removeByNome("Tavolo Da Ufficio Blu");
        }
        if (prodottoDAO.findByNome("Tavolo Da Ufficio Nero") != null) {
            prodottoDAO.removeByNome("Tavolo Da Ufficio Nero");
        }

        //Elimino le categorie
        if (categoriaDAO.findByNome("Sedie") != null) {
            categoriaDAO.removeByName("Sedie");
        }
        if (categoriaDAO.findByNome("Tavoli") != null) {
            categoriaDAO.removeByName("Tavoli");
        }

        //Elimino i produttori
        if (produttoreDAO.findByNome("SedieINC") != null) {
            produttoreDAO.removeByNome("SedieINC");
        }
        if (produttoreDAO.findByNome("TavoliINC") != null) {
            produttoreDAO.removeByNome("TavoliINC");
        }

        if (utenteDAO.findByUsername("Frama19") != null) {
            //Elimino l'utente
            utenteDAO.removeByUsername("Frama19");
        }

        if (utenteDAO.findByUsername("Nikhammer") != null) {
            utenteDAO.removeByUsername("Nikhammer");
        }
    }
}
