package Views.Panels;

import ActionListeners.Admin.ConfermaInserimentoPuntoVenditaListener;
import Views.Model.CreazionePuntoVenditaModel;
import Views.TableModel.CreazionePuntoVenditaTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreazionePuntoVendita extends JPanel {
    public CreazionePuntoVendita() {
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
        inserisciPuntoVendita.setActionCommand(ConfermaInserimentoPuntoVenditaListener.INSERISCIPUNTOVENDITA_BTN);
        ConfermaInserimentoPuntoVenditaListener confermaInserimentoPuntoVenditaListeners = new ConfermaInserimentoPuntoVenditaListener(tabella);
        inserisciPuntoVendita.addActionListener(confermaInserimentoPuntoVenditaListeners);
        pannelloAzioni.add(inserisciPuntoVendita);
        add(pannelloAzioni, BorderLayout.SOUTH);

    }
}
