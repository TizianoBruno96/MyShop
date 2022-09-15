package Business;

import DAO.Interfaces.IServizioDAO;
import DAO.ServizioDAO;
import Model.Articoli.Servizio;

public class InserimentoServizioBusiness {
    private static InserimentoServizioBusiness instance;
    IServizioDAO servizioDAO = ServizioDAO.getInstance();

    public static InserimentoServizioBusiness getInstance() {
        if (instance == null) {
            instance = new InserimentoServizioBusiness();
        }
        return instance;
    }

    public void InserisciServizio(String nome, float costo, int idFornitore, int idCategoria) {
        Servizio servizio = new Servizio(nome, costo);
        servizioDAO.add(servizio, idCategoria, idFornitore);
    }
}
