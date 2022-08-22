package DAO;

import Model.Produttore;

import java.util.ArrayList;

public interface IProduttoreDAO {
    int add(Produttore produttore);
    int removeByID(int idProduttore);
    int update(Produttore produttore);
    int removeByNome(String nome);
    Produttore findByNome(String nome);
    ArrayList<Produttore> findAll();
}
