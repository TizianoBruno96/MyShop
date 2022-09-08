package DAO;

import Model.Articoli.Foto;

import java.util.ArrayList;

public interface IFotoDAO {
    public ArrayList<Foto> findByProdotto(int idProdotto);
    Foto findByID(int idFoto);
    Foto findByNome(String nome);
    int add(Foto foto);
    int removeByID(int idFoto);
    int removeByNome(String nome);
    int update(Foto foto);
}
