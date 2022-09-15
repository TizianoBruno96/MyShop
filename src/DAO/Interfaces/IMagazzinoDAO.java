package DAO.Interfaces;

import Model.Magazzino;
import Model.PuntoVendita;

import java.util.ArrayList;

public interface IMagazzinoDAO {
    int add(Magazzino magazzino, int idPuntoVendita);

    Magazzino findByID(int idMagazzino);

    Magazzino findByPuntoVendita(int idPuntoVendita);

    ArrayList<Magazzino> findAll();

    int removeByID(int idMagazzino);

    int removeByPuntoVendita(int idPuntoVendita);

    int update(Magazzino magazzino);
}
