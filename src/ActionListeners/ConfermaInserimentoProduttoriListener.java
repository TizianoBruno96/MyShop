package ActionListeners;

import Business.InserimentoProduttoreBusiness;
import DAO.Interfaces.IProduttoreDAO;
import DAO.ProduttoreDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoProduttoriListener implements ActionListener {
    public final static String CIPL_BTN = "confermaInserimentoProduttori_btn";
    private final JTable tabella;
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();

    public ConfermaInserimentoProduttoriListener(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIPL_BTN.equals(azione)) {
            String NomeProduttore = (String) tabella.getValueAt(0, 0);
            String Sito = (String) tabella.getValueAt(0, 1);
            String Citta = (String) tabella.getValueAt(0, 2);
            String Nazione = (String) tabella.getValueAt(0, 3);

            //Controllo che i campi non siano vuoti e che il produttore non esista già
            if (NomeProduttore == null || NomeProduttore.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il nome del produttore");
            else if (Sito == null || Sito.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il sito del produttore");
            else if (Citta == null || Citta.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire la città del produttore");
            else if (Nazione == null || Nazione.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire la nazione del produttore");
            else if (produttoreDAO.findByNome(NomeProduttore) != null)
                JOptionPane.showMessageDialog(null, "Il produttore inserito esiste già");
            else
                InserimentoProduttoreBusiness.getInstance().InserisciProduttore(NomeProduttore, Sito, Citta, Nazione);
        }
    }
}
