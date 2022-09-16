package Views.Decorator;

import ActionListeners.SfogliaCatalogoListener;
import Views.FinestraPrincipale;

import javax.swing.*;

public class GuestMenu extends Menu {
    public GuestMenu(FinestraPrincipale finestra) {

        JButton catalogoProdotti = new JButton("Sfoglia catalogo prodotti"); //questo button serve per sfogliare il catalogo
        JButton catalogoServizi = new JButton("Sfoglia catalogo servizi");

        catalogoServizi.setActionCommand(SfogliaCatalogoListener.SFOGLIACATALOGOSERVIZI_BTN);
        catalogoProdotti.setActionCommand(SfogliaCatalogoListener.SFOGLIACATALOGOPRODOTTI_BTN);

        SfogliaCatalogoListener sfogliaCatalogoListener = new SfogliaCatalogoListener(finestra);

        catalogoProdotti.addActionListener(sfogliaCatalogoListener);
        catalogoServizi.addActionListener(sfogliaCatalogoListener);

        pulsanti.add(catalogoProdotti);
        pulsanti.add(catalogoServizi);
    }
}
