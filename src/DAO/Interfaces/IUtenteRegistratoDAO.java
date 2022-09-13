package DAO.Interfaces;

import Model.Utenti.UtenteRegistrato;

import java.util.ArrayList;

public interface IUtenteRegistratoDAO {
    ArrayList<UtenteRegistrato> findByUtente(int idUtente);
    ArrayList<UtenteRegistrato> findByPuntoVendita(int idPuntoVendita);
    int add(UtenteRegistrato utenteRegistrato);
    int update(UtenteRegistrato utenteRegistrato);
    int remove(UtenteRegistrato utenteRegistrato);
    int removeByIDUtente(int idUtente);
    int removeByIDPuntoVendita(int idPuntoVendita);
}
