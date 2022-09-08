package DAO.ModelFactory;

import Model.OrdineServizio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineServizioFactory implements IFactory<OrdineServizio> {
    public OrdineServizio create(ResultSet rs) throws SQLException {
        OrdineServizio ordineServizio = new OrdineServizio();
        ordineServizio.setIdServizio(rs.getInt("idServizio"));
        ordineServizio.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
        return ordineServizio;
    }
}