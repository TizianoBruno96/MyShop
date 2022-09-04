package DAO.ModelFactory;

import Model.Posizione;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PosizioneFactory implements IFactory<Posizione> {
    public Posizione create(ResultSet rs) throws SQLException {
        Posizione posizione = new Posizione();
        posizione.setIdPosizione(rs.getInt("idPosizione"));
        posizione.setIdMagazzino(rs.getInt("idMagazzino"));
        posizione.setIdProdotto(rs.getInt("idProdotto"));
        posizione.setQuantita(rs.getInt("Quantita"));
        posizione.setpCorsia(rs.getInt("pCorsia"));
        posizione.setpScaffale(rs.getInt("pScaffale"));
        return posizione;
    }
}