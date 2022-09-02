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
    }

    @After
    public void tearDown() {
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        categoriaDAO.removeByName("Informatica");
    }

    @Test
    public void findByNameTest() {
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        Categoria categoria = categoriaDAO.findByNome("Informatica");
        assert categoria.getNome().equals("Informatica");
    }
}
