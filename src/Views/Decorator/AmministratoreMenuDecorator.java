package Views.Decorator;

import ActionListeners.*;
import Views.FinestraPrincipale;

import javax.swing.*;
import java.util.List;

public class AmministratoreMenuDecorator extends CustomMenuDecorator {
    private final FinestraPrincipale finestra;

    public AmministratoreMenuDecorator(Menu menu, FinestraPrincipale frame) {
        this.menu = menu;
        this.finestra = frame;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        JButton creaProdotto = new JButton("Crea Prodotto");
        JButton creaProduttore = new JButton("Crea Produttore");
        JButton creaFornitore = new JButton("Crea Fornitore");
        JButton crearePuntoVendita = new JButton("Crea punto vendita");
        JButton creaManager = new JButton("Crea Manager");
        JButton creaCategoria = new JButton("Crea Categoria");
        JButton creaServizio = new JButton("Crea Servizio");

        creaProdotto.setActionCommand(CreazioneProdottoListener.INSERISCIPRODOTTO_BTN);
        creaProduttore.setActionCommand(CreazioneProduttoreListener.INSERISCIPRODUTTORE_BTN);
        crearePuntoVendita.setActionCommand(CreazionePuntoVenditaListeners.CREAPUNTOVENDITA_BTN);
        creaManager.setActionCommand(CreazioneManagerListener.CREAMANAGER_BTN);
        creaFornitore.setActionCommand(CreazioneFornitoreListener.IF_BTN);
        creaCategoria.setActionCommand(CreazioneCategoriaListener.IC_BTN);
        creaServizio.setActionCommand(CreazioneServizioListener.CSL_BTN);

        CreazioneProdottoListener creazioneProdottoListener = new CreazioneProdottoListener(finestra);
        CreazioneProduttoreListener creazioneProduttoreListener = new CreazioneProduttoreListener(finestra);
        CreazionePuntoVenditaListeners creazionePuntoVenditaListeners = new CreazionePuntoVenditaListeners(finestra);
        CreazioneManagerListener creaManagerListeners = new CreazioneManagerListener(finestra);
        CreazioneFornitoreListener creazioneFornitoreListener = new CreazioneFornitoreListener(finestra);
        CreazioneCategoriaListener creazioneCategoriaListener = new CreazioneCategoriaListener(finestra);
        CreazioneServizioListener creazioneServizioListener = new CreazioneServizioListener(finestra);

        creaProdotto.addActionListener(creazioneProdottoListener);
        creaProduttore.addActionListener(creazioneProduttoreListener);
        crearePuntoVendita.addActionListener(creazionePuntoVenditaListeners);
        creaManager.addActionListener(creaManagerListeners);
        creaFornitore.addActionListener(creazioneFornitoreListener);
        creaCategoria.addActionListener(creazioneCategoriaListener);
        creaServizio.addActionListener(creazioneServizioListener);

        pulsanti.add(creaManager);
        pulsanti.add(crearePuntoVendita);
        pulsanti.add(creaProdotto);
        pulsanti.add(creaServizio);
        pulsanti.add(creaProduttore);
        pulsanti.add(creaFornitore);
        pulsanti.add(creaCategoria);
        return pulsanti;
    }
}
