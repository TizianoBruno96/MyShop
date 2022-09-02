package DAO;

import Model.Articoli.Produttore;

import java.util.ArrayList;

public interface IProduttoreDAO {
    int add(Produttore produttore);
    int removeByID(int idProduttore);
    int update(Produttore produttore);
    int removeByNome(String nome);
    Produttore findByNome(String nome);
    Produttore findByID(int idProduttore);
    ArrayList<Produttore> findAll();
}
