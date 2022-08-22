package Model;

public class Posizione {
    private int idPosizione;
    private int pCorsia;
    private int pScaffale;
    private int Quantita;
    private int idProdotto;
    private int idMagazzino;

    public Posizione() {
        this.idPosizione = -1;
        this.pCorsia = -1;
        this.pScaffale = -1;
        this.Quantita = -1;
        this.idProdotto = -1;
        this.idMagazzino = -1;
    }

    public Posizione(int idPosizione, int pCorsia, int pScaffale, int Quantita, int idProdotto, int idMagazzino) {
        this.idPosizione = idPosizione;
        this.pCorsia = pCorsia;
        this.pScaffale = pScaffale;
        this.Quantita = Quantita;
        this.idProdotto = idProdotto;
        this.idMagazzino = idMagazzino;
    }

    public void setIdPosizione(int idPosizione) {
        this.idPosizione = idPosizione;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public void setIdMagazzino(int idMagazzino) {
        this.idMagazzino = idMagazzino;
    }

    public int getIdPosizione() {
        return idPosizione;
    }

    public int getpCorsia() {
        return pCorsia;
    }

    public int getpScaffale() {
        return pScaffale;
    }

    public int getQuantita() {
        return Quantita;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public int getIdMagazzino() {
        return idMagazzino;
    }

    public void setpCorsia(int pCorsia) {
        this.pCorsia = pCorsia;
    }

    public void setpScaffale(int pScaffale) {
        this.pScaffale = pScaffale;
    }

    public void setQuantita(int quantita) {
        Quantita = quantita;
    }

    public String toString() {
        return "Posizione:\n" + "Corsia: " + pCorsia + "\nScaffale: " + pScaffale + "\nQuantità: " + Quantita + "\nidProdotto: " + idProdotto;
    }
}
