package ActionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserimentoListaListeners implements ActionListener {
    public static final String INSERISCINELLALISTA_BTN = "Inseiscinellalista_btn";
    private final JTable tabella;

    public InserimentoListaListeners(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INSERISCINELLALISTA_BTN.equals(azione)) {
            //InserimentoListaBusiness l = InserimentoListaBusiness.getInstance().InserisciLista(idProdotto,idListaAcquisto,quantita);

        }
    }
}
