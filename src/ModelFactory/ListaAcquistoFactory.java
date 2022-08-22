package ModelFactory;

import Model.ListaAcquisto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaAcquistoFactory implements IFactory<ListaAcquisto> {
    public ListaAcquisto create(ResultSet rs) throws SQLException {
        ListaAcquisto listaAcquisto = new ListaAcquisto();
        listaAcquisto.setIdUtente(rs.getInt("idUtente"));
        listaAcquisto.setIdListaAcquisto(rs.getInt("idListaAcquisto"));
        listaAcquisto.setCostoTot(rs.getInt("CostoTotale"));
        return listaAcquisto;
    }
}