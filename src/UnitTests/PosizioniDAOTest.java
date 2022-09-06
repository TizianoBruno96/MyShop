package UnitTests;

import DAO.*;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.Magazzino;
import Model.Posizione;
import Model.PuntoVendita;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class PosizioniDAOTest {
    IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
    IMagazzinoDAO magazzinoDAO = MagazzinoDAO.getInstance();
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    @Before
    public void setUp() {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra", "MN"));
        Utente utente = utenteDAO.findByUsername("Frama19");

        Categoria sedie = new Categoria("Sedie");
        Categoria tavoli = new Categoria("Tavoli");

        Produttore SedieINC = new Produttore("SedieINC", "www.sedieinc.it", "Milano", "Italia");
        Produttore TavoliINC = new Produttore("TavoliINC", "www.tavoliinc.it", "Milano", "Italia");

        //Creo le categorie
        categoriaDAO.add(sedie);
        categoriaDAO.add(tavoli);

        //Creo i produttori
        produttoreDAO.add(SedieINC);
        produttoreDAO.add(TavoliINC);

        sedie = categoriaDAO.findByNome("Sedie");
        tavoli = categoriaDAO.findByNome("Tavoli");
        SedieINC = produttoreDAO.findByNome("SedieINC");
        TavoliINC = produttoreDAO.findByNome("TavoliINC");


        //Creo i prodotti
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Rossa", "Sedia da ufficio", 10.5f), sedie, SedieINC);
        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Bianca", "Sedia da ufficio", 12.4f), sedie, SedieINC);
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Blu", "Tavolo da ufficio", 15.5f), tavoli, TavoliINC);
        prodottoDAO.add(new Prodotto("Tavolo Da Ufficio Magenta", "Tavolo da ufficio", 17.4f), tavoli, TavoliINC);
        Prodotto prodotto1 = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto prodotto2 = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        Prodotto prodotto3 = prodottoDAO.findByNome("Tavolo Da Ufficio Blu");
        Prodotto prodotto4 = prodottoDAO.findByNome("Tavolo Da Ufficio Magenta");

        //creo il punto vendita
        puntoVenditaDAO.add(new PuntoVendita("Milano", "MilanoShop", "Piazzale Loreto 27"), new Magazzino(10, 10), utente.getIdUtente());
    }

    @After
    public void tearDown() throws SQLException {
        posizioneDAO.removeByMagazzino(
                magazzinoDAO.findByPuntoVendita(
                puntoVenditaDAO.findByManager
                (utenteDAO.findByUsername("Frama19")
                        .getIdUtente())
                        .getIdPuntoVendita())
                        .getIdMagazzino());
        magazzinoDAO.removeByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita());
        puntoVenditaDAO.removeByIDManager(utenteDAO.findByUsername("Frama19").getIdUtente());
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.removeByNome("Sedia Da Ufficio Bianca");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Blu");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Magenta");
        produttoreDAO.removeByNome("SedieINC");
        produttoreDAO.removeByNome("TavoliINC");
        categoriaDAO.removeByName("Sedie");
        categoriaDAO.removeByName("Tavoli");
        utenteDAO.removeByUsername("Frama19");
    }

    @Test
    public void addTest() {
        posizioneDAO.add(new Posizione(11, 12, 0), magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita()).getIdMagazzino());
        assert (posizioneDAO.findByMagazzino(magazzinoDAO.findByPuntoVendita(puntoVenditaDAO.findByManager(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdPuntoVendita()).getIdMagazzino()).size() == 101);
    }
}
