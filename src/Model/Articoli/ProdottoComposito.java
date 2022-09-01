package Model.Articoli;

public class ProdottoComposito extends Prodotto implements IProdotto {
    private int idProdottoPadre;
    private int idProdottoFiglio;

    public ProdottoComposito() {
        idProdottoFiglio = 0;
        idProdottoPadre = 0;
    }

    public ProdottoComposito(int idProdottoPadre, int idProdottoFiglio) {
        this.idProdottoPadre = idProdottoPadre;
        this.idProdottoFiglio = idProdottoFiglio;
    }

    public int getIdProdottoPadre() {
        return idProdottoPadre;
    }

    public int getIdProdottoFiglio() {
        return idProdottoFiglio;
    }

    public void setIdProdottoPadre(int idProdottoPadre) {
        this.idProdottoPadre = idProdottoPadre;
    }

    public void setIdProdottoFiglio(int idProdottoFiglio) {
        this.idProdottoFiglio = idProdottoFiglio;
    }

    public String toString() {
        return "ProdottoComposito [idProdottoPadre=" + idProdottoPadre + ", idProdottoFiglio=" + idProdottoFiglio + "]";
    }
}
