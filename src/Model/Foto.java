package Model;

public class Foto {
    private int idFoto;
    private int idProdotto;
    private byte[] Valore;
    private String Nome;



    public Foto() {
        this.idFoto = -1;
        this.idProdotto = -1;
        this.Valore = null;
        this.Nome = "";
    }

    public Foto(int idFoto, int idProdotto, byte[] Valore, String Nome) {
        this.idFoto = idFoto;
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

    public byte[] getValore() {
        return Valore;
    }

    public void setValore(byte[] Valore) {
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
