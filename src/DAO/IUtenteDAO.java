package DAO;

import Model.Utenti.Utente;

import java.util.ArrayList;

public interface IUtenteDAO {
    Utente findByUsername(String username);
    ArrayList<Utente> findAll();
    boolean isCliente(String username);
    boolean isAmministratore(String username);
    boolean isManager(String username);
    boolean checkUtente(String username, String password);
    boolean checkUsername(String username);
    int add(Utente utente);
    int removeByUsername(String username);
    int update(Utente utente);
}