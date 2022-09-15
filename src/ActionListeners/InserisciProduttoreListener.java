package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciProduttoreListener implements ActionListener {
    public final static String INSERISCIPRODUTTORE_BTN = "InserisciProduttore_btn";
    private FinestraPrincipale frame;

    public InserisciProduttoreListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INSERISCIPRODUTTORE_BTN.equals(azione)) {
            frame.mostraPannelloInserimentoProduttore();
        }
    }
}
