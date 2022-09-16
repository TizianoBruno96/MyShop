package Views.Panels;

import ActionListeners.ConfermaInserimentoProdottoListener;
import ActionListeners.InserisciFotoListener;
import DAO.Interfaces.IPuntoVenditaDAO;
import DAO.PuntoVenditaDAO;
import Model.PuntoVendita;
import Views.Model.InserimentoProdottoModel;
import Views.TableModel.CreazioneProdottoTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InserimentoProdotto extends JPanel {
    public InserimentoProdotto() {
        setLayout(new BorderLayout());
        List<InserimentoProdottoModel> righe1 = new ArrayList<>();

        InserimentoProdottoModel riga = new InserimentoProdottoModel();
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
        aggiungiFoto.setActionCommand(InserisciFotoListener.INFO_BTN);
        InserisciFotoListener inserisciFotoListener = new InserisciFotoListener(tabellaProdotti, fileChooser);
        aggiungiFoto.addActionListener(inserisciFotoListener);
        pannelloAzioni.add(aggiungiFoto);

        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
