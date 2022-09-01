package DAO;

import Model.Categoria;

import java.util.ArrayList;

public interface ICategoriaDAO {
    Categoria findByNome(String nome);
    ArrayList<Categoria> findAll();
    ArrayList<Categoria> findByCategoriaPadre(int idCategoriaPadre);
    ArrayList<Categoria> findByCategoriaPadre(String nomeCategoriaPadre);
    ArrayList<Categoria> findSottoCategorie(int idCategoria);
    int add(Categoria categoria);
    int removeByName(String nome);
    int update(Categoria categoria);
}
