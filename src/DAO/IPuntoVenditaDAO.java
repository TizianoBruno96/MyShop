package DAO;

import Model.Magazzino;
import Model.PuntoVendita;
import Model.Utenti.Utente;

import java.util.ArrayList;

public interface IPuntoVenditaDAO {
    PuntoVendita findByID(int idPuntoVendita);
    PuntoVendita findByManager(int idManager);
    ArrayList<PuntoVendita> findByCitta(String citta);
    ArrayList<PuntoVendita> findAll();
    int add(PuntoVendita puntoVendita, Magazzino magazzino, int idManager);
    int add(PuntoVendita puntoVendita, int idManager);
    int update(PuntoVendita puntoVendita);
    int removeByID(int idPuntoVendita);
    int removeByIDManager(int idManager);
}
