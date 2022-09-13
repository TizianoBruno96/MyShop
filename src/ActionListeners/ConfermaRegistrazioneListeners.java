package ActionListeners;

import Business.RegistrazioneBusiness;
import DAO.IUtenteDAO;
import DAO.UtenteDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaRegistrazioneListeners implements ActionListener {
    public final static String CONFERMAREGISTRAZIONE_BTN = "ConfermaRegistrazione_btn";
    private JTable tabella;

    public ConfermaRegistrazioneListeners(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        IUtenteDAO uDAO = UtenteDAO.getInstance();
        if (CONFERMAREGISTRAZIONE_BTN.equals(azione)){
            String Nome = (String) tabella.getValueAt(0,0);
            String Cognome = (String) tabella.getValueAt(0,1);
            String Username = (String) tabella.getValueAt(0,2);
            String Email = (String) tabella.getValueAt(0,3);
            String Telefono = (String) tabella.getValueAt(0,4);
            int Eta = (int) tabella.getValueAt(0,5);
            String Residenza = (String) tabella.getValueAt(0,6);
            String Professione = (String) tabella.getValueAt(0,7);
            String Password = (String) tabella.getValueAt(0,8);
            String nomePuntoVendita = (String) tabella.getValueAt(0,9);

            RegistrazioneBusiness r = RegistrazioneBusiness.getInstance().confermaRegistrazione(Nome,Cognome,Username,Email,Telefono,Eta,Residenza,Professione,Password,nomePuntoVendita);

        }

    }
}
