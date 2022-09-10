package Views.Model;

public class RigaCatalogoProdotti {
    private String nomeProdotto;
    private String descrizione;
    private float costo;
    private String nomeProduttore;
    private String categoriaProdotto;

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getPrezzo() {
        return costo;
    }

    public void setPrezzo(float prezzo) {
        this.costo = prezzo;
    }

    public String getNomeProduttore() {
        return nomeProduttore;
    }

    public void setNomeProduttore(String nomeProduttore) {
        this.nomeProduttore = nomeProduttore;
    }

    public String getCategoria() {
        return categoriaProdotto;
    }

    public void setCategoria(String categoria) {
        this.categoriaProdotto = categoria;
    }

}
