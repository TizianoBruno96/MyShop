package Business;

import Model.Articoli.Prodotto;
import Model.Posizione;

public class ConfermaInserimentoProdottoBusiness {

    private static ConfermaInserimentoProdottoBusiness istanza;
    public static synchronized  ConfermaInserimentoProdottoBusiness getInstance(){
        if (istanza == null) {
            istanza = new ConfermaInserimentoProdottoBusiness();
        }
        return istanza;
    }


   /* public ConfermaInserimentoProdottoBusiness confermaProdotto( String nomeProdotto,String descrizione,float costo,String nomeProduttore,String categoriaProdotto,int Disponibilita,int pCorsia,int pScaffale){
        Prodotto p = new Prodotto();
        Posizione pos = new Posizione();

        p.setNome(nomeProdotto);
        p.setDescrizione(descrizione);
        p.setCosto(costo);
        //


    }*/
}
