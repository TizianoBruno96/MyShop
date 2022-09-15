package DAO.Interfaces;

import Model.Articoli.Servizio;
import Model.ListaAcquisto;
import Model.OrdineServizio;

import java.util.ArrayList;

public interface IOrdineServizioDAO {
    ArrayList<OrdineServizio> findAll();

    ArrayList<OrdineServizio> findByIDServizio(int idServizio);

    ArrayList<OrdineServizio> findByIDListaAcquisto(int idListaAcquisto);

    OrdineServizio find(Servizio servizio, ListaAcquisto listaAcquisto);

    int add(OrdineServizio ordineServizio);

    int removeByIDServizio(int idServizio);

    int removeByIDListaAcquisto(int idListaAcquisto);

    int removeByID(int idServizio, int idListaAcquisto);

    int update(Servizio servizio);
}
