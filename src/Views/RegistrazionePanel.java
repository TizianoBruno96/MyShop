package Views;

import ActionListeners.ConfermaRegistrazioneListeners;
import Views.Model.RigaRegistrazione;
import Views.TableModel.RegistrazioneTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrazionePanel extends JPanel {
    public RegistrazionePanel() {
        setLayout(new BorderLayout());
        List<RigaRegistrazione> righe = new ArrayList<>();


        RigaRegistrazione riga1 = new RigaRegistrazione();
        righe.add(riga1);


        RegistrazioneTableModel tableModel = new RegistrazioneTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);
        add(scrollPane, BorderLayout.CENTER);
        tabella.setRowHeight(20);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaRegistrazione = new JButton("Conferma registrazione");
        confermaRegistrazione.setActionCommand(ConfermaRegistrazioneListeners.CONFERMAREGISTRAZIONE_BTN);
        ConfermaRegistrazioneListeners confermaRegistrazioneListeners = new ConfermaRegistrazioneListeners(tabella);
        confermaRegistrazione.addActionListener(confermaRegistrazioneListeners);
        pannelloAzioni.add(confermaRegistrazione);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
