package Views.Panels;

import ActionListeners.ConfermaInserimentoProdottoListener;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.PuntoVenditaDAO;
import Model.PuntoVendita;
import Views.Model.InserimentoProdottoModel;
import Views.TableModel.CreazioneProdottoTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserimentoProdotto extends JPanel {
    public InserimentoProdotto() {
        setLayout(new BorderLayout());
        List<InserimentoProdottoModel> righe1 = new ArrayList<>();

        InserimentoProdottoModel riga = new InserimentoProdottoModel();
        righe1.add(riga);

        IPuntoVenditaDAO puntoVenditaDAO = PuntoVenditaDAO.getInstance();
        PuntoVendita pv = puntoVenditaDAO.findByID(1);
        riga.setNomePuntoVendita(pv.getNome());


        CreazioneProdottoTableModel tableModel = new CreazioneProdottoTableModel(righe1);
        JTable tabellaProdotti = new JTable(tableModel);
        JScrollPane scrollPane1 = new JScrollPane(tabellaProdotti);
        add(scrollPane1, BorderLayout.CENTER);
        tabellaProdotti.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaInserimentoProdotto = new JButton("Conferma inserimento prodotto");
        confermaInserimentoProdotto.setActionCommand(ConfermaInserimentoProdottoListener.CIPL_BTN);
        ConfermaInserimentoProdottoListener confermaInserimentoProdottoListener = new ConfermaInserimentoProdottoListener(tabellaProdotti);
        confermaInserimentoProdotto.addActionListener(confermaInserimentoProdottoListener);
        pannelloAzioni.add(confermaInserimentoProdotto);

        add(pannelloAzioni, BorderLayout.SOUTH);


    }
}
