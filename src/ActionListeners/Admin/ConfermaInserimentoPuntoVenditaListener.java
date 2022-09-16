package ActionListeners.Admin;

import Business.InserimentoPuntoVenditaBusiness;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.Interfaces.IUtenteDAO;
import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.PuntoVenditaDAO;
import DAO.UtenteDAO;
import DAO.UtenteRegistratoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoPuntoVenditaListener implements ActionListener {
    public final static String INSERISCIPUNTOVENDITA_BTN = "InserisciPuntoVendita_btn";
    private final JTable tabella;
    IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IUtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();

    public ConfermaInserimentoPuntoVenditaListener(JTable tabella) {
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
            int maxCorsia = (int) tabella.getValueAt(0, 4);
            int maxScaffale = (int) tabella.getValueAt(0, 5);

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
            else if (utenteRegistratoDAO.findByUtente(utenteDAO.findByUsername(usernameManager).getIdUtente()) != null)
                JOptionPane.showMessageDialog(null, "Il manager inserito è già manager di un altro punto vendita");
            else if (maxCorsia == 0 || maxScaffale == 0)
                JOptionPane.showMessageDialog(null, "Inserire valori accettabili per la grandezza del magazzino");
            else {
                int idManager = utenteDAO.findByUsername(usernameManager).getIdUtente();
                InserimentoPuntoVenditaBusiness.getInstance().InserisciPuntoVendita(citta, nome, indirizzo, idManager, maxCorsia, maxScaffale);
            }
        }
    }
}