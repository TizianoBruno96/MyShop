package ModelFactory;

import Model.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaFactory implements IFactory<Categoria> {
    @Override
    public Categoria create(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNome(rs.getString("Nome"));
        categoria.setIdCategoria(rs.getInt("idCategoria"));
        categoria.setIdCategoriaPadre(rs.getInt("idCategoriaPadre"));
        return categoria;
    }
}
