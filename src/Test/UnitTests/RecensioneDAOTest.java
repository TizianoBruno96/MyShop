package Test.UnitTests;

import DAO.*;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.Recensione;
import org.junit.Before;

public class RecensioneDAOTest {
    IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    @Before
    public void setUp() {
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

        recensioneDAO.add(new Recensione());
    }
}
