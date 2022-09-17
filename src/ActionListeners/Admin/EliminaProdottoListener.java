package ActionListeners.Admin;

import Business.EliminaProdottoBusiness;
import DAO.Interfaces.IProdottoDAO;
import DAO.ProdottoDAO;
import Views.Model.CatalogoProdottiModel;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminaProdottoListener implements ActionListener {
    public static final String EPL_BTN = "epl_btn";
    private final JTable tabellaProdotti;
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();

    public EliminaProdottoListener(JTable tabellaProdotti) {
        this.tabellaProdotti = tabellaProdotti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals(EPL_BTN)) {
            int[] righeSelezionate = tabellaProdotti.getSelectedRows();
            CatalogoProdottiTableModel tableModel = (CatalogoProdottiTableModel) tabellaProdotti.getModel();
            if (righeSelezionate.length == 0) {
                JOptionPane.showMessageDialog(null, "Nessun elemento selezionato");
                return;
            } else {
                int[] idProdotti = new int[righeSelezionate.length];
                for (int i = 0; i < righeSelezionate.length; i++) {
                    CatalogoProdottiModel prodotto = tableModel.getRighe().get(righeSelezionate[i]);
                    idProdotti[i] = prodotto.getIdProdotto();
                }
                EliminaProdottoBusiness.getInstance().eliminaProdotto(idProdotti);

                //check finale sulla corretta eliminazione del prodotto
                for (int idProdotto : idProdotti) {
                    if (prodottoDAO.findByID(idProdotto) == null) {
                        JOptionPane.showMessageDialog(null, "Prodotto eliminato correttamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Errore nell'eliminazione del prodotto");
                    }
                }
            }
        }
    }
}
