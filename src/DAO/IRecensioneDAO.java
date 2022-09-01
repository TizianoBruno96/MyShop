package DAO;

import Model.Recensione;

import java.util.ArrayList;

public interface IRecensioneDAO {
    ArrayList<Recensione> findByProdotto(int idProdotto);
    ArrayList<Recensione> findByUtente(int idUtente);
    int add(Recensione recensione);
    int update(Recensione recensione);
    int remove(int idRecensione);
    int removeByProdottoAndUtente(int idProdotto, int idUtente);
}
