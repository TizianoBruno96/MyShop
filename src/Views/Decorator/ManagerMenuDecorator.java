package Views.Decorator;

import ActionListeners.GestisciUtentiListeners;
import ActionListeners.RispondiCommentiListeners;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.util.List;

public class ManagerMenuDecorator extends CustomMenuDecorator {
    private final FinestraPrincipale finestra;

    public ManagerMenuDecorator(Menu menu, FinestraPrincipale finestra) {
        this.menu = menu;
        this.finestra = finestra;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        JButton inviaEmail = new JButton("Invia e-mail");
        JButton rispondiCommenti = new JButton("Rispondi ai commenti");
        JButton gestisciUtenti = new JButton("Gestisci utenti ");


        rispondiCommenti.setActionCommand(RispondiCommentiListeners.RISPONDICOMMENTI_BTN);
        gestisciUtenti.setActionCommand(GestisciUtentiListeners.GESTISCIUTENTI_BTN);


        RispondiCommentiListeners rispondiCommentiListeners = new RispondiCommentiListeners(finestra);
        GestisciUtentiListeners gestisciUtentiListeners = new GestisciUtentiListeners(finestra);


        rispondiCommenti.addActionListener(rispondiCommentiListeners);
        gestisciUtenti.addActionListener(gestisciUtentiListeners);


        pulsanti.add(rispondiCommenti);
        pulsanti.add(gestisciUtenti);
        return pulsanti;
    }
}
