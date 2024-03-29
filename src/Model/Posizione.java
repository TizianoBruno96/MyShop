package Model;

public class Posizione {
    private int idPosizione;
    private int pCorsia;
    private int pScaffale;
    private int Quantita;
    private int idMagazzino;
    private int idProdotto;

    public Posizione() {
        this.idPosizione = 0;
        this.pCorsia = 0;
        this.pScaffale = 0;
        this.Quantita = 0;
        this.idMagazzino = 0;
        this.idProdotto = 0;
    }

    public Posizione(int pCorsia, int pScaffale, int Quantita) {
        this.idPosizione = 0;
        this.pCorsia = pCorsia;
        this.pScaffale = pScaffale;
        this.Quantita = Quantita;
        this.idMagazzino = 0;
        this.idProdotto = 0;
    }

    public int getIdPosizione() {
        return idPosizione;
    }

    public void setIdPosizione(int idPosizione) {
        this.idPosizione = idPosizione;
    }

    public int getpCorsia() {
        return pCorsia;
    }

    public void setpCorsia(int pCorsia) {
        this.pCorsia = pCorsia;
    }

    public int getpScaffale() {
        return pScaffale;
    }

    public void setpScaffale(int pScaffale) {
        this.pScaffale = pScaffale;
    }

    public int getQuantita() {
        return Quantita;
    }

    public void setQuantita(int quantita) {
        Quantita = quantita;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdMagazzino() {
        return idMagazzino;
    }

    public void setIdMagazzino(int idMagazzino) {
        this.idMagazzino = idMagazzino;
    }

    public String toString() {
        return "Posizione:\n" + "Corsia: " + pCorsia + "\nScaffale: " + pScaffale + "\nQuantità: " + Quantita + "\nidProdotto: " + idProdotto;
    }
}
