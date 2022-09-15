package Views.TableModel;

import Utilities.IntegerExt;
import Views.Model.RigaCatalogoServizi;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CatalogoServiziTableModel extends AbstractTableModel {
    private List<RigaCatalogoServizi> righe = new ArrayList<>();

    public CatalogoServiziTableModel(List<RigaCatalogoServizi> intestazione) {
        this.righe = intestazione;
    }

    public List<RigaCatalogoServizi> getRighe() {
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
        RigaCatalogoServizi riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return riga.getNomeServizio();
            case 1:
                return riga.getCosto();
            case 2:
                return riga.getCategoria();
            case 3:
                return riga.getFornitore();
            case 4:
                return riga.getIdServizio();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nome Servizio";
            case 1:
                return "Costo(€)";
            case 2:
                return "Categoria";
            case 3:
                return "Fornitore";
            case 4:
                return "Id Servizio";
        }
        return null;
    }


    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        RigaCatalogoServizi riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNomeServizio(value.toString());
            case 1:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setCosto(Integer.parseInt(value.toString()));
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
        return columnIndex >= 0;
    }

}
