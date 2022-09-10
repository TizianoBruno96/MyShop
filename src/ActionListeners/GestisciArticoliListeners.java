package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestisciArticoliListeners implements ActionListener {
    public final static String GESTISCIARTICOLI_BTN = "GestisciArticoli_btn";
    private FinestraPrincipale frame;

    public GestisciArticoliListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
