package Views.Panels;

import ActionListeners.ConfermaInserimentoProduttoriListener;
import Views.Model.InserimentoProduttoreModel;
import Views.TableModel.CreazioneProduttoreTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserimentoProduttore extends JPanel {
    public InserimentoProduttore() {
        setLayout(new BorderLayout());
        List<InserimentoProduttoreModel> righe = new ArrayList<>();

        InserimentoProduttoreModel riga = new InserimentoProduttoreModel();
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
