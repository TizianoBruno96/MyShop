package Views.Panels;

import ActionListeners.ConfermaInserimentoProduttoriListener;
import Views.Model.CreazioneProduttoreModel;
import Views.TableModel.CreazioneProduttoreTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreazioneProduttore extends JPanel {
    public CreazioneProduttore() {
        setLayout(new BorderLayout());
        List<CreazioneProduttoreModel> righe = new ArrayList<>();

        CreazioneProduttoreModel riga = new CreazioneProduttoreModel();
        righe.add(riga);


        CreazioneProduttoreTableModel tmodel = new CreazioneProduttoreTableModel(righe);
        JTable tabellaProduttore = new JTable(tmodel);
        JScrollPane scrollPane2 = new JScrollPane(tabellaProduttore);
        add(scrollPane2, BorderLayout.CENTER);
        tabellaProduttore.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaInserimentoProduttori = new JButton("Conferma inserimento");
        confermaInserimentoProduttori.setActionCommand(ConfermaInserimentoProduttoriListener.CIPL_BTN);
        ConfermaInserimentoProduttoriListener confermaInserimentoProduttoriListener = new ConfermaInserimentoProduttoriListener(tabellaProduttore);
        confermaInserimentoProduttori.addActionListener(confermaInserimentoProduttoriListener);
        pannelloAzioni.add(confermaInserimentoProduttori);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
