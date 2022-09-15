package Business.AbstractFactory;

import Model.Articoli.Servizio;
import Model.CategoriaServizio;

public class ServizioFactory implements AbstractFactory {
    @Override
    public IArticolo crea() {
        return new Servizio();
    }

    @Override
    public ICategoria creaCategoria() {
        return new CategoriaServizio();
    }
}
