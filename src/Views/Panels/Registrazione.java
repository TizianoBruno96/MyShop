package Views.Panels;

import ActionListeners.ConfermaRegistrazioneListener;
import Views.Model.RegistrazioneModel;
import Views.TableModel.RegistrazioneTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Registrazione extends JPanel {
    public Registrazione() {
        setLayout(new BorderLayout());
        List<RegistrazioneModel> righe = new ArrayList<>();


        RegistrazioneModel riga1 = new RegistrazioneModel();
        righe.add(riga1);


        RegistrazioneTableModel tableModel = new RegistrazioneTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);
        add(scrollPane, BorderLayout.CENTER);
        tabella.setRowHeight(20);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaRegistrazione = new JButton("Conferma registrazione");
        confermaRegistrazione.setActionCommand(ConfermaRegistrazioneListener.CONFERMAREGISTRAZIONE_BTN);
        ConfermaRegistrazioneListener confermaRegistrazioneListener = new ConfermaRegistrazioneListener(tabella);
        confermaRegistrazione.addActionListener(confermaRegistrazioneListener);
        pannelloAzioni.add(confermaRegistrazione);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
