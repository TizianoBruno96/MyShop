package Views.Decorator;

import ActionListeners.*;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.util.List;

public class AmministratoreMenuDecorator extends CustomMenuDecorator {
    private FinestraPrincipale finestra;

    public AmministratoreMenuDecorator(Menu menu, FinestraPrincipale frame) {
        this.menu = menu;
        this.finestra = frame;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        JButton inserisciProdotto = new JButton("Inserisci Prodotto");
        JButton inserisciProduttore = new JButton("Inserisci Produttore");
        JButton inserisciFornitore = new JButton("Inserisci Fornitore");
        JButton crearePuntoVendita = new JButton("Crea punto vendita");
        JButton creaManager = new JButton("Crea Manager");


        inserisciProdotto.setActionCommand(InserisciProdottoListeners.INSERISCIPRODOTTO_BTN);
        inserisciProduttore.setActionCommand(InserisciProduttoreListeners.INSERISCIPRODUTTORE_BTN);
        crearePuntoVendita.setActionCommand(CrearePuntoVenditaListeners.CREAPUNTOVENDITA_BTN);
        creaManager.setActionCommand(CreaManagerListeners.CREAMANAGER_BTN);
        inserisciFornitore.setActionCommand(InserisciFornitoreListeners.IF_BTN);

        InserisciProdottoListeners inserisciProdottoListeners = new InserisciProdottoListeners(finestra);
        InserisciProduttoreListeners inserisciProduttoreListeners = new InserisciProduttoreListeners(finestra);
        CrearePuntoVenditaListeners crearePuntoVenditaListeners = new CrearePuntoVenditaListeners(finestra);
        CreaManagerListeners creaManagerListeners = new CreaManagerListeners(finestra);
        InserisciFornitoreListeners inserisciFornitoreListeners = new InserisciFornitoreListeners(finestra);

        inserisciProdotto.addActionListener(inserisciProdottoListeners);
        inserisciProduttore.addActionListener(inserisciProduttoreListeners);
        crearePuntoVendita.addActionListener(crearePuntoVenditaListeners);
        creaManager.addActionListener(creaManagerListeners);
        inserisciFornitore.addActionListener(inserisciFornitoreListeners);


        pulsanti.add(inserisciFornitore);
        pulsanti.add(inserisciProdotto);
        pulsanti.add(inserisciProduttore);
        pulsanti.add(crearePuntoVendita);
        pulsanti.add(creaManager);
        return pulsanti;
    }
}
