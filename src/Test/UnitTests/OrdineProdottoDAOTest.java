package Test.UnitTests;

import DAO.*;
import DAO.Interfaces.*;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.OrdineProdotto;
import Model.Utenti.Utente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class OrdineProdottoDAOTest {
    IOrdineProdottoDAO ordineDAO = OrdineProdottoDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    ListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();

    @Before
    public void setUp() {
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
    }

    @Test
    public void findByListaAcquistoTest() {
        assert ordineDAO.findByListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()).size() >= 4;
    }

    @Test
    public void findByListaAcquistoTestWrong() {
        assert ordineDAO.findByListaAcquisto(listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()).getIdListaAcquisto()).size() < 4;
    }

    @Test
    public void findByProdottoTest() {
        Prodotto prodotto1 = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto prodotto2 = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        Prodotto prodotto3 = prodottoDAO.findByNome("Tavolo Da Ufficio Blu");
        Prodotto prodotto4 = prodottoDAO.findByNome("Tavolo Da Ufficio Magenta");
        assert ordineDAO.findByProdotto(prodotto1.getIdProdotto()).size() == 1;
        assert ordineDAO.findByProdotto(prodotto2.getIdProdotto()).size() == 1;
        assert ordineDAO.findByProdotto(prodotto3.getIdProdotto()).size() == 1;
        assert ordineDAO.findByProdotto(prodotto4.getIdProdotto()).size() == 1;
    }

    @Test
    public void findByProdottoTestWrong() {
        Prodotto prodotto1 = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto prodotto2 = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        Prodotto prodotto3 = prodottoDAO.findByNome("Tavolo Da Ufficio Blu");
        Prodotto prodotto4 = prodottoDAO.findByNome("Tavolo Da Ufficio Magenta");
        assert ordineDAO.findByProdotto(prodotto1.getIdProdotto()).size() != 1;
        assert ordineDAO.findByProdotto(prodotto2.getIdProdotto()).size() != 1;
        assert ordineDAO.findByProdotto(prodotto3.getIdProdotto()).size() != 1;
        assert ordineDAO.findByProdotto(prodotto4.getIdProdotto()).size() != 1;
    }

    @Test
    public void findTest() {
        Prodotto prodotto1 = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto prodotto2 = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        Prodotto prodotto3 = prodottoDAO.findByNome("Tavolo Da Ufficio Blu");
        Prodotto prodotto4 = prodottoDAO.findByNome("Tavolo Da Ufficio Magenta");
        assert (ordineDAO.find(prodotto1, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() == 3);
        assert (ordineDAO.find(prodotto2, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() == 2);
        assert (ordineDAO.find(prodotto3, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() == 1);
        assert (ordineDAO.find(prodotto4, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() == 4);
    }

    @Test
    public void findTestWrong() {
        Prodotto prodotto1 = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        Prodotto prodotto2 = prodottoDAO.findByNome("Sedia Da Ufficio Bianca");
        Prodotto prodotto3 = prodottoDAO.findByNome("Tavolo Da Ufficio Blu");
        Prodotto prodotto4 = prodottoDAO.findByNome("Tavolo Da Ufficio Magenta");
        assert (ordineDAO.find(prodotto1, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() != 3);
        assert (ordineDAO.find(prodotto2, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() != 2);
        assert (ordineDAO.find(prodotto3, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() != 1);
        assert (ordineDAO.find(prodotto4, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() != 4);
    }

    @Test
    public void updateTest() {
        Prodotto prodotto1 = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        OrdineProdotto ordineProdotto = ordineDAO.find(prodotto1, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()));
        ordineProdotto.setQuantita(5);
        ordineDAO.update(ordineProdotto);
        assert (ordineDAO.find(prodotto1, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() == 5);
    }

    @Test
    public void updateTestWrong() {
        Prodotto prodotto1 = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");
        OrdineProdotto ordineProdotto = ordineDAO.find(prodotto1, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente()));
        ordineProdotto.setQuantita(5);
        ordineDAO.update(ordineProdotto);
        assert (ordineDAO.find(prodotto1, listaAcquistoDAO.findByIDUtente(utenteDAO.findByUsername("Frama19").getIdUtente())).getQuantita() != 5);
    }
}
