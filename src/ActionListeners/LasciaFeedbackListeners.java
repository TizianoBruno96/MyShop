package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LasciaFeedbackListeners implements ActionListener {
    public final static String LASCIAFEEDBACK_BTN = "LasciaFeedback_btn";
    private FinestraPrincipale frame;

    public LasciaFeedbackListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
