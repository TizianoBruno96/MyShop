package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneListener implements ActionListener {
    public final static String REGISTRATI_BTN = "Registrati_btn";
    private FinestraPrincipale frame;

    public RegistrazioneListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();

        if (REGISTRATI_BTN.equals(azione)) {
            frame.mostraPannelloRegistrazione();
        }
    }
}
