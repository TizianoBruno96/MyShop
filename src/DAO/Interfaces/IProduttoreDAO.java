package DAO.Interfaces;

import Model.Articoli.Produttore;

import java.util.ArrayList;

public interface IProduttoreDAO {
    Produttore findByNome(String nome);
    Produttore findByID(int idProduttore);
    int add(Produttore produttore);
    int removeByID(int idProduttore);
    int update(Produttore produttore);
    int removeByNome(String nome);
    ArrayList<Produttore> findAll();
}
