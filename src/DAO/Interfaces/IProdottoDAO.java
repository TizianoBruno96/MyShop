package DAO.Interfaces;

import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;

import java.util.ArrayList;

public interface IProdottoDAO {
    int add(Prodotto prodotto, Categoria categoria, Produttore produttore);
    Prodotto findByID(int idProdotto);
    int removeByID(int idProdotto);
    int update(Prodotto prodotto);
    int removeByNome(String nome);
    int remove(Prodotto prodotto);
    boolean checkNome(String nome);
    int updateCategoria(Prodotto prodotto, Categoria categoria);
    int updateProduttore(Prodotto prodotto, Produttore produttore);
    ArrayList<Prodotto> findByProduttore(int idProduttore);
    ArrayList<Prodotto> findByCategoria(int idCategoria);
    Prodotto findByNome(String nome);
    ArrayList<Prodotto> findAll();
}
