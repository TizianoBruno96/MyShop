package DAO;

import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;

import java.util.ArrayList;

public interface IServizioDAO {
    Servizio findByID(int idServizio);
    Servizio findByNome(String nome);
    ArrayList<Servizio> findAll();
    ArrayList<Servizio> findByFornitore(int idFornitore);
    ArrayList<Servizio> findByCategoria(int idCategoria);
    int add(Servizio servizio, int idCategoria, int idFornitore);
    int update(Servizio servizio);
    int removeByID(int idServizio);
    int removeByNome(String nome);
    int removeByFornitore(int idFornitore);
    int removeByFornitore(Fornitore Fornitore);
}
