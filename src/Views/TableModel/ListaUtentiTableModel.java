package Views.TableModel;

import Utilities.IntegerExt;
import Views.Model.ListaUtentiModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ListaUtentiTableModel extends AbstractTableModel {
    private final List<ListaUtentiModel> righe;

    public ListaUtentiTableModel(List<ListaUtentiModel> righe) {
        this.righe = righe;
    }

    public List<ListaUtentiModel> getRighe() {
        return righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ListaUtentiModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getIdUtente();
            case 1 -> riga.getNome();
            case 2 -> riga.getCognome();
            case 3 -> riga.getUsername();
            case 4 -> riga.getEmail();
            case 5 -> riga.getTelefono();
            case 6 -> riga.getEta();
            case 7 -> riga.getResidenza();
            case 8 -> riga.getProfessione();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Id Utente";
            case 1 -> "Nome";
            case 2 -> "Cognome";
            case 3 -> "Username";
            case 4 -> "Email";
            case 5 -> "Telefono";
            case 6 -> "Età";
            case 7 -> "Residenza";
            case 8 -> "Professione";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        ListaUtentiModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setIdUtente(Integer.parseInt(value.toString()));
            }
            case 1 -> riga.setNome((String) value);
            case 2 -> riga.setCognome((String) value);
            case 3 -> riga.setUsername((String) value);
            case 4 -> riga.setEmail((String) value);
            case 5 -> riga.setTelefono((String) value);
            case 6 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setEta(Integer.parseInt(value.toString()));
            }
            case 7 -> riga.setResidenza((String) value);
            case 8 -> riga.setProfessione((String) value);
        }
    }
}
