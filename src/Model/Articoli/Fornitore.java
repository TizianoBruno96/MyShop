package Model.Articoli;

public class Fornitore {
    private int idFornitore;
    private String Nome;

    public Fornitore() {
        this.idFornitore = -1;
        this.Nome = "";
    }

    public Fornitore(int idFornitore, String Nome) {
        this.idFornitore = idFornitore;
        this.Nome = Nome;
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

    public String toString() {
        return Nome;
    }
}
