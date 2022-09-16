package Views.Decorator;

import ActionListeners.GestioneUtentiListener;
import ActionListeners.RispondiCommentiListener;
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


        rispondiCommenti.setActionCommand(RispondiCommentiListener.RISPONDICOMMENTI_BTN);
        gestisciUtenti.setActionCommand(GestioneUtentiListener.GESTISCIUTENTI_BTN);


        RispondiCommentiListener rispondiCommentiListener = new RispondiCommentiListener(finestra);
        GestioneUtentiListener gestioneUtentiListener = new GestioneUtentiListener(finestra);


        rispondiCommenti.addActionListener(rispondiCommentiListener);
        gestisciUtenti.addActionListener(gestioneUtentiListener);


        pulsanti.add(rispondiCommenti);
        pulsanti.add(gestisciUtenti);
        return pulsanti;
    }
}
