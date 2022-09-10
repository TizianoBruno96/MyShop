package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaAcquistoListeners implements ActionListener {
    public final static String LISTAACQUISTO_BTN="ListaAcquisto_btn";
    private FinestraPrincipale frame;

    public ListaAcquistoListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
