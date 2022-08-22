package Model;

public class PuntoVendita {
    private int idPuntoVendita;
    private int idManager;
    private int idMagazzino;
    private String Citta;

    private String Nome;

    public void setIdPuntoVendita(int idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public void setIdMagazzino(int idMagazzino) {
        this.idMagazzino = idMagazzino;
    }

    public PuntoVendita() {
        this.idPuntoVendita = -1;
        this.idManager = -1;
        this.idMagazzino = -1;
        this.Citta = "";
        this.Nome = "";
    }

    public PuntoVendita(int idPuntoVendita, int idManager, int idMagazzino, String Citta, String Nome) {
        this.idPuntoVendita = idPuntoVendita;
        this.idManager = idManager;
        this.idMagazzino = idMagazzino;
        this.Citta = Citta;
        this.Nome = Nome;
    }

    public void setCitta(String citta) {
        Citta = citta;
    }

    public int getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public int getIdManager() {
        return idManager;
    }

    public int getIdMagazzino() {
        return idMagazzino;
    }

    public String getCitta() {
        return Citta;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String toString() {
        return "PuntoVendita{" +
                "idPuntoVendita=" + idPuntoVendita +
                ", idManager=" + idManager +
                ", idMagazzino=" + idMagazzino +
                ", Citta='" + Citta + '\'' +
                ", Nome='" + Nome + '\'' +
                '}';
    }
}
