package Views;

public class AccessoUtente {

    private static int idUtente;

    private static int idPuntoVendita;

    private static String tipo;

    public static int getIdUtente() {
        return idUtente;
    }

    public static void setIdUtente(int idUtente) {
        AccessoUtente.idUtente = idUtente;
    }

    public static int getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public static void setIdPuntoVendita(int idPuntoVendita) {
        AccessoUtente.idPuntoVendita = idPuntoVendita;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        AccessoUtente.tipo = tipo;
    }
}
