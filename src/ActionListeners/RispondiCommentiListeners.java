package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RispondiCommentiListeners implements ActionListener {
    public final static String RISPONDICOMMENTI_BTN = "RispondiCommenti_btn";
    private FinestraPrincipale frame;

    public RispondiCommentiListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
