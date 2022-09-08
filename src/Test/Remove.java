package Test;

import DAO.*;

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

        if (prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null) {
            //Elimino i prodotti
            prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        }

        if (categoriaDAO.findByNome("Sedie") != null) {
            //Elimino le categorie
            categoriaDAO.removeByName("Sedie");
        }

        if (produttoreDAO.findByNome("SedieINC") != null) {
            //Elimino i produttori
            produttoreDAO.removeByNome("SedieINC");
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
