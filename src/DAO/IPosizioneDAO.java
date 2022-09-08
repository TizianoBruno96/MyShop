package DAO;

import Model.Articoli.Prodotto;
import Model.Magazzino;
import Model.Posizione;

import java.util.ArrayList;

public interface IPosizioneDAO {
    ArrayList<Posizione> findByMagazzino(int idMagazzino);
    Posizione findByID(int IdPosizione);
    Posizione find(int pCorsia, int pScaffale, int idMagazzino);
    ArrayList<Posizione> findByProdotto(Prodotto prodotto);
    ArrayList<Posizione> find(int idProdotto, int idMagazzino);
    int addPosizioniInMagazzino(Magazzino magazzino);
    int add(Posizione posizione, int idMagazzino);
    int addProdottoInPosizione(Prodotto prodotto, int corsia, int scaffale, int idMagazzino, int quantita);
    int removeByID(int idPosizione);
    int removeByMagazzino(int idMagazzino);
    int update(Posizione posizione);
}
