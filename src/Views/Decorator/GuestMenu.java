package Views.Decorator;

import ActionListeners.SfogliaCatalogoListeners;
import Views.FinestraPrincipale;

import javax.swing.*;

public class GuestMenu extends Menu {
    public GuestMenu(FinestraPrincipale finestra) {

        JButton catalogoProdotti = new JButton("Sfoglia catalogo prodotti"); //questo button serve per sfogliare il catalogo
        JButton catalogoServizi = new JButton("Sfoglia catalogo servizi");

        catalogoServizi.setActionCommand(SfogliaCatalogoListeners.SFOGLIACATALOGOSERVIZI_BTN);
        catalogoProdotti.setActionCommand(SfogliaCatalogoListeners.SFOGLIACATALOGOPRODOTTI_BTN);

        SfogliaCatalogoListeners sfogliaCatalogoListeners = new SfogliaCatalogoListeners(finestra);

        catalogoProdotti.addActionListener(sfogliaCatalogoListeners);
        catalogoServizi.addActionListener(sfogliaCatalogoListeners);

        pulsanti.add(catalogoProdotti);
        pulsanti.add(catalogoServizi);
    }
}
