package Views;

import ActionListeners.ConfermaInserimentoProduttoriListeners;
import Views.Model.RigaInserisciProduttore;
import Views.TableModel.InserisciProduttoreTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserisciProduttorePanel extends JPanel {
    public InserisciProduttorePanel() {
        setLayout(new BorderLayout());
        List<RigaInserisciProduttore> righe = new ArrayList<>();

        RigaInserisciProduttore riga = new RigaInserisciProduttore();
        righe.add(riga);


        InserisciProduttoreTableModel tmodel = new InserisciProduttoreTableModel(righe);
        JTable tabellaProduttore = new JTable(tmodel);
        JScrollPane scrollPane2 = new JScrollPane(tabellaProduttore);
        add(scrollPane2, BorderLayout.CENTER);
        tabellaProduttore.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaInserimentoProduttori = new JButton("Conferma inserimento");
        confermaInserimentoProduttori.setActionCommand(ConfermaInserimentoProduttoriListeners.CIPL_BTN);
        ConfermaInserimentoProduttoriListeners confermaInserimentoProduttoriListeners = new ConfermaInserimentoProduttoriListeners(tabellaProduttore);
        confermaInserimentoProduttori.addActionListener(confermaInserimentoProduttoriListeners);
        pannelloAzioni.add(confermaInserimentoProduttori);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
