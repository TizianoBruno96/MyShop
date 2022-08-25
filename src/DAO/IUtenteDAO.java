package DAO;

import Model.Utente;

import java.util.ArrayList;

public interface IUtenteDAO {
    Utente findByUsername(String username);
    ArrayList<Utente> findAll();
    int add(Utente utente);
    int removeByUsername(String username);
    int update(Utente utente);
}