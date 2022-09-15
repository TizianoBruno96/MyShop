package Model.Articoli;

public class Produttore {
    private int idProduttore;
    private String Nome;
    private String Sito;
    private String Citta;
    private String Nazione;

    public Produttore() {
        this.idProduttore = 0;
        this.Nome = "";
        this.Sito = "";
        this.Citta = "";
        this.Nazione = "";
    }

    public Produttore(String nome, String sito, String citta, String nazione) {
        this.idProduttore = 0;
        this.Nome = nome;
        this.Sito = sito;
        this.Citta = citta;
        this.Nazione = nazione;
    }

    public int getIdProduttore() {
        return idProduttore;
    }

    public void setIdProduttore(int idProduttore) {
        this.idProduttore = idProduttore;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSito() {
        return Sito;
    }

    public void setSito(String sitoWeb) {
        Sito = sitoWeb;
    }

    public String getCitta() {
        return Citta;
    }

    public void setCitta(String citta) {
        Citta = citta;
    }

    public String getNazione() {
        return Nazione;
    }

    public void setNazione(String nazione) {
        Nazione = nazione;
    }

    public String toString() {
        return idProduttore + " " + Nome + " " + Sito + " " + Citta + " " + Nazione;
    }
}
