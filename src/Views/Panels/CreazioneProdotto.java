package Views.Panels;

import ActionListeners.Admin.ConfermaInserimentoProdottoListener;
import ActionListeners.Admin.CreazioneFotoListener;
import Views.Model.CreazioneProdottoModel;
import Views.TableModel.CreazioneProdottoTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreazioneProdotto extends JPanel {
    public CreazioneProdotto() {
        setLayout(new BorderLayout());
        List<CreazioneProdottoModel> righe1 = new ArrayList<>();

        CreazioneProdottoModel riga = new CreazioneProdottoModel();
        righe1.add(riga);

        CreazioneProdottoTableModel tableModel = new CreazioneProdottoTableModel(righe1);
        JTable tabellaProdotti = new JTable(tableModel);
        JScrollPane scrollPane1 = new JScrollPane(tabellaProdotti);
        add(scrollPane1, BorderLayout.CENTER);
        tabellaProdotti.setRowHeight(50);

        //pannello di conferma inserimento prodotto
        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaInserimentoProdotto = new JButton("Conferma inserimento prodotto");
        confermaInserimentoProdotto.setActionCommand(ConfermaInserimentoProdottoListener.CIPL_BTN);
        ConfermaInserimentoProdottoListener confermaInserimentoProdottoListener = new ConfermaInserimentoProdottoListener(tabellaProdotti);
        confermaInserimentoProdotto.addActionListener(confermaInserimentoProdottoListener);
        pannelloAzioni.add(confermaInserimentoProdotto);

        //pannello di inserimento foto
        JFileChooser fileChooser = new JFileChooser();
        JButton aggiungiFoto = new JButton("Aggiungi foto");
        aggiungiFoto.setActionCommand(CreazioneFotoListener.INFO_BTN);
        CreazioneFotoListener creazioneFotoListener = new CreazioneFotoListener(tabellaProdotti, fileChooser);
        aggiungiFoto.addActionListener(creazioneFotoListener);
        pannelloAzioni.add(aggiungiFoto);

        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
