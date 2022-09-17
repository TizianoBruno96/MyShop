package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SfogliaCarrelloListener implements ActionListener {
    public final static String SFOGLIACARRELLO_BTN = "SfogliaCarrello_btn";
    private FinestraPrincipale frame;

    public SfogliaCarrelloListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (SFOGLIACARRELLO_BTN.equals(azione)) {
            frame.mostraPannelloSfogliaCarrello();
        }
    }
}
