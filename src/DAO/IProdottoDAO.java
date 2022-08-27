package DAO;

import Model.Prodotto;

import java.util.ArrayList;

public interface IProdottoDAO {
    int add(Prodotto prodotto);
    int removeByID(int idProdotto);
    int update(Prodotto prodotto);
    int removeByNome(String nome);
    int removeByLista(int idLista);
    ArrayList<Prodotto> findByPosizione(int idPosizione);
    ArrayList<Prodotto> findByProduttore(int idProduttore);
    ArrayList<Prodotto> findByCategoria(int idCategoria);
    ArrayList<Prodotto> findByLista(int idLista);
    ArrayList<Prodotto> findByProdottoPadre(int idProdottoPadre);
    ArrayList<Prodotto> findByProdottoPadre(String nomeProdottoPadre);
    ArrayList<Prodotto> findSottoProdotti(int idProdotto);
    Prodotto findByNome(String nome);
    ArrayList<Prodotto> findAll();
}
