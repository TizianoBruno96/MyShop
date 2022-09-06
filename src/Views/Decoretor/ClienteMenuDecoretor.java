package Views.Decoretor;

import javax.swing.*;
import java.util.List;

public class ClienteMenuDecoretor extends CustomMenuDecoretor{
    public ClienteMenuDecoretor(Menu menu) {
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
