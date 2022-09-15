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

    public Servizio(String Nome, float Costo) {
        this.idServizio = 0;
        this.idCategoria = 0;
        this.idFornitore = 0;
        this.Nome = Nome;
        this.setCosto(Costo);
    }

    public int getIdServizio() {
        return idServizio;
    }

    public void setIdServizio(int idServizio) {
        this.idServizio = idServizio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String toString() {
        return "Servizio{" + "idServizio=" + idServizio + ", idCategoria=" + idCategoria + ", idFornitore=" + idFornitore + ", Nome=" + Nome + '}';
    }
}
