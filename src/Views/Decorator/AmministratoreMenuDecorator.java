package Views.Decorator;

import ActionListeners.CrearePuntoVenditaListeners;
import ActionListeners.GestisciArticoliListeners;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.util.List;

public class AmministratoreMenuDecorator extends CustomMenuDecorator{
    private FinestraPrincipale finestra;

    public AmministratoreMenuDecorator(Menu menu, FinestraPrincipale frame) {
        this.menu = menu;
        this.finestra = finestra;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        JButton gestioneArticoli = new JButton("Gestisci articoli");
        JButton crearePuntoVendita = new JButton("Crea punto vendita");

        gestioneArticoli.setActionCommand(GestisciArticoliListeners.GESTISCIARTICOLI_BTN);
        crearePuntoVendita.setActionCommand(CrearePuntoVenditaListeners.CREAPUNTOVENDITA_BTN);

        GestisciArticoliListeners gestisciArticoliListeners = new GestisciArticoliListeners(finestra);
        CrearePuntoVenditaListeners crearePuntoVenditaListeners = new CrearePuntoVenditaListeners(finestra);

        gestioneArticoli.addActionListener(gestisciArticoliListeners);
        crearePuntoVendita.addActionListener(crearePuntoVenditaListeners);


        pulsanti.add(gestioneArticoli);
        pulsanti.add(crearePuntoVendita);
        return pulsanti;
    }
}
