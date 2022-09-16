package ActionListeners.Admin;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreazioneManagerListener implements ActionListener {
    public final static String CREAMANAGER_BTN = "CreaManager_btn";
    private final FinestraPrincipale frame;

    public CreazioneManagerListener(FinestraPrincipale frame) {
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CREAMANAGER_BTN.equals(azione)) {
            frame.mostraPannelloCreazioneManager();
        }
    }
}
