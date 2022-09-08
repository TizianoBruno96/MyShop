package Model.Articoli;

import com.mysql.cj.jdbc.Blob;

public class Foto {
    private int idFoto;
    private int idProdotto;
    private java.sql.Blob Valore;
    private String Nome;

    public Foto() {
        this.idFoto = 0;
        this.idProdotto = 0;
        this.Valore = null;
        this.Nome = "";
    }

    public Foto(int idProdotto, java.sql.Blob Valore, String Nome) {
        this.idFoto = 0;
        this.idProdotto = idProdotto;
        this.Valore = Valore;
        this.Nome = Nome;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public java.sql.Blob getValore() {
        return Valore;
    }

    public void setValore(java.sql.Blob Valore) {
        this.Valore = Valore;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String toString() {
        return "path: " + Valore;
    }
}
