package Views.Decorator;

import ActionListeners.RecensioneListener;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.util.List;

public class ClienteMenuDecorator extends CustomMenuDecorator {
    private final FinestraPrincipale finestra;

    public ClienteMenuDecorator(Menu menu, FinestraPrincipale finestra) {
        this.menu = menu;
        this.finestra = finestra;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        //aggiungo i pulsanti con le funzioni del cliente
        JButton lasciaFeedback = new JButton("Lasciare feedback");


        lasciaFeedback.setActionCommand(RecensioneListener.LASCIAFEEDBACK_BTN);


        RecensioneListener recensioneListener = new RecensioneListener(finestra);


        lasciaFeedback.addActionListener(recensioneListener);


        pulsanti.add(lasciaFeedback);

        return pulsanti;
    }
}
