package Model;

public class Manager extends Utente {
    private double salario;

    public Manager(String Name, String Surname, String Username, String Email, String Telefono, int eta, String Residenza, String Professione, String Password, String Tipo, Integer idPuntoVendita, Integer idListaAcquisto, double salario) {
        super(Name, Surname, Username, Email, Telefono, eta, Residenza, Professione, Password, Tipo, idPuntoVendita, idListaAcquisto);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
