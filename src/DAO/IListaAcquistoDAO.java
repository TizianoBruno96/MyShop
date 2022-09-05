package DAO;

import Model.ListaAcquisto;

public interface IListaAcquistoDAO {
    ListaAcquisto findByIDUtente(int idUtente);
    ListaAcquisto findByID(int idListaAcquisto);
    int add(ListaAcquisto listaAcquisto);
    int removeByIDUtente(int idUtente);
    int removeByID(int idListaAcquisto);
    int update(ListaAcquisto listaAcquisto);
    int updateCostoTot(ListaAcquisto listaAcquisto, int costoTot);
    int updateCostoTot(ListaAcquisto listaAcquisto);
}
