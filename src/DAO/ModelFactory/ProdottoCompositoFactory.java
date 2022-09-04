package DAO.ModelFactory;

import Model.Articoli.ProdottoComposito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdottoCompositoFactory implements IFactory {

    @Override
    public ProdottoComposito create(ResultSet rs) throws SQLException {
        ProdottoComposito prodottoComposito = new ProdottoComposito();
        prodottoComposito.setIdProdottoPadre(rs.getInt("idProdottoPadre"));
        prodottoComposito.setIdProdottoFiglio(rs.getInt("idProdottoFiglio"));
        return prodottoComposito;
    }
}
