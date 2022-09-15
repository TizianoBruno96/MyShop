package ActionListeners;

import Business.ConfermaInserimentoProduttoriBusiness;
import DAO.Interfaces.IProduttoreDAO;
import DAO.ProduttoreDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoProduttoriListeners implements ActionListener {
    public final static String CIPL_BTN = "confermaInserimentoProduttori_btn";
    private JTable tabella;

    public ConfermaInserimentoProduttoriListeners(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIPL_BTN.equals(azione)){
            IProduttoreDAO pDAO = ProduttoreDAO.getInstance();

                    String NomeProduttore = (String) tabella.getValueAt(0,0);
                    if (pDAO.checkNome(NomeProduttore)){
                        JOptionPane.showMessageDialog(null,"Il produttore inserito esiste già");
                    }
                    String Sito = (String) tabella.getValueAt(0,1);
                    String Citta = (String) tabella.getValueAt(0,2);
                    String Nazione = (String) tabella.getValueAt(0,3);

            ConfermaInserimentoProduttoriBusiness c = ConfermaInserimentoProduttoriBusiness.getInstance().InserisciProduttore(NomeProduttore,Sito,Citta,Nazione);


                }

        }

    }
