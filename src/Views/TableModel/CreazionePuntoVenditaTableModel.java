package Views.TableModel;

import Views.Model.CreazionePuntoVenditaModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazionePuntoVenditaTableModel extends AbstractTableModel {
    private List<CreazionePuntoVenditaModel> righe;

    public CreazionePuntoVenditaTableModel(List<CreazionePuntoVenditaModel> righe) {
        this.righe = righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CreazionePuntoVenditaModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getCitta();
            case 1 -> riga.getNome();
            case 2 -> riga.getIndirizzo();
            case 3 -> riga.getUsernameManager();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Città";
            case 1 -> "Nome";
            case 2 -> "Indirizzo";
            case 3 -> "Username Manager";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CreazionePuntoVenditaModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setCitta(value.toString());
            case 1:
                riga.setNome(value.toString());
            case 2:
                riga.setIndirizzo(value.toString());
            case 3:
                riga.setUsernameManager(value.toString());
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0;
    }

}
