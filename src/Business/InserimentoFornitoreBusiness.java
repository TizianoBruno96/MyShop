package Business;

import DAO.FornitoreDAO;
import DAO.Interfaces.IFornitoreDAO;
import Model.Articoli.Fornitore;

public class InserimentoFornitoreBusiness {
    private static InserimentoFornitoreBusiness istanza;
    public static synchronized InserimentoFornitoreBusiness getInstance() {
        if (istanza == null) {
            istanza = new InserimentoFornitoreBusiness();
        }
        return istanza;
    }

    public InserimentoFornitoreBusiness confermaFornitore(String nome,String sito){
        IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();

        fornitoreDAO.add(new Fornitore(nome,sito));

        return null;
    }
}
