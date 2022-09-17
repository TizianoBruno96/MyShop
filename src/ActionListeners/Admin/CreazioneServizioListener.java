package ActionListeners.Admin;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreazioneServizioListener implements ActionListener {
    public final static String CSL_BTN = "Csl_btn";
    private final FinestraPrincipale frame;

    public CreazioneServizioListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CSL_BTN.equals(azione))
            frame.mostraPannelloInserimentoServizio();
    }
}
