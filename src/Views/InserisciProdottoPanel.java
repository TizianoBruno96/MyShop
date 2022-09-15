package Views;

import Views.Model.RigaInserisciProdotto;
import Views.TableModel.InserisciProdottoTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserisciProdottoPanel extends JPanel {
    public InserisciProdottoPanel() {
        setLayout(new BorderLayout());
        List<RigaInserisciProdotto> righe1 = new ArrayList<>();

        RigaInserisciProdotto riga = new RigaInserisciProdotto();
        righe1.add(riga);


        InserisciProdottoTableModel tableModel = new InserisciProdottoTableModel(righe1);
        JTable tabellaProdotti = new JTable(tableModel);
        JScrollPane scrollPane1 = new JScrollPane(tabellaProdotti);
        add(scrollPane1, BorderLayout.CENTER);
        tabellaProdotti.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        //JButton confermaInserimentoProduttori = new JButton("Conferma inserimento");
        //confermaInserimentoProduttori.setActionCommand(ConfermaInserimentoProduttoriListeners.CIPL_BTN);
        //ConfermaInserimentoProduttoriListeners confermaInserimentoProduttoriListeners = new ConfermaInserimentoProduttoriListeners(tabellaProduttore);
        // confermaInserimentoProduttori.addActionListener(confermaInserimentoProduttoriListeners);
        //pannelloAzioni.add(confermaInserimentoProduttori);
        JButton confermaInserimentoProdotto = new JButton("Conferma inserimento prodotto");
        add(pannelloAzioni, BorderLayout.SOUTH);


    }
}
