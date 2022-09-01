package Model.ModelFactory;

import Model.Ordine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineFactory implements IFactory<Ordine> {
    public Ordine create(ResultSet rs) throws SQLException {
        Ordine ordine = new Ordine();
        ordine.setIdProdotto(rs.getInt("idProdotto"));
        ordine.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
        return ordine;
    }
}