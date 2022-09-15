package Business;

import DAO.Interfaces.IProduttoreDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Produttore;

public class InserimentoProduttoreBusiness {
    private static InserimentoProduttoreBusiness istanza;
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();

    public static synchronized InserimentoProduttoreBusiness getInstance() {
        if (istanza == null) {
            istanza = new InserimentoProduttoreBusiness();
        }
        return istanza;
    }

    public void InserisciProduttore(String nomeProduttore, String sito, String citta, String nazione) {
        Produttore p = new Produttore(nomeProduttore, sito, citta, nazione);
        produttoreDAO.add(p);
    }
}