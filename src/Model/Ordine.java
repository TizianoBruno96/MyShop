package Model;

public class Ordine {
    private int idProdotto;
    private int idListaAcquisto;
    private int quantita;

    public Ordine() {
        this.idProdotto = 0;
        this.idListaAcquisto = 0;
        this.quantita = 0;
    }

    public Ordine(int idProdotto, int idListaAcquisto, int quantita) {
        this.idProdotto = idProdotto;
        this.idListaAcquisto = idListaAcquisto;
        this.quantita = quantita;
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

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String toString() {
        return "Ordine{" + "idProdotto=" + idProdotto + ", idListaAcquisto=" + idListaAcquisto + '}';
    }
}
