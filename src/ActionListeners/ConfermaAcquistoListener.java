package ActionListeners;

import DAO.Interfaces.IListaAcquistoDAO;
import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.Interfaces.IOrdineServizioDAO;
import DAO.ListaAcquistoDAO;
import DAO.OrdineProdottoDAO;
import DAO.OrdineServizioDAO;
import Model.ListaAcquisto;
import Views.AccessoUtente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaAcquistoListener implements ActionListener {
    public final static String CAL_BTN = "Cal_btn";

    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();

    public ConfermaAcquistoListener() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(CAL_BTN)) {
            ListaAcquisto ls = listaAcquistoDAO.findByIDUtente(AccessoUtente.getIdUtente());

            //Faccio comparire un messaggio di conferma
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler confermare l'acquisto?", "Conferma", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                //Se confermo, aggiorno il database
                ordineProdottoDAO.removeByIDListaAcquisto(ls.getIdListaAcquisto());
                ordineServizioDAO.removeByIDListaAcquisto(ls.getIdListaAcquisto());
                //mostro un messaggio di avvenuto acquisto
                JOptionPane.showMessageDialog(null, "Acquisto effettuato con successo!");
            }
        }
    }
}
