package ActionListeners;

import Business.InserisciManagerBusiness;
import Business.LoginResult;
import Business.RegistrazioneBusiness;
import DAO.Interfaces.IUtenteDAO;
import DAO.UtenteDAO;

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
        IUtenteDAO uDAO = UtenteDAO.getInstance();
        LoginResult result = new LoginResult();
        result.setMessage("L'username inserito esista già");
        if (INSERISCIMANAGER_BTN.equals(azione)) {
            String Nome = (String) tabella.getValueAt(0, 0);
            String Cognome = (String) tabella.getValueAt(0, 1);
            String Username = (String) tabella.getValueAt(0, 2);
            if (uDAO.checkUsername(Username)){
                JOptionPane.showMessageDialog(null,result.getMessage());
            }
            String Email = (String) tabella.getValueAt(0, 3);
            result.setMessage("L'email inserita esiste già");
            if (uDAO.checkEmail(Email)){
                JOptionPane.showMessageDialog(null,result.getMessage());
            }
            String Telefono = (String) tabella.getValueAt(0, 4);
            int Eta = (int) tabella.getValueAt(0, 5);
            String Residenza = (String) tabella.getValueAt(0, 6);
            String Professione = (String) tabella.getValueAt(0, 7);
            String Password = (String) tabella.getValueAt(0, 8);

            InserisciManagerBusiness m = InserisciManagerBusiness.getInstance().InserisciManager(Nome, Cognome, Username, Email, Telefono, Eta, Residenza, Professione, Password);

        }

    }
}