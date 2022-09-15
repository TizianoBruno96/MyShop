package ActionListeners;

import Business.InserimentoFornitoreBusiness;
import DAO.FornitoreDAO;
import DAO.Interfaces.IFornitoreDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoFornitoreListener implements ActionListener {
    public static final String CIF_BTN = "Cif_btn";
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
    private final JTable tabella;

    public ConfermaInserimentoFornitoreListener(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIF_BTN.equals(azione)) {
            String nomeFornitore = (String) tabella.getValueAt(0, 0);
            String sito = (String) tabella.getValueAt(0, 1);

            //controllo che i campi non siano vuoti e che il fornitore non esista già
            if (nomeFornitore == null || nomeFornitore.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il nome del fornitore");
            else if (sito == null || sito.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il sito del fornitore");
            else if (fornitoreDAO.checkNome(nomeFornitore))
                JOptionPane.showMessageDialog(null, "Il fornitore inserito esiste già");
            else
                InserimentoFornitoreBusiness.getInstance().InserisciFornitore(nomeFornitore, sito);
        }
    }
}
