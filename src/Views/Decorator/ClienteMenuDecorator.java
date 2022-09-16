package Views.Decorator;

import Views.FinestraPrincipale;

import javax.swing.*;
import java.util.List;

public class ClienteMenuDecorator extends CustomMenuDecorator {
    private final FinestraPrincipale finestra;

    public ClienteMenuDecorator(Menu menu, FinestraPrincipale finestra) {
        this.menu = menu;
        this.finestra = finestra;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        //aggiungo i pulsanti con le funzioni del cliente
        JButton lasciaFeedback = new JButton("Lasciare feedback");


        pulsanti.add(lasciaFeedback);

        return pulsanti;
    }
}
