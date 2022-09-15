package DAO.ModelFactory;

public class ModelFactory {
    public static IFactory getFactory(ModelType type) {
        return switch (type) {
            case CATEGORIA -> new CategoriaFactory();
            case FORNITORE -> new FornitoreFactory();
            case FOTO -> new FotoFactory();
            case GUEST -> new GuestFactory();
            case LISTA_ACQUISTO -> new ListaAcquistoFactory();
            case MAGAZZINO -> new MagazzinoFactory();
            case ORDINE_PRODOTTO -> new OrdineProdottoFactory();
            case ORDINE_SERVIZIO -> new OrdineServizioFactory();
            case POSIZIONE -> new PosizioneFactory();
            case PRODOTTO_COMPOSITO -> new ProdottoCompositoFactory();
            case PRODOTTO -> new ProdottoFactory();
            case PRODUTTORE -> new ProduttoreFactory();
            case PUNTO_VENDITA -> new PuntoVenditaFactory();
            case RECENSIONE -> new RecensioneFactory();
            case SERVIZIO -> new ServizioFactory();
            case UTENTE -> new UtenteFactory();
            case UTENTE_REGISTRATO -> new UtenteRegistratoFactory();
        };
    }

    public enum ModelType {
        CATEGORIA,
        FORNITORE,
        FOTO,
        GUEST,
        LISTA_ACQUISTO,
        MAGAZZINO,
        ORDINE_PRODOTTO,
        ORDINE_SERVIZIO,
        POSIZIONE,
        PRODOTTO_COMPOSITO,
        PRODOTTO,
        PRODUTTORE,
        PUNTO_VENDITA,
        RECENSIONE,
        SERVIZIO,
        UTENTE,
        UTENTE_REGISTRATO
    }
}
