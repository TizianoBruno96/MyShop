package Views.Decorator;

import ActionListeners.SfogliaCarrelloListener;
import ActionListeners.SfogliaCatalogoListener;
import Views.FinestraPrincipale;

import javax.swing.*;

public class GuestMenu extends Menu {
    public GuestMenu(FinestraPrincipale finestra) {
        JButton catalogoProdotti = new JButton("Sfoglia catalogo prodotti"); //questo button serve per sfogliare il catalogo
        JButton catalogoServizi = new JButton("Sfoglia catalogo servizi");
        JButton carrello = new JButton("Carrello");

        catalogoServizi.setActionCommand(SfogliaCatalogoListener.SFOGLIACATALOGOSERVIZI_BTN);
        catalogoProdotti.setActionCommand(SfogliaCatalogoListener.SFOGLIACATALOGOPRODOTTI_BTN);
        carrello.setActionCommand(SfogliaCarrelloListener.SFOGLIACARRELLO_BTN);

        SfogliaCatalogoListener sfogliaCatalogoListener = new SfogliaCatalogoListener(finestra);
        SfogliaCarrelloListener sfogliaCarrelloListener = new SfogliaCarrelloListener(finestra);

        catalogoProdotti.addActionListener(sfogliaCatalogoListener);
        catalogoServizi.addActionListener(sfogliaCatalogoListener);
        carrello.addActionListener(sfogliaCarrelloListener);

        pulsanti.add(catalogoProdotti);
        pulsanti.add(catalogoServizi);
        pulsanti.add(carrello);
    }
}
