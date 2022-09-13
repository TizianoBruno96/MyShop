package Model.Utenti;

public class Amministratore {
    int idAmministratore;

    public Amministratore(int idAmministratore) {
        this.idAmministratore = idAmministratore;
    }

    public Amministratore() {
        int idAmministratore = 0;
    }

    public int getIdAmministratore() {
        return idAmministratore;
    }

    public void setIdAmministratore(int idAmministratore) {
        this.idAmministratore = idAmministratore;
    }
}
