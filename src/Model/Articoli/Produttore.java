package Model.Articoli;

public class Produttore {
    private int idProduttore;
    private String Nome;
    private String SitoWeb;
    private String Citta;
    private String Nazione;

    public void setIdProduttore(int idProduttore) {
        this.idProduttore = idProduttore;
    }

    public Produttore() {
        this.idProduttore = -1;
        this.Nome = "";
        this.SitoWeb = "";
        this.Citta = "";
        this.Nazione = "";
    }

    public Produttore(int idProduttore, String nome, String sitoWeb, String citta, String nazione) {
        this.idProduttore = idProduttore;
        this.Nome = nome;
        this.SitoWeb = sitoWeb;
        this.Citta = citta;
        this.Nazione = nazione;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setSitoWeb(String sitoWeb) {
        SitoWeb = sitoWeb;
    }

    public void setCitta(String citta) {
        Citta = citta;
    }

    public void setNazione(String nazione) {
        Nazione = nazione;
    }

    public int getIdProduttore() {
        return idProduttore;
    }

    public String getNome() {
        return Nome;
    }

    public String getSitoWeb() {
        return SitoWeb;
    }

    public String getCitta() {
        return Citta;
    }

    public String getNazione() {
        return Nazione;
    }

    public String toString() {
        return "Nome: " + Nome + "\nSito Web: " + SitoWeb + "\nCitta: " + Citta + "\nNazione: " + Nazione;
    }
}
