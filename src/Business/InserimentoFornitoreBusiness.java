package Business;

import DAO.FornitoreDAO;
import DAO.Interfaces.IFornitoreDAO;
import Model.Articoli.Fornitore;

public class InserimentoFornitoreBusiness {
    private static InserimentoFornitoreBusiness istanza;
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();

    public static synchronized InserimentoFornitoreBusiness getInstance() {
        if (istanza == null) {
            istanza = new InserimentoFornitoreBusiness();
        }
        return istanza;
    }

    public void InserisciFornitore(String nome, String sito) {
        Fornitore f = new Fornitore(nome, sito);
        fornitoreDAO.add(f);
    }
}
