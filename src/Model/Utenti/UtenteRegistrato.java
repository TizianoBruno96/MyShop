package Model.Utenti;

public class UtenteRegistrato {
    private int idUtente;
    private int idPuntoVendita;

    public UtenteRegistrato() {
        idUtente = 0;
        idPuntoVendita = 0;
    }

    public UtenteRegistrato(int idUtenteRegistrato, int idPuntoVendita) {
        this.idUtente = idUtenteRegistrato;
        this.idPuntoVendita = idPuntoVendita;
    }

    public void setIdUtente(int idUtenteRegistrato) {
        this.idUtente = idUtenteRegistrato;
    }

    public void setIdPuntoVendita(int idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public int getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public String toString() {
        return "UtenteRegistrato{" + "idUtenteRegistrato=" + idUtente + ", idPuntoVendita=" + idPuntoVendita + '}';
    }
}
