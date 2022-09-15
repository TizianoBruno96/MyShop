package Business.AbstractFactory;

import Model.Articoli.ProdottoComposito;
import Model.CategoriaProdotto;

public class ProdottoCompositoFactory implements AbstractFactory {
    @Override
    public IArticolo crea() {
        return new ProdottoComposito();
    }

    @Override
    public ICategoria creaCategoria() {
        return new CategoriaProdotto();
    }
}

