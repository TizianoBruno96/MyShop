package ActionListeners;

import Business.ConfermaRimozioneBusiness;
import Views.Model.CarrelloProdottiModel;
import Views.Model.CatalogoServiziModel;
import Views.TableModel.CarrelloProdottiTableModel;
import Views.TableModel.CatalogoServiziTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfermaRimozioneListener implements ActionListener {
    public final static String CRL_BTN = "crl_btn";
    private final JTable tableProdotti;
    private final JTable tableServizi;

    public ConfermaRimozioneListener(JTable tableProdotti, JTable tableServizi) {
        this.tableProdotti = tableProdotti;
        this.tableServizi = tableServizi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(CRL_BTN)) {
            int[] prodottiSelectedRows = tableProdotti.getSelectedRows();
            int[] serviziSelectedRows = tableServizi.getSelectedRows();
            CarrelloProdottiTableModel prodottiTableModel = (CarrelloProdottiTableModel) tableProdotti.getModel();
            CatalogoServiziTableModel serviziTableModel = (CatalogoServiziTableModel) tableServizi.getModel();


            ArrayList<Integer> idProdotti = new ArrayList<>();
            ArrayList<Integer> idServizi = new ArrayList<>();
            for (int i : prodottiSelectedRows) {
                CarrelloProdottiModel prodotto = prodottiTableModel.getRighe().get(i);
                idProdotti.add(prodotto.getIdProdotto());
            }

            for (int i : serviziSelectedRows) {
                CatalogoServiziModel servizio = serviziTableModel.getRighe().get(i);
                idServizi.add(servizio.getIdServizio());
            }

            ConfermaRimozioneBusiness.getInstance().confermaRimozione(idProdotti, idServizi);
        }
    }
}
