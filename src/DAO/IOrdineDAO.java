package DAO;

import Model.Ordine;

import java.util.ArrayList;

public interface IOrdineDAO {
    ArrayList<Ordine> findAll();
    ArrayList<Ordine> findByListaAcquisto(int idListaAcquisto);
    ArrayList<Ordine> findByProdotto(int idProdotto);
    int add(Ordine ordine);
    int removeByIDProdotto(int idProdotto);
    int removeByIDListaAcquisto(int idListaAcquisto);
    int removeByID(int idProdotto, int idListaAcquisto);
    int updateByProdotto(Ordine ordine);
    int updateByListaAcquisto(Ordine ordine);
}
