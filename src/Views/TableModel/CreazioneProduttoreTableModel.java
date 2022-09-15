package Views.TableModel;

import Views.Model.InserimentoProduttoreModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazioneProduttoreTableModel extends AbstractTableModel {
    private final List<InserimentoProduttoreModel> righe;

    public CreazioneProduttoreTableModel(List<InserimentoProduttoreModel> righe) {
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
        InserimentoProduttoreModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNomeProduttore();
            case 1 -> riga.getSito();
            case 2 -> riga.getCitta();
            case 3 -> riga.getNazione();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Nome Produttore";
            case 1 -> "Sito";
            case 2 -> "Città";
            case 3 -> "Nazione";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        InserimentoProduttoreModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNomeProduttore(value.toString());
            case 1:
                riga.setSito(value.toString());
            case 2:
                riga.setCitta(value.toString());
            case 3:
                riga.setNazione(value.toString());
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0;
    }


}
