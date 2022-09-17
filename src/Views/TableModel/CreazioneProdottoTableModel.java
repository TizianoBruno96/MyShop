package Views.TableModel;

import Utilities.FloatExt;
import Views.AccessoUtente;
import Views.Model.CreazioneProdottoModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazioneProdottoTableModel extends AbstractTableModel {
    private final List<CreazioneProdottoModel> righe;

    public CreazioneProdottoTableModel(List<CreazioneProdottoModel> righe) {
        this.righe = righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CreazioneProdottoModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNomeProdotto();
            case 1 -> riga.getDescrizione();
            case 2 -> riga.getCosto();
            case 3 -> riga.getNomeProduttore();
            case 4 -> riga.getCategoriaProdotto();
            case 5 -> riga.getFotoPath();
            case 6 -> riga.getNomeFoto();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Nome Prodotto";
            case 1 -> "Descrizione";
            case 2 -> "Costo";
            case 3 -> "Nome Produttore";
            case 4 -> "Categoria";
            case 5 -> "Path della Foto";
            case 6 -> "Nome della Foto";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CreazioneProdottoModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNomeProdotto(value.toString());
            case 1:
                riga.setDescrizione(value.toString());
            case 2:
                if (FloatExt.isParsable(value.toString()))
                    riga.setCosto(Float.parseFloat(value.toString()));
            case 3:
                riga.setNomeProduttore(value.toString());
            case 4:
                riga.setCategoriaProdotto(value.toString());
            case 5:
                riga.setFotoPath(value.toString());
            case 6:
                riga.setNomeFoto(value.toString());
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 5 || AccessoUtente.getTipo().equals("AM");
    }
}
