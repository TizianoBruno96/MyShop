package Test.UnitTests;

import DAO.*;

import java.sql.SQLException;

public class Remove {
    public static void main(String[] args) throws SQLException {
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

        //Elimino le recensioni
        //recensioneDAO.removeByProdottoAndUtente(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente());
        //recensioneDAO.removeByProdottoAndUtente(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Nikhammer").getIdUtente());

        //Elimino i prodotti
        //prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        //Elimino le categorie
        //categoriaDAO.removeByName("Sedie");

        //Elimino i produttori
        //produttoreDAO.removeByNome("SedieINC");

        //Elimino L'utente
        utenteDAO.removeByUsername("Frama19");
    }
}
