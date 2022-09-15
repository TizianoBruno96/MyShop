package Business.AbstractFactory;

import Model.Articoli.Prodotto;
import Model.CategoriaProdotto;

public class ProdottoFactory implements AbstractFactory {
    @Override
    public IArticolo crea() {
        return new Prodotto();
    }

    @Override
    public ICategoria creaCategoria() {
        return new CategoriaProdotto();
    }
}
