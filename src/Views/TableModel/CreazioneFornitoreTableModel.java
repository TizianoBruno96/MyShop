package Views.TableModel;

import Views.Model.InserimentoFornitoreModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazioneFornitoreTableModel extends AbstractTableModel {
    private List<InserimentoFornitoreModel> righe;

    public CreazioneFornitoreTableModel(List<InserimentoFornitoreModel> righe) {
        this.righe = righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InserimentoFornitoreModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNome();
            case 1 -> riga.getSito();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Nome Fornitore";
            case 1 -> "Sito";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        InserimentoFornitoreModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNome(value.toString());
            case 1:
                riga.setSito(value.toString());

        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0;
    }


}
