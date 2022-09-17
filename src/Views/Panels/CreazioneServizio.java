package Views.Panels;

import ActionListeners.Admin.ConfermaInserimentoServizioListener;
import Views.Model.CreazioneServizioModel;
import Views.TableModel.CreazioneServizioTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreazioneServizio extends JPanel {
    public CreazioneServizio() {
        setLayout(new BorderLayout());
        List<CreazioneServizioModel> righe1 = new ArrayList<>();

        CreazioneServizioModel riga = new CreazioneServizioModel();
        righe1.add(riga);

        CreazioneServizioTableModel tableModel = new CreazioneServizioTableModel(righe1);
        JTable tabellaServizi = new JTable(tableModel);
        JScrollPane scrollPane1 = new JScrollPane(tabellaServizi);
        add(scrollPane1, BorderLayout.CENTER);
        tabellaServizi.setRowHeight(50);

        //pannello di conferma inserimento servizio
        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton confermaInserimentoServizio = new JButton("Conferma inserimento servizio");
        confermaInserimentoServizio.setActionCommand(ConfermaInserimentoServizioListener.CISL_BTN);
        ConfermaInserimentoServizioListener confermaInserimentoServizioListener = new ConfermaInserimentoServizioListener(tabellaServizi);
        confermaInserimentoServizio.addActionListener(confermaInserimentoServizioListener);
        pannelloAzioni.add(confermaInserimentoServizio);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
