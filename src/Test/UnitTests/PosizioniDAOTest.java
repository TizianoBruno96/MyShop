package Test.UnitTests;

import DAO.*;
import DAO.Interfaces.*;
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

        puntoVenditaDAO.add(new PuntoVendita("Milano", "MilanoShop", "Via 45esima fanteria"), new Magazzino(10, 10), utente.getIdUtente());
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());

        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        posizioneDAO.addPosizioniInMagazzino(magazzino);
    }

    @After
    public void tearDown() throws SQLException {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());

        posizioneDAO.removeByMagazzino(magazzino.getIdMagazzino());
        magazzinoDAO.removeByPuntoVendita(puntoVendita.getIdPuntoVendita());
        puntoVenditaDAO.removeByIDManager(utente.getIdUtente());
        utenteDAO.removeByUsername(utente.getUsername());

        if(prodottoDAO.findByNome("Profumo uomo 104") != null) {
            prodottoDAO.removeByNome("Profumo uomo 104");
        }
        if(produttoreDAO.findByNome("Gucci") != null) {
            produttoreDAO.removeByNome("Gucci");
        }
        if (categoriaDAO.findByNome("Profumi") != null) {
            categoriaDAO.removeByName("Profumi");
        }
    }

    @Test
    public void addTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        posizioneDAO.add(new Posizione(11, 11,0), magazzino.getIdMagazzino());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() == 101;
    }
    @Test
    public void addTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        posizioneDAO.add(new Posizione(11, 11,0), magazzino.getIdMagazzino());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() != 101;
    }

    @Test
    public void removeTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        posizioneDAO.removeByMagazzino(magazzino.getIdMagazzino());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() == 0;
    }
    @Test
    public void removeTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        posizioneDAO.removeByMagazzino(magazzino.getIdMagazzino());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() != 0;
    }

    @Test
    public void addProdottoInPosizioneTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 1, 1, magazzino.getIdMagazzino(), 10);
        assert posizioneDAO.find(1, 1, magazzino.getIdMagazzino()).getQuantita() == 10;
    }
    @Test
    public void addProdottoInPosizioneTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 1, 1, magazzino.getIdMagazzino(), 10);
        assert posizioneDAO.find(1, 1, magazzino.getIdMagazzino()).getQuantita() != 10;
    }

    @Test
    public void findByMagazzinoTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() == 100;
    }
    @Test
    public void findByMagazzinoTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() != 100;
    }

    @Test
    public void findByProdottoTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 1, 1, magazzino.getIdMagazzino(), 10);
        posizioneDAO.addProdottoInPosizione(prodotto, 1, 2, magazzino.getIdMagazzino(), 10);
        posizioneDAO.addProdottoInPosizione(prodotto, 2, 4, magazzino.getIdMagazzino(), 10);
        assert posizioneDAO.findByProdotto(prodotto).size() == 3;
    }
    @Test
    public void findByProdottoTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 1, 1, magazzino.getIdMagazzino(), 10);
        posizioneDAO.addProdottoInPosizione(prodotto, 1, 2, magazzino.getIdMagazzino(), 10);
        posizioneDAO.addProdottoInPosizione(prodotto, 2, 4, magazzino.getIdMagazzino(), 10);
        assert posizioneDAO.findByProdotto(prodotto).size() != 3;
    }

    @Test
    public void findTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 5, 9, magazzino.getIdMagazzino(), 10);
        assert posizioneDAO.find(5, 9, magazzino.getIdMagazzino()).getQuantita() == 10;
    }
    @Test
    public void findTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 5, 9, magazzino.getIdMagazzino(), 10);
        assert posizioneDAO.find(5, 9, magazzino.getIdMagazzino()).getQuantita() != 10;
    }

    @Test
    public void removeByMagazzinoTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        posizioneDAO.removeByMagazzino(magazzino.getIdMagazzino());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() == 0;
    }
    @Test
    public void removeByMagazzinoTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        posizioneDAO.removeByMagazzino(magazzino.getIdMagazzino());
        assert posizioneDAO.findByMagazzino(magazzino.getIdMagazzino()).size() != 0;
    }

    @Test
    public void updateQuantitaTest() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 5, 9, magazzino.getIdMagazzino(), 10);
        Posizione posizione = posizioneDAO.find(5, 9, magazzino.getIdMagazzino());
        posizioneDAO.updateQuantita(posizione, 20);
        assert posizioneDAO.find(5, 9, magazzino.getIdMagazzino()).getQuantita() == 20;
    }
    @Test
    public void updateQuantitaTestWrong() {
        Utente utente = utenteDAO.findByUsername("Frama19");
        PuntoVendita puntoVendita = puntoVenditaDAO.findByManager(utente.getIdUtente());
        Magazzino magazzino = magazzinoDAO.findByPuntoVendita(puntoVendita.getIdPuntoVendita());
        categoriaDAO.add(new Categoria("Profumi"));
        Categoria categoria = categoriaDAO.findByNome("Profumi");
        produttoreDAO.add(new Produttore("Gucci", "www.gucci.com", "Vienna", "Austria"));
        Produttore produttore = produttoreDAO.findByNome("Gucci");
        prodottoDAO.add(new Prodotto("Profumo uomo 104", "Profumo per uomini belli e forti come vorresti essere tu", 120.0f), categoria, produttore);
        Prodotto prodotto = prodottoDAO.findByNome("Profumo uomo 104");
        posizioneDAO.addProdottoInPosizione(prodotto, 5, 9, magazzino.getIdMagazzino(), 10);
        Posizione posizione = posizioneDAO.find(5, 9, magazzino.getIdMagazzino());
        posizioneDAO.updateQuantita(posizione, 20);
        assert posizioneDAO.find(5, 9, magazzino.getIdMagazzino()).getQuantita() != 20;
    }
}
