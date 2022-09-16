package ActionListeners;

import Business.ConfermaAcquistoBusiness;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaAcquistoListener implements ActionListener {
    public final static String CAL_BTN = "Cal_btn";


    public ConfermaAcquistoListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(CAL_BTN)) {

            //Faccio comparire un messaggio di conferma
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler confermare l'acquisto?", "Conferma", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                //Se confermo, aggiorno il database
                ConfermaAcquistoBusiness.getInstance().confermaAcquisto();
                //mostro un messaggio di avvenuto acquisto
                JOptionPane.showMessageDialog(null, "Acquisto effettuato con successo!");
            }
        }
    }
}
