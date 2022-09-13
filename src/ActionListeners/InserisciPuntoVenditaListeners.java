package ActionListeners;

import Business.InserisciPuntoVenditaBusiness;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciPuntoVenditaListeners implements ActionListener {
    public final static String INSERISCIPUNTOVENDITA_BTN = "InserisciPuntoVendita_btn";
    private JTable tabella;

    public InserisciPuntoVenditaListeners(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INSERISCIPUNTOVENDITA_BTN.equals(azione)) {
            String Citta = (String) tabella.getValueAt(0, 0);
            String Nome = (String) tabella.getValueAt(0, 1);
            String Indirizzo = (String) tabella.getValueAt(0, 2);
            int IdUtenteManager = (int) tabella.getValueAt(0, 3);

            InserisciPuntoVenditaBusiness pv = InserisciPuntoVenditaBusiness.getInstance().InserisciPuntoVendita(Citta,Nome,Indirizzo,IdUtenteManager);

        }
    }
}