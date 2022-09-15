package ActionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoProdottoListeners implements ActionListener {
    public static final String CIPL_BTN = "Cinpl_btn";
    private JTable table;

    public ConfermaInserimentoProdottoListeners(JTable table) {
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIPL_BTN.equals(azione)){
            String nomeProdotto= (String) table.getValueAt(0,0);
            String descrizione= (String) table.getValueAt(0,1);
            String costo= (String) table.getValueAt(0,2);
            String nomeProduttore= (String) table.getValueAt(0,3);
            String categoriaProdotto= (String) table.getValueAt(0,4);
            String Disponibilita= (String) table.getValueAt(0,5);
            String pCorsia= (String) table.getValueAt(0,6);
            String pScaffale= (String) table.getValueAt(0,7);

        }
    }
}
