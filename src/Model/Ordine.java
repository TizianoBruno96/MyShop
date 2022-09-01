package Model;

public class Ordine {
    private int idProdotto;
    private int idListaAcquisto;

    public Ordine() {
        this.idProdotto = 0;
        this.idListaAcquisto = 0;
    }

    public Ordine(int idProdotto, int idListaAcquisto) {
        this.idProdotto = idProdotto;
        this.idListaAcquisto = idListaAcquisto;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdListaAcquisto() {
        return idListaAcquisto;
    }

    public void setIdListaAcquisto(int idListaAcquisto) {
        this.idListaAcquisto = idListaAcquisto;
    }

    public String toString() {
        return "Ordine{" + "idProdotto=" + idProdotto + ", idListaAcquisto=" + idListaAcquisto + '}';
    }
}
