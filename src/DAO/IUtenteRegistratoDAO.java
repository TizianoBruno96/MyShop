package DAO;

import Model.UtenteRegistrato;

import java.util.ArrayList;

public interface IUtenteRegistratoDAO {
    ArrayList<UtenteRegistrato> findByUtente(int idUtente);
    ArrayList<UtenteRegistrato> findByPuntoVendita(int idPuntoVendita);
    int add(UtenteRegistrato utenteRegistrato);
    int update(UtenteRegistrato utenteRegistrato);
    int remove(UtenteRegistrato utenteRegistrato);
}
