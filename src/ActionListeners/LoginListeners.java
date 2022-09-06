package ActionListeners;

import Views.FinestraPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListeners implements ActionListener {

    //dichiaro le due costanti che userò come etichetta per i pulsanti
    public final static String LOGIN_BTN = "Login_btn";

    //dichiaro il frame che deve ricevere dal chiamante
    private FinestraPrincipale frame;

    public LoginListeners(FinestraPrincipale frame) {
        this.frame = frame;
    }
    public void setFrame(FinestraPrincipale frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione =e.getActionCommand(); //serve per catturare il tasto premuto
        if (LOGIN_BTN.equals(azione)){
            frame.mostraPannelloLogin();
        }
    }
}
