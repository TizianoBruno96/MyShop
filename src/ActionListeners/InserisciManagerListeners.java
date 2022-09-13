package ActionListeners;

import Business.InserisciManagerBusiness;
import Business.RegistrazioneBusiness;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciManagerListeners implements ActionListener {
    public final static String INSERISCIMANAGER_BTN = "InserisciManager_btn";
    private JTable tabella;

    public InserisciManagerListeners(JTable tabella) {
        this.tabella = tabella;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INSERISCIMANAGER_BTN.equals(azione)) {
            String Nome = (String) tabella.getValueAt(0, 0);
            String Cognome = (String) tabella.getValueAt(0, 1);
            String Username = (String) tabella.getValueAt(0, 2);
            String Email = (String) tabella.getValueAt(0, 3);
            String Telefono = (String) tabella.getValueAt(0, 4);
            int Eta = (int) tabella.getValueAt(0, 5);
            String Residenza = (String) tabella.getValueAt(0, 6);
            String Professione = (String) tabella.getValueAt(0, 7);
            String Password = (String) tabella.getValueAt(0, 8);

            InserisciManagerBusiness m = InserisciManagerBusiness.getInstance().InserisciManager(Nome, Cognome, Username, Email, Telefono, Eta, Residenza, Professione, Password);

        }

    }
}