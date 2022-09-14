package Test.UnitTests;

import DAO.*;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IFotoDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.Interfaces.IProduttoreDAO;
import Model.Articoli.Foto;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Blob;
import javax.sql.rowset.serial.SerialException;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.SQLException;

public class FotoDAOTest {
    IFotoDAO fotoDAO = FotoDAO.getInstance();
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();

    @Before
    public void setUp() throws FileNotFoundException {
        categoriaDAO.add(new Categoria("Sedie"));
        Categoria sedie = categoriaDAO.findByNome("Sedie");

        produttoreDAO.add(new Produttore("SedieINC", "www.sedieinc.it", "Milano", "Italia"));
        Produttore SedieINC = produttoreDAO.findByNome("SedieINC");

        prodottoDAO.add(new Prodotto("Sedia Da Ufficio Rossa", "Sedia da ufficio", 10.5f), sedie, SedieINC);
        Prodotto prodotto = prodottoDAO.findByNome("Sedia Da Ufficio Rossa");

        File foto = new File("./Resources/Foto/lavandino.jpg");
        try {
            InputStream inputStream = new FileInputStream(foto);
            Blob blob = new SerialBlob(inputStream.readAllBytes());
            Foto foto1 = new Foto(prodotto.getIdProdotto(), blob, "Lavandino");
            fotoDAO.add(foto1);
        } catch (FileNotFoundException e) {
            System.out.println("Foto non trovata");
        } catch (SerialException e) {
            System.out.println("Errore nella serializzazione");
        } catch (SQLException e) {
            System.out.println("Errore nel database");
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }
    }

    @After
    public void tearDown() {
        if (fotoDAO.findByNome("Hello") != null)
            fotoDAO.removeByNome("Hello");
        if (fotoDAO.findByNome("Sedia") != null)
            fotoDAO.removeByNome("Sedia");
        if (fotoDAO.findByNome("Lavandino") != null)
            fotoDAO.removeByNome("Lavandino");

        if (fotoDAO.findByNome("Ciccio") != null)
            fotoDAO.removeByNome("Ciccio");
        if (prodottoDAO.findByNome("Sedia Da Ufficio Rossa") != null)
            prodottoDAO.removeByNome("Sedia Da Ufficio Rossa");
        if (categoriaDAO.findByNome("Sedie") != null)
            categoriaDAO.removeByName("Sedie");
        if (produttoreDAO.findByNome("SedieINC") != null)
            produttoreDAO.removeByNome("SedieINC");
    }

    @Test
    public void addTest() {
        File foto = new File("./Resources/Foto/Sedia.jpg");
        System.out.println(foto.getAbsolutePath());
        try {
            InputStream inputStream = new FileInputStream(foto);
            java.sql.Blob blob = new javax.sql.rowset.serial.SerialBlob(inputStream.readAllBytes());
            Foto foto2 = new Foto(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), blob, "Sedia");
            fotoDAO.add(foto2);
        } catch (FileNotFoundException e) {
            System.out.println("Foto non trovata");
        } catch (SerialException e) {
            System.out.println("Errore nella serializzazione");
        } catch (SQLException e) {
            System.out.println("Errore nel database");
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }
        assert fotoDAO.findByNome("Sedia") != null;
    }

    @Test
    public void addTestWrong() {
        File foto = new File("./Resources/Foto/Sedia.jpg");
        System.out.println(foto.getAbsolutePath());
        try {
            InputStream inputStream = new FileInputStream(foto);
            java.sql.Blob blob = new javax.sql.rowset.serial.SerialBlob(inputStream.readAllBytes());
            Foto foto2 = new Foto(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto(), blob, "Sedia");
            fotoDAO.add(foto2);
        } catch (FileNotFoundException e) {
            System.out.println("Foto non trovata");
        } catch (SerialException e) {
            System.out.println("Errore nella serializzazione");
        } catch (SQLException e) {
            System.out.println("Errore nel database");
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }
        assert fotoDAO.findByNome("Sedia") == null;
    }

    @Test
    public void removeByNomeTest() {
        fotoDAO.removeByNome("Lavandino");
        assert fotoDAO.findByNome("Lavandino") == null;
    }

    @Test
    public void removeByNomeTestWrong() {
        fotoDAO.removeByNome("Lavandino");
        assert fotoDAO.findByNome("Lavandino") != null;
    }

    @Test
    public void removeByIdTest() {
        fotoDAO.removeByID(fotoDAO.findByNome("Lavandino").getIdFoto());
        assert fotoDAO.findByNome("Lavandino") == null;
    }

    @Test
    public void removeByIdTestWrong() {
        fotoDAO.removeByID(fotoDAO.findByNome("Lavandino").getIdFoto());
        assert fotoDAO.findByNome("Lavandino") != null;
    }

    @Test
    public void findByNomeTest() {
        assert fotoDAO.findByNome("Lavandino") != null;
    }

    @Test
    public void findByNomeTestWrong() {
        assert fotoDAO.findByNome("Lavandino") == null;
    }

    @Test
    public void findByIDTest() {
        assert fotoDAO.findByID(fotoDAO.findByNome("Lavandino").getIdFoto()) != null;
    }

    @Test
    public void findByIDTestWrong() {
        assert fotoDAO.findByID(fotoDAO.findByNome("Lavandino").getIdFoto()) == null;
    }

    @Test
    public void updateTest() {
        Foto foto = fotoDAO.findByNome("Lavandino");
        foto.setNome("Hello");
        fotoDAO.update(foto);
        assert fotoDAO.findByNome("Hello") != null;
    }

    @Test
    public void updateTestWrong() {
        Foto foto = fotoDAO.findByNome("Lavandino");
        foto.setNome("Hello");
        fotoDAO.update(foto);
        assert fotoDAO.findByNome("Hello") == null;
    }

    @Test
    public void findByProdottoTest() {
        assert fotoDAO.findByProdotto(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto()).size() >= 2;
    }

    @Test
    public void findByProdottoTestWrong() {
        assert fotoDAO.findByProdotto(prodottoDAO.findByNome("Sedia Da Ufficio Rossa").getIdProdotto()).size() < 2;
    }

    @Test
    public void checkNomeTest() {
        assert fotoDAO.checkNome("Lavandino");
    }

    @Test
    public void checkNomeTestWrong() {
        assert !fotoDAO.checkNome("Lavandino");
    }
}
