package Views.Panels;

import ActionListeners.Admin.ConfermaInserimentoManagerListener;
import Views.Model.CreazioneManagerModel;
import Views.TableModel.CreazioneManagerTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreazioneManager extends JPanel {
    public CreazioneManager() {
        setLayout(new BorderLayout());
        List<CreazioneManagerModel> righe = new ArrayList<>();

        CreazioneManagerModel riga1 = new CreazioneManagerModel();
        righe.add(riga1);

        CreazioneManagerTableModel tableModel = new CreazioneManagerTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);
        add(scrollPane, BorderLayout.CENTER);
        tabella.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton inserisciManager = new JButton("Inserisci Manager");
        inserisciManager.setActionCommand(ConfermaInserimentoManagerListener.INSERISCIMANAGER_BTN);
        ConfermaInserimentoManagerListener confermaInserimentoManagerListener = new ConfermaInserimentoManagerListener(tabella);
        inserisciManager.addActionListener(confermaInserimentoManagerListener);
        pannelloAzioni.add(inserisciManager);
        add(pannelloAzioni, BorderLayout.SOUTH);


    }
}
