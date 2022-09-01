package DAO;

import Model.Articoli.Prodotto;
import Model.Magazzino;
import Model.Posizione;

import java.util.ArrayList;

public interface IPosizioneDAO {
    ArrayList<Posizione> findByMagazzino(int idMagazzino);
    Posizione findByID(int IdPosizione);
    int addPosizioniInMagazzino(Magazzino magazzino);
    int addProdottoInPosizione(Prodotto prodotto, int idMagazzino, int pCorsia, int pScaffale, int quantita);
    int add(Posizione posizione);
    int removeByID(int idPosizione);
    int update(Posizione posizione);
}
