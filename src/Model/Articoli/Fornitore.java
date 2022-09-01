package Model.Articoli;

public class Fornitore {
    private int idFornitore;
    private String Nome;
    private String Sito;

    public Fornitore() {
        this.idFornitore = 0;
        this.Nome = "";
        this.Sito = "";
    }

    public Fornitore(int idFornitore, String Nome, String Sito) {
        this.idFornitore = idFornitore;
        this.Nome = Nome;
        this.Sito = Sito;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNome() {
        return Nome;
    }

    public int getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }

    public String getSito() {
        return Sito;
    }

    public void setSito(String sito) {
        Sito = sito;
    }

    public String toString() {
        return Nome;
    }
}
