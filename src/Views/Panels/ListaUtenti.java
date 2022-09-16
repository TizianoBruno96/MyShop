package Views.Panels;

import ActionListeners.ConfermaRimozioneListener;
import ActionListeners.EliminazioneUtenteListener;
import DAO.Interfaces.IUtenteDAO;
import DAO.Interfaces.IUtenteRegistratoDAO;
import DAO.UtenteDAO;
import DAO.UtenteRegistratoDAO;
import Model.Utenti.Utente;
import Model.Utenti.UtenteRegistrato;
import Views.AccessoUtente;
import Views.Model.ListaUtentiModel;
import Views.TableModel.ListaUtentiTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListaUtenti extends JPanel {
    IUtenteDAO utenteDAO = UtenteDAO.getInstance();
    IUtenteRegistratoDAO utenteRegistratoDAO = UtenteRegistratoDAO.getInstance();

    public ListaUtenti() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        List<ListaUtentiModel> righe = new ArrayList<>();
        List<UtenteRegistrato> utentiRegistrati = utenteRegistratoDAO.findByPuntoVendita(AccessoUtente.getIdPuntoVendita());

        for (UtenteRegistrato utenteRegistrato : utentiRegistrati) {
            Utente utente = utenteDAO.findByID(utenteRegistrato.getIdUtente());
            if(utenteRegistrato.getIdUtente() != AccessoUtente.getIdUtente()) {
                ListaUtentiModel riga = new ListaUtentiModel();

                riga.setIdUtente(utenteRegistrato.getIdUtente());
                riga.setNome(utente.getNome());
                riga.setCognome(utente.getCognome());
                riga.setEta(utente.getEta());
                riga.setEmail(utente.getEmail());
                riga.setProfessione(utente.getProfessione());
                riga.setResidenza(utente.getResidenza());
                riga.setUsername(utente.getUsername());
                riga.setTelefono(utente.getTelefono());

                righe.add(riga);
            }
        }

        ListaUtentiTableModel model = new ListaUtentiTableModel(righe);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        table.setRowHeight(50);

        //inserisco un pulsante per eliminare l'utente selezionato
        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton eliminaUtente = new JButton("Elimina utente");
        eliminaUtente.setActionCommand(EliminazioneUtenteListener.EUL_BTN);
        EliminazioneUtenteListener eliminazioneUtenteListener = new EliminazioneUtenteListener(table);
        eliminaUtente.addActionListener(eliminazioneUtenteListener);
        pannelloAzioni.add(eliminaUtente);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
