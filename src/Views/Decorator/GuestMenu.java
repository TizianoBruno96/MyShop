package Views.Decorator;

import ActionListeners.SfogliaCatalogoListeners;
import Views.FinestraPrincipale;

import javax.swing.*;

public class GuestMenu extends Menu{
    private FinestraPrincipale finestra;

    public GuestMenu(FinestraPrincipale finestra) {
        this.finestra = finestra;

        JButton catalogo = new JButton("Sfoglia catalogo"); //questo button serve per sfogliare il catalogo
        catalogo.setActionCommand(SfogliaCatalogoListeners.SFOGLIA_CATALOGO);
        SfogliaCatalogoListeners sfogliaCatalogoListeners = new SfogliaCatalogoListeners(finestra);
        catalogo.addActionListener(sfogliaCatalogoListeners);
        pulsanti.add(catalogo);
    }

}
