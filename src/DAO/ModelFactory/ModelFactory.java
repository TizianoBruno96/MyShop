package DAO.ModelFactory;

public class ModelFactory {
    public static IFactory getFactory(String type) {
        return switch (type) {
            case "CATEGORIA" -> new CategoriaFactory();
            case "FORNITORE" -> new FornitoreFactory();
            case "FOTO" -> new FotoFactory();
            case "GUEST" -> new GuestFactory();
            case "LISTA_ACQUISTO" -> new ListaAcquistoFactory();
            case "MAGAZZINO" -> new MagazzinoFactory();
            case "ORDINE_PRODOTTO" -> new OrdineProdottoFactory();
            case "ORDINE_SERVIZIO" -> new CategoriaFactory();
            case "POSIZIONE" -> new FornitoreFactory();
            case "PRODOTTO_COMPOSITO" -> new FotoFactory();
            case "PRODOTTO" -> new GuestFactory();
            case "PRODUTTORE" -> new ListaAcquistoFactory();
            case "PUNTO_VENDITA" -> new MagazzinoFactory();
            case "RECENSIONE" -> new OrdineProdottoFactory();
            case "SERVIZIO" -> new OrdineServizioFactory();
            case "UTENTE" -> new PosizioneFactory();
            case "UTENTE_REGISTRATO" -> new ProdottoCompositoFactory();
            default -> null;
        };
    }
}
