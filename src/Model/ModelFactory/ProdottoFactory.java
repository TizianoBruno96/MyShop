package Model.ModelFactory;

import Model.Articoli.Prodotto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdottoFactory implements IFactory<Prodotto> {
    public Prodotto create(ResultSet rs) throws SQLException {
        Prodotto prodotto = new Prodotto();
        prodotto.setIdProdotto(rs.getInt("idProdotto"));
        prodotto.setNome(rs.getString("Nome"));
        prodotto.setDescrizione(rs.getString("Descrizione"));
        prodotto.setCosto(rs.getFloat("Costo"));
        prodotto.setIdCategoria(rs.getInt("idCategoria"));
        prodotto.setIdProdottoPadre(rs.getInt("idProdottoPadre"));
        prodotto.setIdProduttore(rs.getInt("idProduttore"));
        prodotto.setIdPosizione(rs.getInt("idPosizione"));
        prodotto.setIdLista(rs.getInt("idLista"));
        return prodotto;
    }
}