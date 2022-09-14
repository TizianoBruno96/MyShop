package DAO.Interfaces;

import Model.Articoli.Fornitore;

import java.util.ArrayList;

public interface IFornitoreDAO {
    Fornitore findByNome(String nome);
    Fornitore findByID(int idFornitore);
    boolean checkNome(String nome);
    ArrayList<Fornitore> findAll();
    int add(Fornitore fornitore);
    int removeByName(String nome);
    int update(Fornitore fornitore);
}
