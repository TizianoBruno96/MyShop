package Model;

public class PuntoVendita {
    private int idPuntoVendita;
    private String Citta;
    private String Nome;
    private String Indirizzo;
    private int idUtenteManager;



    public PuntoVendita() {
        this.idPuntoVendita = 0;
        this.Citta = "";
        this.Nome = "";
        this.Indirizzo = "";
        this.idUtenteManager = 0;
    }

    public PuntoVendita(String Citta, String Nome, String Indirizzo) {
        this.idPuntoVendita = 0;
        this.Citta = Citta;
        this.Nome = Nome;
        this.Indirizzo = Indirizzo;
        this.idUtenteManager = 0;
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

    public void setIdPuntoVendita(int idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

    public void setCitta(String citta) {
        Citta = citta;
    }

    public int getIdPuntoVendita() {
        return idPuntoVendita;
    }



    public String getCitta() {
        return Citta;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String toString() {
        return "PuntoVendita{" +
                "idPuntoVendita=" + idPuntoVendita +
                ", Citta='" + Citta + '\'' +
                ", Nome='" + Nome + '\'' +
                ", Indirizzo='" + Indirizzo + '\'' +
                ", idUtenteManager=" + idUtenteManager +
                '}';
    }
}
