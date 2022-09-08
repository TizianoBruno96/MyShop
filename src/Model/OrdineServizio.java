package Model;

public class OrdineServizio {
    private int idServizio;
    private int idListaAcquisto;

    public OrdineServizio() {
        this.idServizio = 0;
        this.idListaAcquisto = 0;
    }

    public OrdineServizio(int idServizio, int idListaAcquisto) {
        this.idServizio = idServizio;
        this.idListaAcquisto = idListaAcquisto;
    }

    public int getIdServizio() {
        return idServizio;
    }

    public void setIdServizio(int idServizio) {
        this.idServizio = idServizio;
    }

    public int getIdListaAcquisto() {
        return idListaAcquisto;
    }

    public void setIdListaAcquisto(int idListaAcquisto) {
        this.idListaAcquisto = idListaAcquisto;
    }
}
