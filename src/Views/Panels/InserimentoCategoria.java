package Views.Panels;

import ActionListeners.ConfermaInserimentoCategoriaListener;
import Views.Model.CreazioneCategoriaModel;
import Views.TableModel.CreazioneCategoriaTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InserimentoCategoria extends JPanel {
    public InserimentoCategoria () {
        setLayout(new BorderLayout());
        List<CreazioneCategoriaModel> righe = new ArrayList<>();
        CreazioneCategoriaModel riga = new CreazioneCategoriaModel();
        righe.add(riga);

        CreazioneCategoriaTableModel tableModel = new CreazioneCategoriaTableModel(righe);
        JTable tabellaCategorie = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabellaCategorie);
        add(scrollPane, BorderLayout.CENTER);
        tabellaCategorie.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton cIC = new JButton("Conferma inserimento");
        cIC.setActionCommand(ConfermaInserimentoCategoriaListener.CIC_BTN);
        ConfermaInserimentoCategoriaListener confermaInserimentoCategoriaListener = new ConfermaInserimentoCategoriaListener(tabellaCategorie);
        cIC.addActionListener(confermaInserimentoCategoriaListener);
        pannelloAzioni.add(cIC);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
