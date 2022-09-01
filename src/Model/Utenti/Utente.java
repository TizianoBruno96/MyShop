package Model.Utenti;

public class Utente {
    private String Name;
    private String Surname;
    private String Username;
    private String Email;
    private String Telefono;
    private int eta;
    private String Residenza;
    private String Professione;
    private String Password;
    private String Tipo;
    private int idUtente;
    private Integer idPuntoVendita;
    private Integer idListaAcquisto;

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setIdPuntoVendita(int idPuntoVendita) {
        this.idPuntoVendita = idPuntoVendita;
    }

    public void setIdListaAcquisto(int idListaAcquisto) {
        this.idListaAcquisto = idListaAcquisto;
    }

    public Utente() {
        Name = "";
        Surname = "";
        Username = "";
        Email = "";
        Telefono = "";
        eta = 0;
        Residenza = "";
        Professione = "";
        Password = "";
        Tipo = "";
        idPuntoVendita = null;
        idListaAcquisto = null;
    }

    public Utente(String Name, String Surname, String Username, String Email, String Telefono, int eta, String Residenza, String Professione, String Password, String Tipo, Integer idPuntoVendita, Integer idListaAcquisto) {
        this.Name = Name;
        this.Surname = Surname;
        this.Username = Username;
        this.Email = Email;
        this.Telefono = Telefono;
        this.eta = eta;
        this.Residenza = Residenza;
        this.Professione = Professione;
        this.Password = Password;
        this.Tipo = Tipo;
        this.idPuntoVendita = idPuntoVendita;
        this.idListaAcquisto = idListaAcquisto;
    }

    public Utente(String Name, String Surname, String Username, String Email, String Telefono, int eta, String Residenza, String Professione, String Password, String Tipo) {
        this.Name = Name;
        this.Surname = Surname;
        this.Username = Username;
        this.Email = Email;
        this.Telefono = Telefono;
        this.eta = eta;
        this.Residenza = Residenza;
        this.Professione = Professione;
        this.Password = Password;
        this.Tipo = Tipo;
        this.idUtente = 0;
        this.idPuntoVendita = 0;
        this.idListaAcquisto = 0;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public int getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public int getIdListaAcquisto() {
        return idListaAcquisto;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
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
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
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

    public String toString() {
        return "Utente{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Username='" + Username + '\'' +
                ", Email='" + Email + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", eta=" + eta +
                ", Residenza='" + Residenza + '\'' +
                ", Professione='" + Professione + '\'' +
                ", Password='" + Password + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", idUtente=" + idUtente +
                ", idPuntoVendita=" + idPuntoVendita +
                ", idListaAcquisto=" + idListaAcquisto +
                '}';
    }
}
