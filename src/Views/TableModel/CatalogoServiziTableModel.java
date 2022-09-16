package Views.TableModel;

import Utilities.FloatExt;
import Utilities.IntegerExt;
import Views.AccessoUtente;
import Views.Model.CatalogoServiziModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CatalogoServiziTableModel extends AbstractTableModel {
    private final List<CatalogoServiziModel> righe;

    public CatalogoServiziTableModel(List<CatalogoServiziModel> intestazione) {
        this.righe = intestazione;
    }

    public List<CatalogoServiziModel> getRighe() {
        return righe;
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
        CatalogoServiziModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNomeServizio();
            case 1 -> riga.getCosto();
            case 2 -> riga.getCategoria();
            case 3 -> riga.getFornitore();
            case 4 -> riga.getIdServizio();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Nome Servizio";
            case 1 -> "Costo(€)";
            case 2 -> "Categoria";
            case 3 -> "Fornitore";
            case 4 -> "Id Servizio";
            default -> null;
        };
    }


    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CatalogoServiziModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNomeServizio(value.toString());
            case 1:
                if (FloatExt.isParsable(value.toString()))
                    riga.setCosto(Float.parseFloat(value.toString()));
            case 2:
                riga.setCategoria(value.toString());
            case 3:
                riga.setFornitore(value.toString());
            case 4:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setIdServizio(Integer.parseInt(value.toString()));
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return AccessoUtente.getTipo() != null && AccessoUtente.getTipo().equals("AM");
    }
}
