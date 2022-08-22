package Model;

public class Servizio {
    private int idServizio;
    private int idCategoria;
    private int idFornitore;
    private String Nome;

    public void setIdServizio(int idServizio) {
        this.idServizio = idServizio;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdFornitore(int idFornitore) {
        this.idFornitore = idFornitore;
    }

    public Servizio() {
        idServizio = -1;
        idCategoria = -1;
        idFornitore = -1;
        Nome = "";
    }

    public Servizio(int idServizio, int idCategoria, int idFornitore, String Nome) {
        this.idServizio = idServizio;
        this.idCategoria = idCategoria;
        this.idFornitore = idFornitore;
        this.Nome = Nome;
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
