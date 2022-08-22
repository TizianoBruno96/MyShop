package Model;

public class UtenteRegistrato {
    private int idUtenteRegistrato;
    private int idPuntoVendita;

    public void setIdUtenteRegistrato(int idUtenteRegistrato) {
        this.idUtenteRegistrato = idUtenteRegistrato;
    }

    public void setIdPuntoVendita(int idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

    public UtenteRegistrato() {
        idUtenteRegistrato = -1;
        idPuntoVendita = -1;
    }

    public UtenteRegistrato(int idUtenteRegistrato, int idPuntoVendita) {
        this.idUtenteRegistrato = idUtenteRegistrato;
        this.idPuntoVendita = idPuntoVendita;
    }

    public int getIdUtenteRegistrato() {
        return idUtenteRegistrato;
    }

    public int getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public String toString() {
        return "UtenteRegistrato{" + "idUtenteRegistrato=" + idUtenteRegistrato + ", idPuntoVendita=" + idPuntoVendita + '}';
    }
}
