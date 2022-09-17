package ActionListeners.Admin;

import Views.TableModel.CatalogoProdottiTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserimentoProdottoInPuntoVenditaListener implements ActionListener {
    public final static String IPIPV_BTN = "ipipv_btn";
    private final JTable table;

    public InserimentoProdottoInPuntoVenditaListener(JTable table) {
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (IPIPV_BTN.equals(azione)) {
            int selectedRow = table.getSelectedRow();
            CatalogoProdottiTableModel tModel = (CatalogoProdottiTableModel) table.getModel();


            //inserisco pannello per chiedere il nome del punto vendita

        }
    }
}
