package Views.Model;

public class CatalogoServiziModel {
    private int IdServizio;
    private String nomeServizio;
    private float costo;
    private String categoriaServizio;
    private String fornitore;

    public int getIdServizio() {
        return IdServizio;
    }

    public void setIdServizio(int idServizio) {
        IdServizio = idServizio;
    }

    public String getNomeServizio() {
        return nomeServizio;
    }

    public void setNomeServizio(String nome) {
        this.nomeServizio = nome;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoriaServizio;
    }

    public void setCategoria(String categoria) {
        this.categoriaServizio = categoria;
    }

    public String getFornitore() {
        return fornitore;
    }

    public void setFornitore(String fornitore) {
        this.fornitore = fornitore;
    }

}
