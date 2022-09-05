package DAO;

import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;

import java.util.ArrayList;

public interface IProdottoDAO {
    int add(Prodotto prodotto, Categoria categoria, Produttore produttore);
    int addFiglio(Prodotto prodotto, Categoria categoria, Produttore produttore, Prodotto prodottoPadre);
    Prodotto findByID(int idProdotto);
    int removeByID(int idProdotto);
    int update(Prodotto prodotto);
    int removeByNome(String nome);
    int remove(Prodotto prodotto);
    int updateCategoria(Prodotto prodotto, Categoria categoria);
    int updateProduttore(Prodotto prodotto, Produttore produttore);
    ArrayList<Prodotto> findByProduttore(int idProduttore);
    ArrayList<Prodotto> findByCategoria(int idCategoria);
    Prodotto findByNome(String nome);
    ArrayList<Prodotto> findAll();
}
