package Model.ModelFactory;

import Model.Recensione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecensioneFactory implements IFactory<Recensione> {
    @Override
    public Recensione create(ResultSet rs) throws SQLException {
        Recensione recensione = new Recensione();
        recensione.setIdRecensione(rs.getInt("idRecensione"));
        recensione.setVoto(rs.getInt("Voto"));
        recensione.setCommento(rs.getString("Commento"));
        recensione.setIdProdotto(rs.getInt("idProdotto"));
        recensione.setIdUtente(rs.getInt("idUtente"));
        recensione.setData(rs.getDate("Data"));
        return recensione;
    }
}
