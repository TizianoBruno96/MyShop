package Views;

import ActionListeners.ConfermaInserimentoProdottoListeners;
import ActionListeners.ConfermaInserimentoProduttoriListeners;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.PuntoVenditaDAO;
import Model.PuntoVendita;
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

       IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
        PuntoVendita pv = puntoVenditaDAO.findByID(1);
        riga.setNomePuntoVendita(pv.getNome());



        InserisciProdottoTableModel tableModel = new InserisciProdottoTableModel(righe1);
        JTable tabellaProdotti = new JTable(tableModel);
        JScrollPane scrollPane1 = new JScrollPane(tabellaProdotti);
        add(scrollPane1, BorderLayout.CENTER);
        tabellaProdotti.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaInserimentoProdotto = new JButton("Conferma inserimento prodotto");
        confermaInserimentoProdotto.setActionCommand(ConfermaInserimentoProdottoListeners.CIPL_BTN);
        ConfermaInserimentoProdottoListeners confermaInserimentoProdottoListeners = new ConfermaInserimentoProdottoListeners(tabellaProdotti);
        confermaInserimentoProdotto.addActionListener(confermaInserimentoProdottoListeners);
        pannelloAzioni.add(confermaInserimentoProdotto);

        add(pannelloAzioni, BorderLayout.SOUTH);


    }
}
