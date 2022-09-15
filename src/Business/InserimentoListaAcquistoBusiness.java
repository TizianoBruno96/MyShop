package Business;

import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.OrdineProdottoDAO;
import Model.OrdineProdotto;
import Views.AccessoUtente;

import java.util.ArrayList;

public class InserimentoListaAcquistoBusiness {
    private static InserimentoListaAcquistoBusiness instance;
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();

    public static synchronized InserimentoListaAcquistoBusiness getInstance() {
        if (instance == null) {
            instance = new InserimentoListaAcquistoBusiness();
        }
        return instance;
    }

    public InserimentoListaAcquistoBusiness InserisciLista(ArrayList<Integer> idProdotti, ArrayList<Integer> quantita) {
        //ciclo su ambo gli array
        for (int i = 0; i < idProdotti.size(); i++) {
            //creo un nuovo ordineProdotto
            OrdineProdotto op = new OrdineProdotto(idProdotti.get(i), AccessoUtente.getIdPuntoVendita(), quantita.get(i));
            ordineProdottoDAO.add(op);
        }
        return null;
    }
}
