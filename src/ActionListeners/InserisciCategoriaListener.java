package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserisciCategoriaListener implements ActionListener {
    public final static String IC_BTN = "Ic_btn";
    private final FinestraPrincipale frame;

    public InserisciCategoriaListener(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (IC_BTN.equals(azione))
            frame.mostraPannelloInserimentoCategoria();
    }
}
