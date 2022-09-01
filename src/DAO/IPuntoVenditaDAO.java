package DAO;

import Model.PuntoVendita;

import java.util.ArrayList;

public interface IPuntoVenditaDAO {
    PuntoVendita findByManager(int idManager);
    ArrayList<PuntoVendita> findAll();
    int add(PuntoVendita puntoVendita);
    int update(PuntoVendita puntoVendita);
    int removeByID(int idPuntoVendita);
    int removeByIDMagazzino(int idPuntoVendita);
    ArrayList<PuntoVendita> findByCitta(String citta);
}
