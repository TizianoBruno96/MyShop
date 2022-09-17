package ActionListeners.Manager;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneUtentiListener implements ActionListener {
    public final static String GESTISCIUTENTI_BTN = "GestisciUtenti_btn";
    private FinestraPrincipale frame;

    public GestioneUtentiListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();

        if (GESTISCIUTENTI_BTN.equals(azione)) {
            frame.mostraPannelloGestioneUtenti();
        }
    }
}
