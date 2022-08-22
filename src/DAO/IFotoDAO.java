package DAO;

import Model.Foto;

import java.util.ArrayList;

public interface IFotoDAO {
    public ArrayList<Foto> findByProdotto(int idProdotto);
    Foto findByValore(String Valore);
    Foto findByName(String Nome);
    int add(Foto foto);
    int removeByPath(String nome);
    int update(Foto foto);
}
