package Model.Articoli;

public class Prodotto extends Articolo implements IProdotto {
    private int idProdotto;
    private String Nome;
    private String Descrizione;
    private int idProduttore;
    private int idCategoria;

    public Prodotto() {
        this.idProdotto = 0;
        this.Nome = "";
        this.Descrizione = "";
        this.idProduttore = 0;
        this.idCategoria = 0;
        this.setCosto(0);
    }

    public Prodotto(String Nome, String Descrizione, float Costo, int idProduttore, int idCategoria) {
        this.idProdotto = 0;
        this.Nome = Nome;
        this.Descrizione = Descrizione;
        this.idProduttore = idProduttore;
        this.idCategoria = idCategoria;
        this.setCosto(Costo);
    }

    public Prodotto(String Nome, String Descrizione, float Costo) {
        this.idProdotto = 0;
        this.Nome = Nome;
        this.Descrizione = Descrizione;
        this.setCosto(Costo);
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public int getIdProduttore() {
        return idProduttore;
    }

    public void setIdProduttore(int idProduttore) {
        this.idProduttore = idProduttore;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String toString() {
        return "Prodotto{" +
                "idProdotto=" + idProdotto +
                ", Nome='" + Nome + '\'' +
                ", Descrizione='" + Descrizione + '\'' +
                ", idProduttore=" + idProduttore +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
