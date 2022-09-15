package Model.Utenti;

import DBInterface.IDBConnection;

import java.sql.ResultSet;

public class Cliente {
    private static IDBConnection connection;
    private static ResultSet rs;
    int idCliente;

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente() {
        int idCliente = 0;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
