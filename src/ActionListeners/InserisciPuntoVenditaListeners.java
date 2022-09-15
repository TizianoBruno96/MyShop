package ActionListeners;

import Business.InserisciPuntoVenditaBusiness;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;
import Model.Utenti.Utente;

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
        IPuntoVenditaDAO pDAO = PuntoVenditaDAO.getInstance();


        if (INSERISCIPUNTOVENDITA_BTN.equals(azione)) {
            String Citta = (String) tabella.getValueAt(0, 0);
            String Nome = (String) tabella.getValueAt(0, 1);
            if (pDAO.checkNome(Nome)) {
                JOptionPane.showMessageDialog(null, "Il nome inserito esiste già");
            }
            String Indirizzo = (String) tabella.getValueAt(0, 2);
            String UsernameManager = (String) tabella.getValueAt(0, 3);
            if (!UtenteDAO.getInstance().isManager(UsernameManager)) {
                JOptionPane.showMessageDialog(null, "Il manager inserito non esiste");
            }
            Utente utente = UtenteDAO.getInstance().findByUsername(UsernameManager);
            int IdManager = utente.getIdUtente();

            InserisciPuntoVenditaBusiness pv = InserisciPuntoVenditaBusiness.getInstance().InserisciPuntoVendita(Citta, Nome, Indirizzo, IdManager);

        }
    }
}