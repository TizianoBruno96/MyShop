package Test.UnitTests;

import DAO.*;
import DAO.Interfaces.*;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.ListaAcquisto;
import Model.OrdineProdotto;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class ListaAcquistoDAOTest {
    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IOrdineProdottoDAO ordineDAO = OrdineProdottoDAO.getInstance();

    @Before
    public void setUp() throws SQLException {
        utenteDAO.add(new Utente("Francesca", "Maurizi", "Frama19", "francesca1922@gmail.com", "3394287546", 19, "Via del bosco 19", "estetista", "Gomorra"), 1);

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

        ordineDAO.add(new OrdineProdotto(prodotto1.getIdProdotto(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto(), 3));
        ordineDAO.add(new OrdineProdotto(prodotto2.getIdProdotto(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto(), 2));
        ordineDAO.add(new OrdineProdotto(prodotto3.getIdProdotto(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto(), 1));
        ordineDAO.add(new OrdineProdotto(prodotto4.getIdProdotto(), listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto(), 4));
    }

    @After
    public void tearDown() throws SQLException {
        ordineDAO.removeByIDListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto());
        prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        prodottoDAO.removeByNome("Sedia Da Ufficio Bianca");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Blu");
        prodottoDAO.removeByNome("Tavolo Da Ufficio Magenta");
        produttoreDAO.removeByNome("SedieINC");
        produttoreDAO.removeByNome("TavoliINC");
        categoriaDAO.removeByName("Sedie");
        categoriaDAO.removeByName("Tavoli");
        utenteDAO.removeByUsername("Frama19");
        utenteDAO.removeByUsername("Maurotizi");
    }

    @Test
    public void findByIDUtenteTest() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        assert listaAcquisto.getIdUtente() == utenteDAO.findByUsername("Frama19").getIdUtente();
    }
    @Test
    public void findByIDUtenteTestWrong() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        assert listaAcquisto.getIdUtente() != utenteDAO.findByUsername("Frama19").getIdUtente();
    }

    @Test
    public void findByIDTest() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        ListaAcquisto listaAcquisto1 = listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto());
        assert listaAcquisto1.getIdListaAcquisto() == listaAcquisto.getIdListaAcquisto();
    }
    @Test
    public void findByIDTestWrong() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        ListaAcquisto listaAcquisto1 = listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto());
        assert listaAcquisto1.getIdListaAcquisto() != listaAcquisto.getIdListaAcquisto();
    }

    @Test
    public void removeByIDUtenteTest() {
        utenteDAO.add(new Utente("Mauro", "Maurizi", "Maurotizi", "Mauro4492@gmail.com", "3394326546", 23, "Via del bosco 19", "imprenditore", "Giorgio"), 1);
        Utente utente = utenteDAO.findByUsername("Maurotizi");
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utente.getIdUtente());
        listaAcquistoDAO.removeByID(listaAcquisto.getIdListaAcquisto());
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()) == null;
    }
    @Test
    public void removeByIDUtenteTestWrong() {
        utenteDAO.add(new Utente("Mauro", "Maurizi", "Maurotizi", "Mauro4492@gmail.com", "3394326546", 23, "Via del bosco 19", "imprenditore", "Giorgio"), 1);
        Utente utente = utenteDAO.findByUsername("Maurotizi");
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utente.getIdUtente());
        listaAcquistoDAO.removeByID(listaAcquisto.getIdListaAcquisto());
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()) != null;
    }

    @Test
    public void removeByIDTest() throws SQLException {
        utenteDAO.add(new Utente("Mauro", "Maurizi", "Maurotizi", "Mauro4492@gmail.com", "3394326546", 23, "Via del bosco 19", "imprenditore", "Giorgio"), 1);
        Utente utente = utenteDAO.findByUsername("Maurotizi");
        utenteDAO.removeByUsername("Maurotizi");
        assert listaAcquistoDAO.findByIDUtente(utente.getIdUtente()) == null;
    }
    @Test
    public void removeByIDTestWrong() throws SQLException {
        utenteDAO.add(new Utente("Mauro", "Maurizi", "Maurotizi", "Mauro4492@gmail.com", "3394326546", 23, "Via del bosco 19", "imprenditore", "Giorgio"), 1);
        Utente utente = utenteDAO.findByUsername("Maurotizi");
        utenteDAO.removeByUsername("Maurotizi");
        assert listaAcquistoDAO.findByIDUtente(utente.getIdUtente()) != null;
    }

    @Test
    public void updateTest() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        listaAcquisto.setCostoTot(100);
        listaAcquistoDAO.update(listaAcquisto);
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()).getCostoTot() >= 100;
    }
    @Test
    public void updateTestWrong() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        listaAcquisto.setCostoTot(100);
        listaAcquistoDAO.update(listaAcquisto);
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()).getCostoTot() < 100;
    }

    @Test
    public void updateCostoTotTest() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        listaAcquistoDAO.updateCostoTot(listaAcquisto);
        //System.out.println(listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()).getCostoTot());
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()).getCostoTot() == 141.4f;
    }
    @Test
    public void updateCostoTotTestWrong() {
        ListaAcquisto listaAcquisto = listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente());
        listaAcquistoDAO.updateCostoTot(listaAcquisto);
        //System.out.println(listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()).getCostoTot());
        assert listaAcquistoDAO.findByID(listaAcquisto.getIdListaAcquisto()).getCostoTot() != 141.4f;
    }
}