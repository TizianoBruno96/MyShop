package Business;

import DAO.Interfaces.IProduttoreDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Produttore;

public class ConfermaInserimentoProduttoriBusiness {
    private static ConfermaInserimentoProduttoriBusiness istanza;
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();

    public static synchronized ConfermaInserimentoProduttoriBusiness getInstance() {
        if (istanza == null) {
            istanza = new ConfermaInserimentoProduttoriBusiness();
        }
        return istanza;
    }

    public ConfermaInserimentoProduttoriBusiness InserisciProduttore(String nomeProduttore, String sito, String citta, String nazione) {
        Produttore p = new Produttore();
        p.setNome(nomeProduttore);
        p.setSito(sito);
        p.setCitta(citta);
        p.setNazione(nazione);

        produttoreDAO.add(p);
        return null;
    }

}
