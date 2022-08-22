package Model;

public class Categoria {
    private int idCategoria;
    private int idCategoriaPadre;
    private String Nome;

    public Categoria() {
        this.idCategoria = -1;
        this.idCategoriaPadre = -1;
        this.Nome = "";
    }

    public Categoria(int idCategoria, int idCategoriaPadre, String Nome) {
        this.idCategoria = idCategoria;
        this.idCategoriaPadre = idCategoriaPadre;
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

    public int getIdCategoriaPadre() {
        return idCategoriaPadre;
    }

    public String getNome() {
        return Nome;
    }

    public String toString() {
        return Nome;
    }
}
