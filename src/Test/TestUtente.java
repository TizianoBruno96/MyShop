package Test;

import DAO.Interfaces.IUtenteDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;

import java.util.ArrayList;

public class TestUtente {
    public static void main(String[] args) {
        //stampo tutti gli utenti
        IUtenteDAO utenteDAO = UtenteDAO.getInstance();
        ArrayList<Utente> utenti = utenteDAO.findAll();
        for (Utente utente : utenti) {
            System.out.println(utente.toString());
        }
    }
}
