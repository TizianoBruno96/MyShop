package Test;

import DAO.CategoriaDAO;
import DAO.ICategoriaDAO;
import Model.Categoria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoriaDAOTest {
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    @Before
    public void setUp() {
        Categoria informatica = new Categoria("Informatica");
        Categoria elettronica = new Categoria("Elettronica");
        categoriaDAO.add(informatica);
        categoriaDAO.add(elettronica);
        informatica = categoriaDAO.findByNome("Informatica");
        elettronica = categoriaDAO.findByNome("Elettronica");
        categoriaDAO.addCategoriaFiglia(new Categoria("Notebook"), informatica);
    }

    @After
    public void tearDown() {
        categoriaDAO.removeByName("Notebook");
        categoriaDAO.removeByName("Cellulare");
        categoriaDAO.removeByName("Informatica");
        categoriaDAO.removeByName("Elettronica");
        categoriaDAO.removeByName("Cucina");
    }

    @Test
    public void findByNameTest() {
        Categoria categoria = categoriaDAO.findByNome("Informatica");
        assert categoria.getNome().equals("Informatica");
    }

    @Test
    public void findAllTest() {
        categoriaDAO.add(new Categoria("Cucina"));
        for(Categoria categoria : categoriaDAO.findAll()) {
            System.out.println(categoria.getNome());
        }
        assert categoriaDAO.findAll().size() == 4;
    }

    @Test
    public void findSottoCategorie() {
        categoriaDAO.addCategoriaFiglia(new Categoria("Cellulare"), categoriaDAO.findByNome("Informatica"));
        assert categoriaDAO.findSottoCategorie(categoriaDAO.findByNome("Informatica").getIdCategoria()).size() == 2;
    }
}
