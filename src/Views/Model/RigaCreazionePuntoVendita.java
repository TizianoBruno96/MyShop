package Views.Model;

public class RigaCreazionePuntoVendita {
    private String Citta;
    private String Nome;
    private String Indirizzo;
    private int idUtenteManager;

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

    public int getIdUtenteManager() {
        return idUtenteManager;
    }

    public void setIdUtenteManager(int idUtenteManager) {
        this.idUtenteManager = idUtenteManager;
    }
}
