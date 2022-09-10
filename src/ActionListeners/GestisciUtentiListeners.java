package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestisciUtentiListeners implements ActionListener {
    public final static String GESTISCIUTENTI_BTN = "GestisciUtenti_btn";
    private FinestraPrincipale frame;

    public GestisciUtentiListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
