package DAO;

import Model.Articoli.Servizio;

import java.util.ArrayList;

public interface IServizioDAO {
    Servizio findByNome(String nome);
    ArrayList<Servizio> findAll();
    ArrayList<Servizio> findByFornitore(int idFornitore);
    int add(Servizio servizio);
    int update(Servizio servizio);
    int remove(Servizio servizio);
}
