package Views;

import Views.Model.RigaInserisciProdotto;
import Views.Model.RigaInserisciProduttore;
import Views.TableModel.CreaManagerTableModel;
import Views.TableModel.InserisciProdottoTableModel;
import Views.TableModel.InserisciProduttoreTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserisciProdottoPanel extends JPanel {
    public InserisciProdottoPanel() {
        setLayout(new BorderLayout());
        List<RigaInserisciProdotto> righe1 = new ArrayList<>();








        InserisciProdottoTableModel tableModel = new InserisciProdottoTableModel(righe1);
        JTable tabellaProdotti = new JTable(tableModel);
        JScrollPane scrollPane1 = new JScrollPane(tabellaProdotti);
        add(scrollPane1,BorderLayout.CENTER);
        tabellaProdotti.setRowHeight(50);


    }
}
