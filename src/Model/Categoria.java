package Model;

import Business.AbstractFactory.ICategoria;

public class Categoria {
    private int idCategoria;
    private Integer idCategoriaPadre;
    private String Nome;

    public Categoria() {
        this.idCategoria = 0;
        this.idCategoriaPadre = null;
        this.Nome = "";
    }

    public Categoria(int idCategoria, int idCategoriaPadre, String Nome) {
        this.idCategoria = idCategoria;
        this.idCategoriaPadre = idCategoriaPadre;
        this.Nome = Nome;
    }

    public Categoria(String Nome) {
        this.idCategoria = 0;
        this.idCategoriaPadre = null;
        this.Nome = Nome;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setIdCategoriaPadre(int idCategoriaPadre) {
        this.idCategoriaPadre = idCategoriaPadre;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public Integer getIdCategoriaPadre() {
        return idCategoriaPadre;
    }

    public String getNome() {
        return Nome;
    }

    public String toString() {
        return idCategoria + " " + idCategoriaPadre + " " + Nome;
    }
}
