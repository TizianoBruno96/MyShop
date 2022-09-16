package Views.TableModel;

import Utilities.IntegerExt;
import Views.Model.RecensioniModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RecensioniTableModel extends AbstractTableModel {
    private final List<RecensioniModel> righe;

    public RecensioniTableModel(List<RecensioniModel> righe) {
        this.righe = righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RecensioniModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getIdRecensione();
            case 1 -> riga.getRecensione();
            case 2 -> riga.getVoto();
            case 3 -> riga.getUsernameUtente();
            case 4 -> riga.getData();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "ID Recensione";
            case 1 -> "Recensione";
            case 2 -> "Voto";
            case 3 -> "Utente";
            case 4 -> "Data";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        RecensioniModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                if (IntegerExt.isParsable(value.toString())) {
                    riga.setIdRecensione(Integer.parseInt(value.toString()));
                }
            }
            case 1 -> riga.setRecensione(value.toString());
            case 2 -> {
                if (IntegerExt.isParsable(value.toString())) {
                    riga.setVoto(Integer.parseInt(value.toString()));
                }
            }
            case 3 -> riga.setUsernameUtente(value.toString());
            case 4 -> riga.setData(value.toString());
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
