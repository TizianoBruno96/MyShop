package Model;

public class ListaAcquisto {
    private int idListaAcquisto;
    private int idUtente;
    private float CostoTot;
    private boolean isPagata;

    public ListaAcquisto() {
        this.idListaAcquisto = 0;
        this.idUtente = 0;
        this.CostoTot = 0;
        this.isPagata = false;
    }

    public ListaAcquisto(int idUtente, int CostoTot, boolean isPagata) {
        this.idUtente = idUtente;
        this.CostoTot = CostoTot;
        this.isPagata = isPagata;
    }

    public void setIdListaAcquisto(int idListaAcquisto) {
        this.idListaAcquisto = idListaAcquisto;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public boolean isPagata() {
        return isPagata;
    }

    public void setPagata(boolean pagata) {
        isPagata = pagata;
    }

    public void setCostoTot(float costoTot) {
        CostoTot = costoTot;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public int getIdListaAcquisto() {
        return idListaAcquisto;
    }

    public float getCostoTot() {
        return CostoTot;
    }

    public String toString() {
        return "Costo totale: " + CostoTot;
    }
}
