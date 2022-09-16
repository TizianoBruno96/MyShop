package ActionListeners;

import Business.OrdineServizioBusiness;
import Views.Model.CatalogoServiziModel;
import Views.TableModel.CatalogoServiziTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrdineServizioListener implements ActionListener {
    public final static String ORDINESERVIZIO_BTN = "OrdineServizio_btn";
    private final JTable table;

    public OrdineServizioListener(JTable table) {
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();

        if (ORDINESERVIZIO_BTN.equals(azione)) {
            int[] selectedRows = table.getSelectedRows();
            CatalogoServiziTableModel tModel = (CatalogoServiziTableModel) table.getModel();

            ArrayList<Integer> idServizi = new ArrayList<>();

            for (int j : selectedRows) {
                CatalogoServiziModel rigaSelezionata = tModel.getRighe().get(j);
                idServizi.add(rigaSelezionata.getIdServizio());
            }

            OrdineServizioBusiness.getInstance().InserisciLista(idServizi);
        }
    }
}