package Model;

import java.util.Date;

public class Recensione {
    private int idRecensione;
    private int voto;
    private String commento;
    private int idProdotto;
    private int idUtente;
    private java.sql.Date data;

    public Recensione() {
        this.idRecensione = 0;
        this.voto = 0;
        this.commento = "";
        this.idProdotto = 0;
        this.idUtente = 0;
        data = new java.sql.Date(new Date().getTime());
    }

    public Recensione(int voto, String commento, int idProdotto, int idUtente) {
        this.idRecensione = 0;
        this.voto = voto;
        this.commento = commento;
        this.idProdotto = idProdotto;
        this.idUtente = idUtente;
        this.data = new java.sql.Date(new Date().getTime());
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
            this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public java.sql.Date getData() {
        return data;
    }

    public void setData(java.sql.Date data) {
        this.data = data;
    }
    public String toString() {
        return "Recensione [idRecensione=" + idRecensione + ", voto=" + voto + ", commento=" + commento + ", idProdotto=" + idProdotto + "]";
    }
}
