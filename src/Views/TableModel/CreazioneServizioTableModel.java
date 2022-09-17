package Views.TableModel;

import Utilities.FloatExt;
import Views.Model.CreazioneServizioModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazioneServizioTableModel extends AbstractTableModel {
    private final List<CreazioneServizioModel> righe;

    public CreazioneServizioTableModel(List<CreazioneServizioModel> righe) {
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
        CreazioneServizioModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNome();
            case 1 -> riga.getCosto();
            case 2 -> riga.getNomeFornitore();
            case 3 -> riga.getNomeCategoria();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Nome Servizio";
            case 1 -> "Costo";
            case 2 -> "Nome Fornitore";
            case 3 -> "Nome Categoria";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CreazioneServizioModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0 -> riga.setNome(value.toString());
            case 1 -> {
                if (FloatExt.isParsable(value.toString()))
                    riga.setCosto(Float.parseFloat(value.toString()));
            }
            case 2 -> riga.setNomeFornitore(value.toString());
            case 3 -> riga.setNomeCategoria(value.toString());
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
