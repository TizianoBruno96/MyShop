package Business.Strategy;

import Model.Recensione;

import java.util.List;

public class OrdinamentoCommenti {
    private final List<Recensione> commenti;
    private IOrdinamentoRecensione strategy;

    public OrdinamentoCommenti(List<Recensione> commenti) {
        this.commenti = commenti;
    }

    public void setStrategy(IOrdinamentoRecensione strategy) {
        this.strategy = strategy;
    }

    public void ordina() {
        strategy.ordina(commenti);
    }
}
