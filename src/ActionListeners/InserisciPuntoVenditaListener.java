package ActionListeners;

import Business.InserimentoPuntoVenditaBusiness;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciPuntoVenditaListener implements ActionListener {
    public final static String INSERISCIPUNTOVENDITA_BTN = "InserisciPuntoVendita_btn";
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    private JTable tabella;
    public InserisciPuntoVenditaListener(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();

        if (INSERISCIPUNTOVENDITA_BTN.equals(azione)) {
            String citta = (String) tabella.getValueAt(0, 0);
            String nome = (String) tabella.getValueAt(0, 1);
            String indirizzo = (String) tabella.getValueAt(0, 2);
            String usernameManager = (String) tabella.getValueAt(0, 3);

            //Controllo che i campi non siano vuoti e che il punto vendita non esista già e che l'utente sia un manager
            if (citta == null || citta.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire la città");
            else if (nome == null || nome.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il nome del punto vendita");
            else if (indirizzo == null || indirizzo.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire l'indirizzo del punto vendita");
            else if (usernameManager == null || usernameManager.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire lo username del manager");
            else if (puntoVenditaDAO.findByNome(nome) != null)
                JOptionPane.showMessageDialog(null, "Il punto vendita inserito esiste già");
            else if (utenteDAO.findByUsername(usernameManager) == null)
                JOptionPane.showMessageDialog(null, "Lo username inserito non esiste");
            else if (!utenteDAO.findByUsername(usernameManager).getTipo().equals("MN"))
                JOptionPane.showMessageDialog(null, "Lo username inserito non è un manager");
            else {
                int idManager = utenteDAO.findByUsername(usernameManager).getIdUtente();
                InserimentoPuntoVenditaBusiness.InserisciPuntoVendita(citta, nome, indirizzo, idManager);
            }
        }
    }
}