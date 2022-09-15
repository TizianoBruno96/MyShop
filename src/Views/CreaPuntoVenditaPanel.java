package Views;

import ActionListeners.InserisciPuntoVenditaListeners;
import Views.Model.RigaCreazionePuntoVendita;
import Views.TableModel.CreaPuntoVenditaTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreaPuntoVenditaPanel extends JPanel {
    public CreaPuntoVenditaPanel() {
        setLayout(new BorderLayout());
        List<RigaCreazionePuntoVendita> righe = new ArrayList<>();

        RigaCreazionePuntoVendita riga1 = new RigaCreazionePuntoVendita();
        righe.add(riga1);

        CreaPuntoVenditaTableModel tableModel = new CreaPuntoVenditaTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);
        add(scrollPane, BorderLayout.CENTER);
        tabella.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton inserisciPuntoVendita = new JButton("Inserisci Punto Vendita");
        inserisciPuntoVendita.setActionCommand(InserisciPuntoVenditaListeners.INSERISCIPUNTOVENDITA_BTN);
        InserisciPuntoVenditaListeners inserisciPuntoVenditaListeners = new InserisciPuntoVenditaListeners(tabella);
        inserisciPuntoVendita.addActionListener(inserisciPuntoVenditaListeners);
        pannelloAzioni.add(inserisciPuntoVendita);
        add(pannelloAzioni, BorderLayout.SOUTH);

    }
}
