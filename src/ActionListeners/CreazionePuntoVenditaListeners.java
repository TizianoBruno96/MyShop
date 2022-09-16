package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreazionePuntoVenditaListeners implements ActionListener {
    public static final String CREAPUNTOVENDITA_BTN = "CreaPuntoVendita_btn";
    private FinestraPrincipale frame;

    public CreazionePuntoVenditaListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CREAPUNTOVENDITA_BTN.equals(azione)) {
            frame.mostraPannelloCreazionePuntoVendita();
        }
    }
}
