package Model;

public class Magazzino {
    private int idMagazzino;
    private int idPuntoVendita;
    private int maxCorsia;
    private int maxScaffale;

    public Magazzino() {
        this.idMagazzino = -1;
        this.idPuntoVendita = -1;
        this.maxCorsia = -1;
        this.maxScaffale = -1;
    }

    public Magazzino(int idMagazzino, int idPuntoVendita, int maxCorsia, int maxScaffale) {
        this.idMagazzino = idMagazzino;
        this.idPuntoVendita = idPuntoVendita;
        this.maxCorsia = maxCorsia;
        this.maxScaffale = maxScaffale;
    }

    public void setIdMagazzino(int idMagazzino) {
        this.idMagazzino = idMagazzino;
    }

    public void setIdPuntoVendita(int idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

    public void setMaxCorsia(int maxCorsia) {
        this.maxCorsia = maxCorsia;
    }

    public void setMaxScaffale(int maxScaffale) {
        this.maxScaffale = maxScaffale;
    }

    public int getIdMagazzino() {
        return idMagazzino;
    }

    public int getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public int getMaxCorsia() {
        return maxCorsia;
    }

    public int getMaxScaffale() {
        return maxScaffale;
    }

    public String toString() {
        return "Magazzino: " + idMagazzino + " Corsia massima: " + maxCorsia + " Scaffale massimo: " + maxScaffale;
    }
}
