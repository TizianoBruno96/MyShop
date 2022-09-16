package ActionListeners;

import Business.InserimentoProdottoBusiness;
import DAO.Interfaces.IPosizioneDAO;
import DAO.Interfaces.IProduttoreDAO;
import DAO.PosizioneDAO;
import DAO.ProduttoreDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfermaInserimentoProdottoListener implements ActionListener {
    public static final String CIPL_BTN = "Cinpl_btn";
    private final JTable table;
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();

    public ConfermaInserimentoProdottoListener(JTable table) {
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIPL_BTN.equals(azione)) {
            String nomeProdotto = (String) table.getValueAt(0, 0);
            String descrizione = (String) table.getValueAt(0, 1);
            float costo = (float) table.getValueAt(0, 2);
            String nomeProduttore = (String) table.getValueAt(0, 3);
            String categoriaProdotto = (String) table.getValueAt(0, 4);
            String fotoPath = (String) table.getValueAt(0, 5);
            String nomeFoto = (String) table.getValueAt(0, 6);
            File foto = new File(fotoPath);

            //Controllo che i campi non siano vuoti e che il produttore non esista già
            if (nomeProdotto == null || nomeProdotto.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il nome del prodotto");
            else if (!produttoreDAO.checkNome(nomeProduttore))
                JOptionPane.showMessageDialog(null, "Il produttore inserito non esiste");
            else if (descrizione == null || descrizione.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire la descrizione del prodotto");
            else if (costo == 0)
                JOptionPane.showMessageDialog(null, "Inserire il costo del prodotto");
            else if (nomeProduttore == null || nomeProduttore.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il nome del produttore");
            else if (categoriaProdotto == null || categoriaProdotto.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire la categoria del prodotto");
            else InserimentoProdottoBusiness.getInstance().InserisciProdotto(nomeProdotto, descrizione, costo, nomeProduttore, categoriaProdotto, foto, nomeFoto);
        }
    }
}
