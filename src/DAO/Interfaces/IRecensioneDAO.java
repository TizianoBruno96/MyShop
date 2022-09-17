package DAO.Interfaces;

import Model.Recensione;

import java.util.ArrayList;

public interface IRecensioneDAO {
    Recensione findByID(int idRecensione);

    Recensione find(int idProdotto, int idUtente);

    ArrayList<Recensione> findByProdotto(int idProdotto);

    ArrayList<Recensione> findByUtente(int idUtente);

    int add(Recensione recensione);

    int update(Recensione recensione);

    int remove(int idRecensione);

    int removeByProdottoAndUtente(int idProdotto, int idUtente);

    int removeByProdotto(int idProdotto);

    int removeByUtente(int idUtente);
}
