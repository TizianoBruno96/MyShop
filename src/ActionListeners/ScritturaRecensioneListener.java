package ActionListeners;

import Business.ScritturaRecensioneBusiness;
import Model.Articoli.Prodotto;
import Utilities.IntegerExt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScritturaRecensioneListener implements ActionListener {
    public final static String SR_BTN = "sr_btn";
    private final JPanel pannello;
    private final Prodotto prodotto;

    public ScritturaRecensioneListener(JPanel pannello, Prodotto prodotto) {
        this.pannello = pannello;
        this.prodotto = prodotto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (SR_BTN.equals(actionCommand)) {
            //Chiedo all'utente d'inserire una recensione
            String recensione = JOptionPane.showInputDialog(pannello, "Inserisci la tua recensione", "Recensione", JOptionPane.PLAIN_MESSAGE);
            String voto = JOptionPane.showInputDialog(pannello, "Inserisci il tuo voto", "Voto", JOptionPane.PLAIN_MESSAGE);
            if (IntegerExt.isParsable(voto)) {
                int votoInt = Integer.parseInt(voto);
                if (votoInt >= 1 && votoInt <= 5) {
                    ScritturaRecensioneBusiness scriviRecensione = new ScritturaRecensioneBusiness();
                    scriviRecensione.scriviRecensione(recensione, votoInt, prodotto.getIdProdotto());
                } else {
                    JOptionPane.showMessageDialog(pannello, "Il voto deve essere compreso tra 1 e 5", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(pannello, "Il voto deve essere un numero", "Errore", JOptionPane.ERROR_MESSAGE);
            }

            //Se l'utente non ha inserito nulla, esco


        }
    }
}
