package Views;

import ActionListeners.ConfermaInserimentoFornitoreListeners;
import ActionListeners.ConfermaInserimentoProduttoriListeners;
import ActionListeners.InserisciFornitoreListeners;
import Views.Model.RigaInserisciFornitore;
import Views.TableModel.InserisciFornitoreTableModel;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserisciFornitorePanel extends JPanel {
    public InserisciFornitorePanel() {
        setLayout(new BorderLayout());
        List<RigaInserisciFornitore> righe = new ArrayList<>();

        RigaInserisciFornitore riga = new RigaInserisciFornitore();
        righe.add(riga);

        InserisciFornitoreTableModel tableModel = new InserisciFornitoreTableModel(righe);
        JTable tabellaFornitori = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabellaFornitori);
        add(scrollPane, BorderLayout.CENTER);
        tabellaFornitori.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton cIF = new JButton("Conferma inserimento");
        cIF.setActionCommand(ConfermaInserimentoFornitoreListeners.CIF_BTN);
        ConfermaInserimentoFornitoreListeners confermaInserimentoFornitoreListeners = new ConfermaInserimentoFornitoreListeners(tabellaFornitori);
        cIF.addActionListener(confermaInserimentoFornitoreListeners);
        pannelloAzioni.add(cIF);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }

}
