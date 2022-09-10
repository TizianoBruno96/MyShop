package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutListeners implements ActionListener {
    private FinestraPrincipale frame;
    public final static String LOGOUT_BTN = "Logout_btn";

    public LogoutListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione =e.getActionCommand();
        if (LOGOUT_BTN.equals(azione)){
            frame.effettuaLogout();
        }
    }
}
