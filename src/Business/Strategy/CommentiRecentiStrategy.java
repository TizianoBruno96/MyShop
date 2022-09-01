package Business.Strategy;

import Model.Recensione;

import java.util.Comparator;
import java.util.List;

public class CommentiRecentiStrategy implements IOrdinamentoRecensione {
    @Override
    public void ordina(List<Recensione> commenti) {
        commenti.sort(new Comparator<Recensione>() {
            @Override
            public int compare(Recensione o1, Recensione o2) {
                if(o2 == null || o1 == null) return 0;
                return o2.getData().compareTo(o1.getData());
            }
        });
    }
}
