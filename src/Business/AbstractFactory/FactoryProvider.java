package Business.AbstractFactory;

public class FactoryProvider {
    public enum FactoryType {
        PRODOTTO,
        SERVIZIO,
        PRODOTTO_COMPOSITO
    }

    public static AbstractFactory getFactory(FactoryType type) {
        switch (type) {
            case PRODOTTO:
                return new ProdottoFactory();
            case SERVIZIO:
                return new ServizioFactory();
            case PRODOTTO_COMPOSITO:
                return new ProdottoCompositoFactory();
            default:
                return null;
        }
    }
}
