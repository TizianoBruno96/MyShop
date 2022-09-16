package Views.Decorator;

import ActionListeners.LasciaFeedbackListeners;
import ActionListeners.PrenotaArticoliListeners;
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



        lasciaFeedback.setActionCommand(LasciaFeedbackListeners.LASCIAFEEDBACK_BTN);


        LasciaFeedbackListeners lasciaFeedbackListeners = new LasciaFeedbackListeners(finestra);


        lasciaFeedback.addActionListener(lasciaFeedbackListeners);



        pulsanti.add(lasciaFeedback);

        return pulsanti;
    }
}
