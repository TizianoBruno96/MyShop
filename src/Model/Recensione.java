package Model;

public class Recensione {
    private int idRecensione;
    private int voto;
    private String commento;
    private int idProdotto;
    private int idUtente;

    public void setIdRecensione(int idRecensione) {
        this.idRecensione = idRecensione;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public Recensione() {
        this.idRecensione = -1;
        this.voto = 0;
        this.commento = "";
        this.idProdotto = -1;
        this.idUtente = -1;
    }

    public Recensione(int idRecensione, int voto, String commento, int idProdotto, int idUtente) {
        this.idRecensione = idRecensione;
        this.voto = voto;
        this.commento = commento;
        this.idProdotto = idProdotto;
        this.idUtente = idUtente;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdRecensione() {
        return idRecensione;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public String toString() {
        return "Recensione [idRecensione=" + idRecensione + ", voto=" + voto + ", commento=" + commento + ", idProdotto=" + idProdotto + "]";
    }
}
