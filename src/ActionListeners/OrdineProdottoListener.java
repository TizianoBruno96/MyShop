package ActionListeners;

import Business.OrdineProdottoBusiness;
import Views.Model.CatalogoProdottiModel;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrdineProdottoListener implements ActionListener {
    public static final String ORDINEPRODOTTO_BTN = "OrdineProdotto_btn";
    private final JTable tabella;

    public OrdineProdottoListener(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (ORDINEPRODOTTO_BTN.equals(azione)) {
            int[] righeSelezionate = tabella.getSelectedRows();
            CatalogoProdottiTableModel tModel = (CatalogoProdottiTableModel) tabella.getModel();

            ArrayList<Integer> idProdotti = new ArrayList<>();
            ArrayList<Integer> quantita = new ArrayList<>();

            for (int j : righeSelezionate) {
                CatalogoProdottiModel rigaSelezionata = tModel.getRighe().get(j);
                idProdotti.add(rigaSelezionata.getIdProdotto());
                //chiedo quanti prodotti vuole ordinare
                String quantitaOrdinata = JOptionPane.showInputDialog("Inserisci la quantità da ordinare per il prodotto " + rigaSelezionata.getNomeProdotto());
                int quantitaOrdinataInt = Integer.parseInt(quantitaOrdinata);
                quantita.add(quantitaOrdinataInt);
            }

            OrdineProdottoBusiness.getInstance().InserisciLista(idProdotti, quantita);
        }
    }
}
