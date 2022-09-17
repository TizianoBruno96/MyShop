package Business;

import DAO.FotoDAO;
import DAO.Interfaces.IFotoDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.ProdottoDAO;
import Model.Articoli.Foto;

import java.util.ArrayList;

public class EliminaProdottoBusiness {
    private static EliminaProdottoBusiness instance;
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IFotoDAO fotoDAO = FotoDAO.getInstance();

    public static EliminaProdottoBusiness getInstance() {
        if (instance == null) {
            instance = new EliminaProdottoBusiness();
        }
        return instance;
    }

    public void eliminaProdotto(int[] idProdotto) {
        for (int i : idProdotto) {
            ArrayList<Foto> foto = fotoDAO.findByProdotto(i);
            for (Foto f : foto) {
                fotoDAO.removeByID(f.getIdFoto());
            }
            prodottoDAO.removeByID(i);
        }
    }
}
