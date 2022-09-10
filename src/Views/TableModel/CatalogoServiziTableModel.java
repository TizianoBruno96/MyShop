package Views.TableModel;

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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RigaCatalogoServizi riga = righe.get(rowIndex);
        switch (columnIndex){
            case 0 : return riga.getNomeServizio();
            case 1 : return riga.getCosto();
            case 2 : return riga.getCategoria();
            case 3 : return riga.getFornitore();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0 : return "Nome Servizio";
            case 1 : return "Costo(€)";
            case 2 : return "Categoria";
            case 3 : return "Fornitore";
        }
        return null;
    }

}
