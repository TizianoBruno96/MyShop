package Business;

import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.OrdineProdottoDAO;
import Model.OrdineProdotto;
import Views.AccessoUtente;

import java.util.ArrayList;

public class OrdineProdottoBusiness {
    private static OrdineProdottoBusiness instance;
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();

    public static synchronized OrdineProdottoBusiness getInstance() {
        if (instance == null) {
            instance = new OrdineProdottoBusiness();
        }
        return instance;
    }

    public void InserisciLista(ArrayList<Integer> idProdotti, ArrayList<Integer> quantita) {
        //ciclo su ambo gli array
        for (int i = 0; i < idProdotti.size(); i++) {
            //creo un nuovo ordineProdotto
            OrdineProdotto op = new OrdineProdotto(idProdotti.get(i), AccessoUtente.getIdPuntoVendita(), quantita.get(i));
            ordineProdottoDAO.add(op);
        }
    }
}
