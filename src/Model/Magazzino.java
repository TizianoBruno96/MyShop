package Model;

public class Magazzino {
    private int idMagazzino;
    private int idPuntoVendita;
    private int maxCorsia;
    private int maxScaffale;

    public Magazzino() {
        this.idMagazzino = 0;
        this.idPuntoVendita = 0;
        this.maxCorsia = 0;
        this.maxScaffale = 0;
    }

    public Magazzino(int maxCorsia, int maxScaffale) {
        this.idMagazzino = 0;
        this.idPuntoVendita = 0;
        this.maxCorsia = maxCorsia;
        this.maxScaffale = maxScaffale;
    }

    public int getIdMagazzino() {
        return idMagazzino;
    }

    public void setIdMagazzino(int idMagazzino) {
        this.idMagazzino = idMagazzino;
    }

    public int getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public void setIdPuntoVendita(int idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

    public int getMaxCorsia() {
        return maxCorsia;
    }

    public void setMaxCorsia(int maxCorsia) {
        this.maxCorsia = maxCorsia;
    }

    public int getMaxScaffale() {
        return maxScaffale;
    }

    public void setMaxScaffale(int maxScaffale) {
        this.maxScaffale = maxScaffale;
    }

    public String toString() {
        return "Magazzino: " + idMagazzino + " Corsia massima: " + maxCorsia + " Scaffale massimo: " + maxScaffale;
    }
}
