package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SfogliaCatalogoListeners implements ActionListener {
    public final static String SFOGLIA_CATALOGO = "Sfoglia_catalogo";
    private FinestraPrincipale frame;

    public SfogliaCatalogoListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }

    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione =e.getActionCommand();
        if (SFOGLIA_CATALOGO.equals(azione)){
            frame.mostraCatalogo();
        }
    }


}
