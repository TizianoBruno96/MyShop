package Model.Articoli;

public class Servizio extends Articolo {
    private int idServizio;
    private int idCategoria;
    private int idFornitore;
    private String Nome;

    public Servizio() {
        idServizio = 0;
        idCategoria = 0;
        idFornitore = 0;
        Nome = "";
        this.setCosto(0);
    }

    public Servizio(int idServizio, int idCategoria, int idFornitore, String Nome, float Costo) {
        this.idServizio = idServizio;
        this.idCategoria = idCategoria;
        this.idFornitore = idFornitore;
        this.Nome = Nome;
        this.setCosto(Costo);
    }

    public void setIdServizio(int idServizio) {
        this.idServizio = idServizio;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdServizio() {
        return idServizio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdFornitore() {
        return idFornitore;
    }

    public String getNome() {
        return Nome;
    }

    public String toString() {
        return "Servizio{" + "idServizio=" + idServizio + ", idCategoria=" + idCategoria + ", idFornitore=" + idFornitore + ", Nome=" + Nome + '}';
    }
}
