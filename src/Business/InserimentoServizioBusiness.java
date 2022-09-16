package Business;

import DAO.CategoriaDAO;
import DAO.FornitoreDAO;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IFornitoreDAO;
import DAO.Interfaces.IServizioDAO;
import DAO.ServizioDAO;
import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;
import Model.Categoria;

public class InserimentoServizioBusiness {
    private static InserimentoServizioBusiness instance;
    IServizioDAO servizioDAO = ServizioDAO.getInstance();
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    public static InserimentoServizioBusiness getInstance() {
        if (instance == null) {
            instance = new InserimentoServizioBusiness();
        }
        return instance;
    }

    public void InserisciServizio(String nome, float costo, String nomeFornitore, String nomeCategoria) {
        Servizio servizio = new Servizio(nome, costo);
        Categoria categoria = categoriaDAO.findByNome(nomeCategoria);
        Fornitore fornitore = fornitoreDAO.findByNome(nomeFornitore);
        servizioDAO.add(servizio, categoria.getIdCategoria(), fornitore.getIdFornitore());
    }
}
