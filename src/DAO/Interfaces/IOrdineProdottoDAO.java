package DAO.Interfaces;

import Model.Articoli.Prodotto;
import Model.ListaAcquisto;
import Model.OrdineProdotto;

import java.util.ArrayList;

public interface IOrdineProdottoDAO {
    ArrayList<OrdineProdotto> findAll();

    ArrayList<OrdineProdotto> findByListaAcquisto(int idListaAcquisto);

    ArrayList<OrdineProdotto> findByProdotto(int idProdotto);

    OrdineProdotto find(Prodotto prodotto, ListaAcquisto listaAcquisto);

    int add(OrdineProdotto ordineProdotto);

    int removeByIDProdotto(int idProdotto);

    int removeByIDListaAcquisto(int idListaAcquisto);

    int removeByID(int idProdotto, int idListaAcquisto);

    int update(OrdineProdotto ordineProdotto);
}
