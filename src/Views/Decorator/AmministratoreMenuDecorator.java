package Views.Decorator;

import ActionListeners.CreaManagerListeners;
import ActionListeners.CrearePuntoVenditaListeners;
import ActionListeners.GestisciArticoliListeners;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AmministratoreMenuDecorator extends CustomMenuDecorator{
    private FinestraPrincipale finestra;

    public AmministratoreMenuDecorator(Menu menu, FinestraPrincipale frame) {
        this.menu = menu;
        this.finestra = frame;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        JButton gestioneArticoli = new JButton("Gestisci articoli");
        JButton crearePuntoVendita = new JButton("Crea punto vendita");
        JButton creaManager = new JButton("Crea Manager");


        gestioneArticoli.setActionCommand(GestisciArticoliListeners.GESTISCIARTICOLI_BTN);
        crearePuntoVendita.setActionCommand(CrearePuntoVenditaListeners.CREAPUNTOVENDITA_BTN);
        creaManager.setActionCommand(CreaManagerListeners.CREAMANAGER_BTN);

        GestisciArticoliListeners gestisciArticoliListeners = new GestisciArticoliListeners(finestra);
        CrearePuntoVenditaListeners crearePuntoVenditaListeners = new CrearePuntoVenditaListeners(finestra);
        CreaManagerListeners creaManagerListeners = new CreaManagerListeners(finestra);

        gestioneArticoli.addActionListener(gestisciArticoliListeners);
        crearePuntoVendita.addActionListener(crearePuntoVenditaListeners);
        creaManager.addActionListener(creaManagerListeners);


        pulsanti.add(gestioneArticoli);
        pulsanti.add(crearePuntoVendita);
        pulsanti.add(creaManager);
        return pulsanti;
    }
}
