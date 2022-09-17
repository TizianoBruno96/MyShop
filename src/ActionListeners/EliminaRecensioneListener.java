package ActionListeners;

import Business.EliminaRecensioneBusiness;
import Views.Model.RecensioniModel;
import Views.TableModel.RecensioniTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminaRecensioneListener implements ActionListener {
    public static final String ERL_BTN = "erl_btn";
    private final JTable tabellaRecensioni;

    public EliminaRecensioneListener(JTable tabellaRecensioni) {
        this.tabellaRecensioni = tabellaRecensioni;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals(ERL_BTN)) {
            int[] righeSelezionate = tabellaRecensioni.getSelectedRows();
            RecensioniTableModel tableModel = (RecensioniTableModel) tabellaRecensioni.getModel();

            int[] idRecensioni = new int[righeSelezionate.length];

            if (righeSelezionate.length == 0) {
                JOptionPane.showMessageDialog(null, "Nessun elemento selezionato");
                return;
            } else {
                for (int i = 0; i < righeSelezionate.length; i++) {
                    RecensioniModel recensione = tableModel.getRighe().get(righeSelezionate[i]);
                    idRecensioni[i] = recensione.getIdRecensione();
                }

                EliminaRecensioneBusiness.getinstance().eliminaRecensioni(idRecensioni);
            }
        }
    }
}
