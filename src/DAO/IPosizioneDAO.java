package DAO;

import Model.Posizione;

import java.util.ArrayList;

public interface IPosizioneDAO {
    ArrayList<Posizione> findByMagazzino(int idMagazzino);
    Posizione findByID(int IdPosizione);
    int add(Posizione posizione);
    int removeByID(int idPosizione);
    int update(Posizione posizione);
}
