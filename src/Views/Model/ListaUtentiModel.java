package Views.Model;

public class ListaUtentiModel {
    private int idUtente;
    private String Nome;
    private String Cognome;
    private String Username;
    private String Email;
    private String Telefono;
    private int Eta;
    private String Residenza;
    private String Professione;

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getEta() {
        return Eta;
    }

    public void setEta(int eta) {
        Eta = eta;
    }

    public String getResidenza() {
        return Residenza;
    }

    public void setResidenza(String residenza) {
        Residenza = residenza;
    }

    public String getProfessione() {
        return Professione;
    }

    public void setProfessione(String professione) {
        Professione = professione;
    }
}
