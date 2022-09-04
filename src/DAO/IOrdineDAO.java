package DAO;

import Model.Articoli.Prodotto;
import Model.ListaAcquisto;
import Model.Ordine;

import java.util.ArrayList;

public interface IOrdineDAO {
    ArrayList<Ordine> findAll();
    ArrayList<Ordine> findByListaAcquisto(int idListaAcquisto);
    ArrayList<Ordine> findByProdotto(int idProdotto);
    Ordine find(Prodotto prodotto, ListaAcquisto listaAcquisto);
    int add(Ordine ordine);
    int removeByIDProdotto(int idProdotto);
    int removeByIDListaAcquisto(int idListaAcquisto);
    int removeByID(int idProdotto, int idListaAcquisto);
    int update(Ordine ordine);
}
