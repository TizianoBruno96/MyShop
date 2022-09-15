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
            case "ORDINE_SERVIZIO" -> new OrdineServizioFactory();
            case "POSIZIONE" -> new PosizioneFactory();
            case "PRODOTTO_COMPOSITO" -> new ProdottoCompositoFactory();
            case "PRODOTTO" -> new ProdottoFactory();
            case "PRODUTTORE" -> new ProduttoreFactory();
            case "PUNTO_VENDITA" -> new PuntoVenditaFactory();
            case "RECENSIONE" -> new RecensioneFactory();
            case "SERVIZIO" -> new ServizioFactory();
            case "UTENTE" -> new UtenteFactory();
            case "UTENTE_REGISTRATO" -> new UtenteRegistratoFactory();
            default -> null;
        };
    }
}
