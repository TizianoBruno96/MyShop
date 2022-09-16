package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecensioneListener implements ActionListener {
    public final static String LASCIAFEEDBACK_BTN = "LasciaFeedback_btn";
    private FinestraPrincipale frame;

    public RecensioneListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
