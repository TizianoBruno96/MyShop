package Model;

public class Prodotto extends Articolo implements IProdotto {
    private int idProdotto;
    private String Nome;
    private String Descrizione;
    private int idProdottoPadre;
    private int idProduttore;
    private int idPosizione;
    private int idCategoria;
    private int idLista;

    public Prodotto() {
        this.idProdotto = 0;
        this.Nome = "";
        this.Descrizione = "";
        this.idProdottoPadre = 0;
        this.idProduttore = 0;
        this.idPosizione = 0;
        this.idCategoria = 0;
        this.idLista = 0;
        this.setCosto(0);
    }

    public Prodotto(int idProdotto, String Nome, String Descrizione, float Costo, int idProdottoPadre, int idProduttore, int idPosizione, int idCategoria, int idLista) {
        this.idProdotto = idProdotto;
        this.Nome = Nome;
        this.Descrizione = Descrizione;
        this.idProdottoPadre = idProdottoPadre;
        this.idProduttore = idProduttore;
        this.idPosizione = idPosizione;
        this.idCategoria = idCategoria;
        this.idLista = idLista;
        this.setCosto(Costo);
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public void setIdProdottoPadre(int idProdottoPadre) {
        this.idProdottoPadre = idProdottoPadre;
    }

    public void setIdProduttore(int idProduttore) {
        this.idProduttore = idProduttore;
    }

    public void setIdPosizione(int idPosizione) {
        this.idPosizione = idPosizione;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String getNome() {
        return Nome;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public int getIdProdottoPadre() {
        return idProdottoPadre;
    }

    public int getIdProduttore() {
        return idProduttore;
    }

    public int getIdPosizione() {
        return idPosizione;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdLista() {
        return idLista;
    }

    public String toString() {
        return "Prodotto{" + "idProdotto=" + idProdotto + ", Nome=" + Nome + ", Descrizione=" + Descrizione + ", Costo=" + this.getCosto() + ", idProdottoPadre=" + idProdottoPadre + ", idProduttore=" + idProduttore + ", idPosizione=" + idPosizione + ", idCategoria=" + idCategoria + ", idLista=" + idLista + '}';
    }
}
