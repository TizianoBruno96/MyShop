package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrenotaArticoliListeners implements ActionListener {
    public final static String PRENOTAARTICOLI_BTN="PrenotaArticoli_btn";
    private FinestraPrincipale frame;

    public PrenotaArticoliListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
