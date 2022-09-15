package Business;

import DAO.Interfaces.IProdottoDAO;
import DAO.Interfaces.IProduttoreDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Produttore;
import Model.OrdineProdotto;

public class ConfermaInserimentoProduttoriBusiness {
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    private static ConfermaInserimentoProduttoriBusiness istanza;
    public static synchronized  ConfermaInserimentoProduttoriBusiness getInstance(){
        if (istanza == null) {
            istanza = new ConfermaInserimentoProduttoriBusiness();
        }
        return istanza;
    }

    public ConfermaInserimentoProduttoriBusiness InserisciProduttore(String nomeProduttore,String sito,String citta,String nazione) {
        Produttore p = new Produttore();
        p.setNome(nomeProduttore);
        p.setSito(sito);
        p.setCitta(citta);
        p.setNazione(nazione);

        produttoreDAO.add(p);
        return null;
    }

}
