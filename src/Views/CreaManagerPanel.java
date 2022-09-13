package Views;

import ActionListeners.ConfermaRegistrazioneListeners;
import ActionListeners.InserisciManagerListeners;
import Views.Model.RigaCreazioneManager;
import Views.Model.RigaRegistrazione;
import Views.TableModel.CatalogoProdottiTableModel;
import Views.TableModel.CreaManagerTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreaManagerPanel extends JPanel {
    public CreaManagerPanel() {
        setLayout(new BorderLayout());
        List<RigaCreazioneManager> righe = new ArrayList<>();

        RigaCreazioneManager riga1 = new RigaCreazioneManager();
        righe.add(riga1);

        CreaManagerTableModel tableModel = new CreaManagerTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);
        add(scrollPane,BorderLayout.CENTER);
        tabella.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton inserisciManager = new JButton("Inserisci Manager");
        inserisciManager.setActionCommand(InserisciManagerListeners.INSERISCIMANAGER_BTN);
        InserisciManagerListeners inserisciManagerListeners = new InserisciManagerListeners(tabella);
        inserisciManager.addActionListener(inserisciManagerListeners);
        pannelloAzioni.add(inserisciManager);
        add(pannelloAzioni,BorderLayout.SOUTH);


    }
}
