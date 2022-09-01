package Model.ModelFactory;

import Model.Articoli.Servizio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServizioFactory implements IFactory<Servizio> {
    public Servizio create(ResultSet rs) throws SQLException {
        Servizio servizio = new Servizio();
        servizio.setIdServizio(rs.getInt("idServizio"));
        servizio.setNome(rs.getString("Nome"));
        servizio.setIdCategoria(rs.getInt("idCategoria"));
        servizio.setIdFornitore(rs.getInt("idFornitore"));
        servizio.setCosto(rs.getFloat("Costo"));
        return servizio;
    }
}