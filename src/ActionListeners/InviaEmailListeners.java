package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InviaEmailListeners implements ActionListener {
    public final static String INVIAEMAIL_BTN = "InviaEmail_btn";
    private FinestraPrincipale frame;

    public InviaEmailListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
