package Model.Utenti;

public class Utente {
    private int idUtente;
    private String Nome;
    private String Cognome;
    private String Username;
    private String Email;
    private String Telefono;
    private int Eta;
    private String Residenza;
    private String Professione;
    private String Password;
    private String Tipo;

    public Utente() {
        Nome = "";
        Cognome = "";
        Username = "";
        Email = "";
        Telefono = "";
        Eta = 0;
        Residenza = "";
        Professione = "";
        Password = "";
        Tipo = "CL";
    }

    public Utente(String Nome, String Cognome, String Username, String Email, String Telefono, int Eta, String Residenza, String Professione, String Password, String Tipo) {
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Username = Username;
        this.Email = Email;
        this.Telefono = Telefono;
        this.Eta = Eta;
        this.Residenza = Residenza;
        this.Professione = Professione;
        this.Password = Password;
        this.Tipo = Tipo;
    }

    public Utente(String Nome, String Surname, String Username, String Email, String Telefono, int Eta, String Residenza, String Professione, String Password) {
        this.Nome = Nome;
        this.Cognome = Surname;
        this.Username = Username;
        this.Email = Email;
        this.Telefono = Telefono;
        this.Eta = Eta;
        this.Residenza = Residenza;
        this.Professione = Professione;
        this.Password = Password;
        this.Tipo = "CL";
    }

    public int getIdUtente() {
        return idUtente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }
    public String getCognome() {
        return Cognome;
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

    public void setEta(int Eta) {
        this.Eta = Eta;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String toString() {
        return "Utente{" +
                "Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", Username='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Eta=" + Eta +
                ", Residenza='" + Residenza + '\'' +
                ", Professione='" + Professione + '\'' +
                ", Password='" + Password + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", idUtente=" + idUtente +
                '}';
    }
}