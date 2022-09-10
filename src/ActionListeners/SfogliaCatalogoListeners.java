package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SfogliaCatalogoListeners implements ActionListener {
    public final static String SFOGLIACATALOGOPRODOTTI_BTN = "SfogliacatalogoProdtti_btn";
    public final static String SFOGLIACATALOGOSERVIZI_BTN = "SfogliacatalogoServizi_btn";
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
        if (SFOGLIACATALOGOPRODOTTI_BTN.equals(azione)){
            frame.mostraCatalogoProdotti();
        }else if (SFOGLIACATALOGOSERVIZI_BTN.equals(azione)){
            frame.mostraCatalogoServizi();
        }
    }

}
