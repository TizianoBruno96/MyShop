package Business;

import DAO.Interfaces.IProdottoDAO;
import DAO.ProdottoDAO;

public class EliminaProdottoBusiness {
    private static EliminaProdottoBusiness instance;
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();

    public static EliminaProdottoBusiness getInstance() {
        if (instance == null) {
            instance = new EliminaProdottoBusiness();
        }
        return instance;
    }

    public void eliminaProdotto(int[] idProdotto) {
        for (int i : idProdotto) {
            prodottoDAO.removeByID(i);
        }
    }
}
