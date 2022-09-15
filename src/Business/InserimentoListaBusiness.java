package Business;

import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.OrdineProdottoDAO;
import Model.OrdineProdotto;

public class InserimentoListaBusiness {
    private static InserimentoListaBusiness istanza;
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();

    public static synchronized InserimentoListaBusiness getInstance() {
        if (istanza == null) {
            istanza = new InserimentoListaBusiness();
        }
        return istanza;
    }

    public InserimentoListaBusiness InserisciLista(int idProdotto, int idListaAcquisto, int quantita) {
        ordineProdottoDAO.add(new OrdineProdotto());

        return null;
    }
}
