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
        JButton creaCategoria = new JButton("Crea Categoria");

        inserisciProdotto.setActionCommand(InserisciProdottoListener.INSERISCIPRODOTTO_BTN);
        inserisciProduttore.setActionCommand(InserisciProduttoreListener.INSERISCIPRODUTTORE_BTN);
        crearePuntoVendita.setActionCommand(CrearePuntoVenditaListeners.CREAPUNTOVENDITA_BTN);
        creaManager.setActionCommand(CreaManagerListeners.CREAMANAGER_BTN);
        inserisciFornitore.setActionCommand(InserisciFornitoreListener.IF_BTN);
        creaCategoria.setActionCommand(InserisciCategoriaListener.IC_BTN);

        InserisciProdottoListener inserisciProdottoListener = new InserisciProdottoListener(finestra);
        InserisciProduttoreListener inserisciProduttoreListener = new InserisciProduttoreListener(finestra);
        CrearePuntoVenditaListeners crearePuntoVenditaListeners = new CrearePuntoVenditaListeners(finestra);
        CreaManagerListeners creaManagerListeners = new CreaManagerListeners(finestra);
        InserisciFornitoreListener inserisciFornitoreListener = new InserisciFornitoreListener(finestra);
        InserisciCategoriaListener inserisciCategoriaListener = new InserisciCategoriaListener(finestra);

        inserisciProdotto.addActionListener(inserisciProdottoListener);
        inserisciProduttore.addActionListener(inserisciProduttoreListener);
        crearePuntoVendita.addActionListener(crearePuntoVenditaListeners);
        creaManager.addActionListener(creaManagerListeners);
        inserisciFornitore.addActionListener(inserisciFornitoreListener);
        creaCategoria.addActionListener(inserisciCategoriaListener);

        pulsanti.add(inserisciFornitore);
        pulsanti.add(inserisciProdotto);
        pulsanti.add(inserisciProduttore);
        pulsanti.add(crearePuntoVendita);
        pulsanti.add(creaManager);
        pulsanti.add(creaCategoria);
        return pulsanti;
    }
}
