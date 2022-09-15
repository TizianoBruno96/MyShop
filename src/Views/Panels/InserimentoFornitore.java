package Views.Panels;

import ActionListeners.ConfermaInserimentoFornitoreListener;
import Views.Model.InserimentoFornitoreModel;
import Views.TableModel.CreazioneFornitoreTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserimentoFornitore extends JPanel {
    public InserimentoFornitore() {
        setLayout(new BorderLayout());
        List<InserimentoFornitoreModel> righe = new ArrayList<>();

        InserimentoFornitoreModel riga = new InserimentoFornitoreModel();
        righe.add(riga);

        CreazioneFornitoreTableModel tableModel = new CreazioneFornitoreTableModel(righe);
        JTable tabellaFornitori = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabellaFornitori);
        add(scrollPane, BorderLayout.CENTER);
        tabellaFornitori.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton cIF = new JButton("Conferma inserimento");
        cIF.setActionCommand(ConfermaInserimentoFornitoreListener.CIF_BTN);
        ConfermaInserimentoFornitoreListener confermaInserimentoFornitoreListener = new ConfermaInserimentoFornitoreListener(tabellaFornitori);
        cIF.addActionListener(confermaInserimentoFornitoreListener);
        pannelloAzioni.add(cIF);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
