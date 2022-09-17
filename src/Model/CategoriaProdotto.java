package Model;

import Business.AbstractFactory.ICategoria;

public class CategoriaProdotto implements ICategoria {
    private int idCategoria;
    private int idCategoriaPadre;
    private String Nome;

    public CategoriaProdotto() {
        this.idCategoria = 0;
        this.idCategoriaPadre = 0;
        this.Nome = "";
    }

    public CategoriaProdotto(int idCategoria, int idCategoriaPadre, String Nome) {
        this.idCategoria = idCategoria;
        this.idCategoriaPadre = idCategoriaPadre;
        this.Nome = Nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdCategoriaPadre() {
        return idCategoriaPadre;
    }

    public void setIdCategoriaPadre(int idCategoriaPadre) {
        this.idCategoriaPadre = idCategoriaPadre;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String toString() {
        return Nome;
    }
}
