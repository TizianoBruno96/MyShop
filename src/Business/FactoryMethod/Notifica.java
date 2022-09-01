package Business.FactoryMethod;

import Model.Utenti.Utente;

public abstract class Notifica {

    String message;
    private Utente destinatario;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Utente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Utente destinatario) {
        this.destinatario = destinatario;
    }

    public abstract void inviaNotifica();
}
