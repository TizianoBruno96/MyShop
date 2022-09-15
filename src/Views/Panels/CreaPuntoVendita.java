package Views.Panels;

import ActionListeners.InserisciPuntoVenditaListener;
import Views.Model.CreazionePuntoVenditaModel;
import Views.TableModel.CreazionePuntoVenditaTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreaPuntoVendita extends JPanel {
    public CreaPuntoVendita() {
        setLayout(new BorderLayout());
        List<CreazionePuntoVenditaModel> righe = new ArrayList<>();

        CreazionePuntoVenditaModel riga1 = new CreazionePuntoVenditaModel();
        righe.add(riga1);

        CreazionePuntoVenditaTableModel tableModel = new CreazionePuntoVenditaTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);
        add(scrollPane, BorderLayout.CENTER);
        tabella.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton inserisciPuntoVendita = new JButton("Inserisci Punto Vendita");
        inserisciPuntoVendita.setActionCommand(InserisciPuntoVenditaListener.INSERISCIPUNTOVENDITA_BTN);
        InserisciPuntoVenditaListener inserisciPuntoVenditaListeners = new InserisciPuntoVenditaListener(tabella);
        inserisciPuntoVendita.addActionListener(inserisciPuntoVenditaListeners);
        pannelloAzioni.add(inserisciPuntoVendita);
        add(pannelloAzioni, BorderLayout.SOUTH);

    }
}
