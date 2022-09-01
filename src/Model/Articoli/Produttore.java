package Model.Articoli;

public class Produttore {
    private int idProduttore;
    private String Nome;
    private String Sito;
    private String Citta;
    private String Nazione;

    public void setIdProduttore(int idProduttore) {
        this.idProduttore = idProduttore;
    }

    public Produttore() {
        this.idProduttore = -1;
        this.Nome = "";
        this.Sito = "";
        this.Citta = "";
        this.Nazione = "";
    }

    public Produttore(int idProduttore, String nome, String sito, String citta, String nazione) {
        this.idProduttore = idProduttore;
        this.Nome = nome;
        this.Sito = sito;
        this.Citta = citta;
        this.Nazione = nazione;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setSito(String sitoWeb) {
        Sito = sitoWeb;
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

    public String getSito() {
        return Sito;
    }

    public String getCitta() {
        return Citta;
    }

    public String getNazione() {
        return Nazione;
    }

    public String toString() {
        return "Nome: " + Nome + "\nSito Web: " + Sito + "\nCitta: " + Citta + "\nNazione: " + Nazione;
    }
}
