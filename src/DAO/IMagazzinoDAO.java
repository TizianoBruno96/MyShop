package DAO;

import Model.Magazzino;

public interface IMagazzinoDAO {
    int add(Magazzino magazzino);
    int removeByID(int idMagazzino);
    int removeByPuntoVendita(int idPuntoVendita);
    int update(Magazzino magazzino);
    Magazzino findByID(int idMagazzino);
    Magazzino findByPuntoVendita(int idPuntoVendita);
}
