package ActionListeners;

import Business.RimozioneUtenteBusiness;
import Views.Model.ListaUtentiModel;
import Views.TableModel.ListaUtentiTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EliminazioneUtenteListener implements ActionListener {
    public final static String EUL_BTN = "eul_btn";
    private final JTable tabellaUtenti;

    public EliminazioneUtenteListener(JTable tabellaUtenti) {
        this.tabellaUtenti = tabellaUtenti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (EUL_BTN.equals(azione)) {
            int[] utentiSelezionati = tabellaUtenti.getSelectedRows();
            ListaUtentiTableModel listaUtentiTableModel = (ListaUtentiTableModel) tabellaUtenti.getModel();

            for (int i : utentiSelezionati) {
                ListaUtentiModel model = listaUtentiTableModel.getRighe().get(i);

                //Chiedo conferma dell'eliminazione degli utenti selezionati
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare l'utente " + model.getNome() + " " + model.getCognome() + "?", "Attenzione", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    RimozioneUtenteBusiness.getInstance().rimuoviUtente(model.getUsername());
                }
            }
        }
    }
}