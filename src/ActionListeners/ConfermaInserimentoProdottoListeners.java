package ActionListeners;

import Business.InserimentoProdottoBusiness;
import DAO.ProduttoreDAO;

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
        if (CIPL_BTN.equals(azione)) {
            String nomeProdotto = (String) table.getValueAt(0, 0);
            String descrizione = (String) table.getValueAt(0, 1);
            Float costo = (float) table.getValueAt(0, 2);
            String nomeProduttore = (String) table.getValueAt(0, 3);
            if (!ProduttoreDAO.getInstance().checkNome(nomeProduttore)){
                JOptionPane.showMessageDialog(null, "Il produttore inserito non esiste");
            }
            String categoriaProdotto = (String) table.getValueAt(0, 4);
            int disponibilita = (int) table.getValueAt(0, 5);
            int pCorsia = (int) table.getValueAt(0, 6);
            int pScaffale = (int) table.getValueAt(0, 7);
            InserimentoProdottoBusiness c = InserimentoProdottoBusiness.getInstance().confermaProdotto(nomeProdotto,descrizione,costo,nomeProduttore,categoriaProdotto,disponibilita,pCorsia,pScaffale);

        }
    }
}
