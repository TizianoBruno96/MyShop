package Views.Model;

public class CreazionePuntoVenditaModel {
    private String Citta;
    private String Nome;
    private String Indirizzo;
    private String UsernameManager;
    private int maxCorsia;
    private int maxScaffale;


    public String getCitta() {
        return Citta;
    }

    public void setCitta(String citta) {
        Citta = citta;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        Indirizzo = indirizzo;
    }

    public String getUsernameManager() {
        return UsernameManager;
    }

    public void setUsernameManager(String usernameManager) {
        UsernameManager = usernameManager;
    }

    public int getMaxCorsia() {
        return maxCorsia;
    }

    public void setMaxCorsia(int maxCorsia) {
        this.maxCorsia = maxCorsia;
    }

    public int getMaxScaffale() {
        return maxScaffale;
    }

    public void setMaxScaffale(int maxScaffale) {
        this.maxScaffale = maxScaffale;
    }
}
