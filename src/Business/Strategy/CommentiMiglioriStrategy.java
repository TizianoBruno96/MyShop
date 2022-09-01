package Business.Strategy;

import Model.Recensione;

import java.util.Comparator;
import java.util.List;

public class CommentiMiglioriStrategy implements IOrdinamentoRecensione {
    @Override
    public void ordina(List<Recensione> commenti) {
        commenti.sort(new Comparator<Recensione>() {
            @Override
            public int compare(Recensione o1, Recensione o2) {
                return o1.getVoto() - o2.getVoto();
            }
        });
    }
}