package Model;

public class ListaAcquisto {
    private int idListaAcquisto;
    private int idUtente;
    private int CostoTot;

    public ListaAcquisto() {
        this.idListaAcquisto = -1;
        this.idUtente = -1;
        this.CostoTot = 0;
    }

    public ListaAcquisto(int idListaAcquisto, int idPuntoVendita, int CostoTot) {
        this.idListaAcquisto = idListaAcquisto;
        this.idUtente = idPuntoVendita;
        this.CostoTot = CostoTot;
    }

    public void setIdListaAcquisto(int idListaAcquisto) {
        this.idListaAcquisto = idListaAcquisto;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setCostoTot(int costoTot) {
        CostoTot = costoTot;
    }

    public int getIdUtente() {
        return idListaAcquisto;
    }


    public int getIdListaAcquisto() {
        return idListaAcquisto;
    }

    public int getCostoTot() {
        return CostoTot;
    }

    public String toString() {
        return "Costo totale: " + CostoTot;
    }
}
