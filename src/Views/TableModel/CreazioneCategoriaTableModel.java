package Views.TableModel;

import Views.AccessoUtente;
import Views.Model.CreazioneCategoriaModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazioneCategoriaTableModel extends AbstractTableModel {
    private final List<CreazioneCategoriaModel> righe;

    public CreazioneCategoriaTableModel(List<CreazioneCategoriaModel> righe) {
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
        CreazioneCategoriaModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNome();
            case 1 -> riga.getNomeCategoriaPadre();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Nome";
            case 1 -> "Nome Categoria Padre";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CreazioneCategoriaModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0 -> riga.setNome(value.toString());
            case 1 -> riga.setNomeCategoriaPadre(value.toString());
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return AccessoUtente.getTipo().equals("AM");
    }
}
