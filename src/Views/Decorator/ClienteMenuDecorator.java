package Views.Decorator;

import ActionListeners.LasciaFeedbackListeners;
import ActionListeners.ListaAcquistoListeners;
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
        JButton listaAcquisto = new JButton("Lista acquisto");
        JButton prenotaArticoli = new JButton("Prenotare articoli");
        JButton lasciaFeedback = new JButton("Lasciare feedback");

        listaAcquisto.setActionCommand(ListaAcquistoListeners.LISTAACQUISTO_BTN);
        prenotaArticoli.setActionCommand(PrenotaArticoliListeners.PRENOTAARTICOLI_BTN);
        lasciaFeedback.setActionCommand(LasciaFeedbackListeners.LASCIAFEEDBACK_BTN);

        ListaAcquistoListeners listaAcquistoListeners = new ListaAcquistoListeners(finestra);
        PrenotaArticoliListeners prenotaArticoliListeners = new PrenotaArticoliListeners(finestra);
        LasciaFeedbackListeners lasciaFeedbackListeners = new LasciaFeedbackListeners(finestra);

        listaAcquisto.addActionListener(listaAcquistoListeners);
        prenotaArticoli.addActionListener(prenotaArticoliListeners);
        lasciaFeedback.addActionListener(lasciaFeedbackListeners);

        pulsanti.add(listaAcquisto);
        pulsanti.add(prenotaArticoli);
        pulsanti.add(lasciaFeedback);
        return pulsanti;
    }
}
