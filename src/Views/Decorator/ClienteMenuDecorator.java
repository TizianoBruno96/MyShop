package Views.Decorator;

import javax.swing.*;
import java.util.List;

public class ClienteMenuDecorator extends CustomMenuDecorator {
    public ClienteMenuDecorator(Menu menu) {
        this.menu = menu;
    }

    @Override
    public List<JButton> getPulsanti() {
        pulsanti.addAll(this.menu.getPulsanti());
        //aggiungo il pulsante con le funzione del cliente , per esempio la lista d'acquisto
        JButton listaAcquisto = new JButton("La mia lista d'acquisto");
        //scrivere l'actionlisteners

        pulsanti.add(listaAcquisto);
        return pulsanti;
    }
}
