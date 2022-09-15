package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciProdottoListeners implements ActionListener {
    public final static String INSERISCIPRODOTTO_BTN = "InserisciProdotto_btn";
    private FinestraPrincipale frame;

    public InserisciProdottoListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INSERISCIPRODOTTO_BTN.equals(azione)){
            frame.mostraPannelloInserimentoProdotto();
        }

    }
}
