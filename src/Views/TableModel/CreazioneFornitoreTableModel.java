package Views.TableModel;

import Views.AccessoUtente;
import Views.Model.CreazioneFornitoreModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazioneFornitoreTableModel extends AbstractTableModel {
    private final List<CreazioneFornitoreModel> righe;

    public CreazioneFornitoreTableModel(List<CreazioneFornitoreModel> righe) {
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
        CreazioneFornitoreModel riga = righe.get(rowIndex);
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
        CreazioneFornitoreModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNome(value.toString());
            case 1:
                riga.setSito(value.toString());

        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return AccessoUtente.getTipo().equals("AM");
    }
}
