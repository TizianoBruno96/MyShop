package ActionListeners;

import Business.InserimentoFornitoreBusiness;
import DAO.FornitoreDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoFornitoreListeners implements ActionListener {
    public static final String CIF_BTN="Cif_btn";
    private JTable tabella;

    public ConfermaInserimentoFornitoreListeners(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIF_BTN.equals(azione)){
            String nomeFornitore = (String) tabella.getValueAt(0,0);
            String sito = (String) tabella.getValueAt(0,1);
            if (FornitoreDAO.getInstance().checkNome(nomeFornitore))
                JOptionPane.showMessageDialog(null,"Il fornitore inserito esiste già");
                InserimentoFornitoreBusiness m = InserimentoFornitoreBusiness.getInstance().confermaFornitore(nomeFornitore,sito);
        }

    }
}
