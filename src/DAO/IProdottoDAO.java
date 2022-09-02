package DAO;

import Model.Articoli.Prodotto;

import java.util.ArrayList;

public interface IProdottoDAO {
    int add(Prodotto prodotto, String nomeCategoria, String nomeProduttore);
    int addFiglio(Prodotto prodotto, String nomeCategoria, String nomeProduttore, String nomeProdottoPadre);
    int removeByID(int idProdotto);
    int update(Prodotto prodotto);
    int removeByNome(String nome);
    ArrayList<Prodotto> findByProduttore(int idProduttore);
    ArrayList<Prodotto> findByCategoria(int idCategoria);
    Prodotto findByNome(String nome);
    ArrayList<Prodotto> findAll();
}
