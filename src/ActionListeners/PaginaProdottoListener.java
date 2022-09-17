package ActionListeners;

import DAO.Interfaces.IProdottoDAO;
import DAO.ProdottoDAO;
import Model.Articoli.Prodotto;
import Views.FinestraPrincipale;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaProdottoListener implements ActionListener {
    public final static String PPL_BTN = "ppl_btn";
    private final JTable tableProdotti;
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    private final FinestraPrincipale frame;

    public PaginaProdottoListener(JTable tableProdotti, FinestraPrincipale frame) {
        this.tableProdotti = tableProdotti;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (azione.equals(PPL_BTN)) {
            int[] righeSelezionate = tableProdotti.getSelectedRows();
            CatalogoProdottiTableModel tModel = (CatalogoProdottiTableModel) tableProdotti.getModel();

            if (righeSelezionate.length > 1) {
                //messaggio di errore
                JOptionPane.showMessageDialog(null, "Selezionare un solo prodotto");
            } else if (righeSelezionate.length == 0) {
                //messaggio di errore
                JOptionPane.showMessageDialog(null, "Selezionare un prodotto");
            } else {
                Prodotto prodotto = prodottoDAO.findByNome(tModel.getRighe().get(righeSelezionate[0]).getNomeProdotto());
                //mostra pannello prodotto
                frame.mostraPaginaProdotto(prodotto);
            }
        }
    }
}
