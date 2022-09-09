package DAO.ModelFactory;

import Model.OrdineProdotto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineProdottoFactory implements IFactory<OrdineProdotto> {
    public OrdineProdotto create(ResultSet rs) throws SQLException {
        OrdineProdotto ordineProdotto = new OrdineProdotto();
        ordineProdotto.setIdProdotto(rs.getInt("idProdotto"));
        ordineProdotto.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
        ordineProdotto.setQuantita(rs.getInt("Quantita"));
        return ordineProdotto;
    }
}