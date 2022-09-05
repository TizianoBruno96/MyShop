package UnitTests;

import Business.AbstractFactory.*;
import Model.*;
import Model.Articoli.Prodotto;
import Model.Articoli.ProdottoComposito;
import Model.Articoli.Servizio;
import org.junit.Assert;
import org.junit.Test;

public class AbstractFactoryTest {

    @Test
    public void testProdotto() {
        FactoryProvider.FactoryType type = FactoryProvider.FactoryType.PRODOTTO;
        AbstractFactory factory = FactoryProvider.getFactory(type);

        Assert.assertTrue(factory instanceof ProdottoFactory);

        IArticolo articolo = factory.crea();
        ICategoria categoria = factory.creaCategoria();

        Assert.assertTrue(articolo instanceof Prodotto);
        Assert.assertTrue(categoria instanceof CategoriaProdotto);
    }

    @Test
    public void testServizio() {
        FactoryProvider.FactoryType type = FactoryProvider.FactoryType.SERVIZIO;
        AbstractFactory factory = FactoryProvider.getFactory(type);

        Assert.assertTrue(factory instanceof ServizioFactory);

        IArticolo articolo = factory.crea();
        ICategoria categoria = factory.creaCategoria();

        Assert.assertTrue(articolo instanceof Servizio);
        Assert.assertTrue(categoria instanceof CategoriaServizio);
    }

    @Test
    public void testProdottoComposito() {
        FactoryProvider.FactoryType type = FactoryProvider.FactoryType.PRODOTTO_COMPOSITO;
        AbstractFactory factory = FactoryProvider.getFactory(type);

        Assert.assertTrue(factory instanceof ProdottoCompositoFactory);

        IArticolo articolo = factory.crea();
        ICategoria categoria = factory.creaCategoria();

        Assert.assertTrue(articolo instanceof ProdottoComposito);
        Assert.assertTrue(categoria instanceof CategoriaProdotto);
    }
}
