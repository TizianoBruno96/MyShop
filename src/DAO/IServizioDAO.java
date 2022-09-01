package DAO;

import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;

import java.util.ArrayList;

public interface IServizioDAO {
    Servizio findByNome(String nome);
    ArrayList<Servizio> findAll();
    ArrayList<Servizio> findByFornitore(int idFornitore);
    int add(Servizio servizio);
    int update(Servizio servizio);
    int remove(Servizio servizio);
    int removeByNome(String nome);
    int removeByFornitore(int idFornitore);
    int removeByFornitore(Fornitore Fornitore);
}
