package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreazioneFornitoreListener implements ActionListener {
    public final static String IF_BTN = "If_btn";
    private final FinestraPrincipale frame;

    public CreazioneFornitoreListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (IF_BTN.equals(azione))
            frame.mostraPannelloInserimentoFornitore();
    }
}
