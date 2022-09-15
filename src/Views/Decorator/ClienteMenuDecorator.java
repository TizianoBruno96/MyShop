package Views.Decorator;

import ActionListeners.LasciaFeedbackListeners;
import ActionListeners.PrenotaArticoliListeners;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.util.List;

public class ClienteMenuDecorator extends CustomMenuDecorator {
    private FinestraPrincipale finestra;

    public ClienteMenuDecorator(Menu menu, FinestraPrincipale finestra) {
        this.menu = menu;
        this.finestra = finestra;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        //aggiungo i pulsanti con le funzioni del cliente
        JButton prenotaArticoli = new JButton("Prenotare articoli");
        JButton lasciaFeedback = new JButton("Lasciare feedback");


        prenotaArticoli.setActionCommand(PrenotaArticoliListeners.PRENOTAARTICOLI_BTN);
        lasciaFeedback.setActionCommand(LasciaFeedbackListeners.LASCIAFEEDBACK_BTN);


        PrenotaArticoliListeners prenotaArticoliListeners = new PrenotaArticoliListeners(finestra);
        LasciaFeedbackListeners lasciaFeedbackListeners = new LasciaFeedbackListeners(finestra);


        prenotaArticoli.addActionListener(prenotaArticoliListeners);
        lasciaFeedback.addActionListener(lasciaFeedbackListeners);


        pulsanti.add(prenotaArticoli);
        pulsanti.add(lasciaFeedback);

        return pulsanti;
    }
}
