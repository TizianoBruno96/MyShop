package ActionListeners;

import Views.Model.CatalogoProdottiModel;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarrelloListeners implements ActionListener {
    public static final String METTINELCARRELLO_BTN = "Mettinelcarrello_btn";
    private JTable tabella;

    public CarrelloListeners(JTable tabella) {
        this.tabella = tabella;
    }

    public void setTabella(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] righeSelezionate = tabella.getSelectedRows();
        for (int j : righeSelezionate) {
            CatalogoProdottiTableModel tModel = (CatalogoProdottiTableModel) tabella.getModel();
            CatalogoProdottiModel rigaSelezionata = tModel.getRighe().get(j);
            System.out.println("Nome Prodotto :" + rigaSelezionata.getNomeProdotto());
        }
    }
}
