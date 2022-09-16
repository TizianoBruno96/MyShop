package ActionListeners.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CreazioneFotoListener implements ActionListener {
    public static final String INFO_BTN = "InFo_btn";
    private final JTable table;
    private final JFileChooser fileChooser;

    public CreazioneFotoListener(JTable table, JFileChooser fileChooser) {
        this.table = table;
        this.fileChooser = fileChooser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INFO_BTN.equals(azione)) {
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                table.setValueAt(file.getAbsolutePath(), 0, 5);
            }
        }
    }
}
