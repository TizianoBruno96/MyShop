package Model;

import java.util.Date;

public class Recensione {
    private int idRecensione;
    private int voto;
    private String commento;
    private int idProdotto;
    private int idUtente;
    private Date data;
    long millis = System.currentTimeMillis();


    public Recensione() {
        this.idRecensione = 0;
        this.voto = 0;
        this.commento = "";
        this.idProdotto = 0;
        this.idUtente = 0;
    }

    public Recensione(int voto, String commento, int idProdotto, int idUtente) {
        this.idRecensione = 0;
        this.voto = voto;
        this.commento = commento;
        this.idProdotto = idProdotto;
        this.idUtente = idUtente;
        this.data = new Date(millis);
    }

    public void setIdRecensione(int idRecensione) {
        this.idRecensione = idRecensione;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
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
        if(voto >= 1 && voto <= 5)
            this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String toString() {
        return "Recensione [idRecensione=" + idRecensione + ", voto=" + voto + ", commento=" + commento + ", idProdotto=" + idProdotto + "]";
    }
}
