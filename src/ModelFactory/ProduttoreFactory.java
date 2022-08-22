package ModelFactory;

import Model.Produttore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProduttoreFactory implements IFactory<Produttore> {
    public Produttore create(ResultSet rs) throws SQLException {
        Produttore produttore = new Produttore();
        produttore.setNome(rs.getString("Nome"));
        produttore.setIdProduttore(rs.getInt("idProduttore"));
        produttore.setCitta(rs.getString("Citta"));
        produttore.setNazione(rs.getString("Nazione"));
        produttore.setSitoWeb(rs.getString("SitoWeb"));
        return produttore;
    }
}