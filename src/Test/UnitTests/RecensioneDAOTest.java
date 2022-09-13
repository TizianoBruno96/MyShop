package Test.UnitTests;

import DAO.*;
import DAO.Interfaces.*;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.Recensione;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class RecensioneDAOTest {
    IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();

    @Before
    public void setUp() {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra"), 1);
        Utente utente = utenteDAO.findByUsername("Frama19");

        Categoria sedie = new Categoria("Sedie");
        Produttore SedieINC = new Produttore("SedieINC", "www.sedieinc.it", "Milano", "Italia");

        //Creo le categorie
        categoriaDAO.add(sedie);

        //Creo i produttori
        produttoreDAO.add(SedieINC);

        sedie = categoriaDAO.findByNome("Sedie");
        SedieINC = produttoreDAO.findByNome("SedieINC");

        //Creo i prodotti
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Rossa", "Sedia da ufficio", 10.5f), sedie, SedieINC);
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");

        recensioneDAO.add(new Recensione(1, "Questa sedia è brutta", prodotto.getIdProdotto(), utente.getIdUtente()));
    }

    @After
    public void tearDown() throws SQLException {
        //Elimino le recensioni
        recensioneDAO.removeByProdottoAndUtente(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente());

        if (utenteDAO.findByUsername("Nikhammer") != null && prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null) {
            recensioneDAO.removeByProdottoAndUtente(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Nikhammer").getIdUtente());
        }

        //Elimino i prodotti
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        //Elimino le categorie
        categoriaDAO.removeByName("Sedie");

        //Elimino i produttori
        produttoreDAO.removeByNome("SedieINC");

        //Elimino L'utente
        utenteDAO.removeByUsername("Frama19");
        utenteDAO.removeByUsername("Nikhammer");
    }

    @Test
    public void addTest() {
        utenteDAO.add(new Utente("Nicola", "Martello", "Nikhammer", "nikyniky@yahoo.it", "3886759090", 22, "Via milano 37", "gamer", "maPerche"), 1);
        recensioneDAO.add(new Recensione(5, "Questa sedia è bellissima", prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Nikhammer").getIdUtente()));
        assert recensioneDAO.find(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Nikhammer").getIdUtente()).getCommento().equals("Questa sedia è bellissima");
    }

    @Test
    public void updateTest() {
        Recensione recensione = recensioneDAO.find(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente());
        recensione.setCommento("Questa sedia è meravigliosa");
        recensioneDAO.update(recensione);
        System.out.println(recensioneDAO.find(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente()).getCommento());
        assert recensioneDAO.find(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente()).getCommento().equals("Questa sedia è meravigliosa");
    }

    @Test
    public void removeTest() {
        recensioneDAO.removeByProdottoAndUtente(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente());
        assert recensioneDAO.find(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente()) == null;
    }

    @Test
    public void findTest() {
        assert recensioneDAO.find(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente()).getCommento().equals("Questa sedia è brutta");
    }

    @Test
    public void findByProdottoTest() {
        assert recensioneDAO.findByProdotto(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto()).size() == 1;
    }

    @Test
    public void findByIDTest() {
        Recensione recensione = recensioneDAO.find(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), utenteDAO.findByUsername("Frama19").getIdUtente());
        assert recensioneDAO.findByID(recensione.getIdRecensione()).getCommento().equals("Questa sedia è brutta");
    }

    @Test
    public void findByUtenteTest() {
        assert recensioneDAO.findByUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).size() == 1;
    }
}
