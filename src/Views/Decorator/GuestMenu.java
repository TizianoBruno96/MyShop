package Views.Decorator;

import ActionListeners.RegistrazioneListeners;
import ActionListeners.SfogliaCatalogoListeners;
import Views.FinestraPrincipale;

import javax.swing.*;

public class GuestMenu extends Menu{
    private FinestraPrincipale finestra;

    public GuestMenu(FinestraPrincipale finestra) {
        this.finestra = finestra;

        JButton catalogoProdotti = new JButton("Sfoglia catalogo prodotti"); //questo button serve per sfogliare il catalogo
        JButton registrati = new JButton("Registrati");
        JButton catalogoServizi = new JButton("Sfoglia catalogo servizi");

        registrati.setActionCommand(RegistrazioneListeners.REGISTRATI_BTN);
        catalogoServizi.setActionCommand(SfogliaCatalogoListeners.SFOGLIACATALOGOSERVIZI_BTN);
        catalogoProdotti.setActionCommand(SfogliaCatalogoListeners.SFOGLIACATALOGOPRODOTTI_BTN);

        SfogliaCatalogoListeners sfogliaCatalogoListeners = new SfogliaCatalogoListeners(finestra);
        RegistrazioneListeners registrazioneListeners = new RegistrazioneListeners(finestra);

        catalogoProdotti.addActionListener(sfogliaCatalogoListeners);
        catalogoServizi.addActionListener(sfogliaCatalogoListeners);
        registrati.addActionListener(registrazioneListeners);

        pulsanti.add(catalogoProdotti);
        pulsanti.add(catalogoServizi);
        pulsanti.add(registrati);

    }
}
