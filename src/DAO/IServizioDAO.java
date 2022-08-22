package DAO;

import Model.Servizio;

import java.util.ArrayList;

public interface IServizioDAO {
    Servizio findByNome(String nome);
    ArrayList<Servizio> findAll();
    int add(Servizio servizio);
    int update(Servizio servizio);
    int remove(Servizio servizio);
}
