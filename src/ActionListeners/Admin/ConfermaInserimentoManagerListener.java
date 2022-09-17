package ActionListeners.Admin;

import Business.InserimentoManagerBusiness;
import DAO.Interfaces.IUtenteDAO;
import DAO.UtenteDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoManagerListener implements ActionListener {
    public final static String INSERISCIMANAGER_BTN = "InserisciManager_btn";
    private final JTable tabella;
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();

    public ConfermaInserimentoManagerListener(JTable tabella) {
        this.tabella = tabella;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INSERISCIMANAGER_BTN.equals(azione)) {
            String nome = (String) tabella.getValueAt(0, 0);
            String cognome = (String) tabella.getValueAt(0, 1);
            String username = (String) tabella.getValueAt(0, 2);
            String email = (String) tabella.getValueAt(0, 3);
            String telefono = (String) tabella.getValueAt(0, 4);
            int eta = (int) tabella.getValueAt(0, 5);
            String residenza = (String) tabella.getValueAt(0, 6);
            String professione = (String) tabella.getValueAt(0, 7);
            String password = (String) tabella.getValueAt(0, 8);

            //controllo che i campi non siano vuoti e che l'utente non esista già
            if (nome == null || nome.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire il nome");
            } else if (cognome == null || cognome.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire il cognome");
            } else if (username == null || username.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire lo username");
            } else if (utenteDAO.checkUsername(username)) {
                JOptionPane.showMessageDialog(null, "Lo username inserito esiste già");
            } else if (email == null || email.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire l'email");
            } else if (utenteDAO.checkEmail(email)) {
                JOptionPane.showMessageDialog(null, "L'email inserita esiste già");
            } else if (telefono == null || telefono.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire il telefono");
            } else if (eta == 0) {
                JOptionPane.showMessageDialog(null, "Inserire l'età");
            } else if (residenza == null || residenza.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire la residenza");
            } else if (professione == null || professione.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire la professione");
            } else if (password == null || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire la password");
            } else {
                InserimentoManagerBusiness.getInstance().InserisciManager(nome, cognome, username, email, telefono, eta, residenza, professione, password);

                //check finale sul corretto inserimento del manager
                if (utenteDAO.checkUsername(username)) {
                    JOptionPane.showMessageDialog(null, "Manager inserito con successo");
                } else {
                    JOptionPane.showMessageDialog(null, "Errore nell'inserimento del manager");
                }
            }
        }
    }
}