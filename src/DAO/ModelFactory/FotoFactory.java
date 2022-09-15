package DAO.ModelFactory;

import Model.Articoli.Foto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FotoFactory implements IFactory<Foto> {
    @Override
    public Foto create(ResultSet rs) throws SQLException {
        Foto foto = new Foto();
        foto.setIdFoto(rs.getInt("idFoto"));
        foto.setIdProdotto(rs.getInt("idProdotto"));
        foto.setNome(rs.getString("Nome"));
        foto.setValore(rs.getBlob("Valore"));
        return foto;
    }
}