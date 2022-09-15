package Business;

import DAO.CategoriaDAO;
import DAO.Interfaces.ICategoriaDAO;
import Model.Categoria;

public class InserimentoCategoriaBusiness {
    private static InserimentoCategoriaBusiness instance;
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    public static InserimentoCategoriaBusiness getInstance() {
        if (instance == null) {
            instance = new InserimentoCategoriaBusiness();
        }
        return instance;
    }

    public void InserisciCategoria(String nome, int idCategoriaPadre) {
        Categoria categoria = new Categoria(nome, idCategoriaPadre);
        categoriaDAO.add(categoria);
    }

    public void InserisciCategoria(String nome) {
        Categoria categoria = new Categoria(nome);
        categoriaDAO.add(categoria);
    }
}
