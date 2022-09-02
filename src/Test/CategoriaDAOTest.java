package Test;

import DAO.CategoriaDAO;
import DAO.ICategoriaDAO;
import Model.Categoria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoriaDAOTest {
    @Before
    public void setUp() {
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        categoriaDAO.add(new Categoria("Informatica"));
        categoriaDAO.add(new Categoria("Elettronica"));
        categoriaDAO.addCategoriaFiglia(new Categoria("Notebook"), "Informatica");
    }

    @After
    public void tearDown() {
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        categoriaDAO.removeByName("Notebook");
        categoriaDAO.removeByName("Informatica");
        categoriaDAO.removeByName("Elettronica");
    }

    @Test
    public void findByNameTest() {
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        Categoria categoria = categoriaDAO.findByNome("Informatica");
        assert categoria.getNome().equals("Informatica");
    }

    @Test
    public void findAllTest() {
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        categoriaDAO.add(new Categoria("Cucina"));
        for(Categoria categoria : categoriaDAO.findAll()) {
            System.out.println(categoria.getNome());
        }
        assert categoriaDAO.findAll().size() == 4;
        categoriaDAO.removeByName("Cucina");
    }
}
