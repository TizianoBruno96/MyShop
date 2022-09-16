package Views.TableModel;

import Utilities.FloatExt;
import Utilities.IntegerExt;
import Views.Model.CarrelloProdottiModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CarrelloProdottiTableModel extends AbstractTableModel {
    private final List<CarrelloProdottiModel> righe;

    public CarrelloProdottiTableModel(List<CarrelloProdottiModel> righe) {
        this.righe = righe;
    }

    public List<CarrelloProdottiModel> getRighe() {
        return righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CarrelloProdottiModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getIdProdotto();
            case 1 -> riga.getNomeProdotto();
            case 2 -> riga.getDescrizione();
            case 3 -> riga.getCosto();
            case 4 -> riga.getNomeProduttore();
            case 5 -> riga.getNomeCategoria();
            case 6 -> riga.getQuantita();
            case 7 -> riga.getFoto();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Id Prodotto";
            case 1 -> "Nome Prodotto";
            case 2 -> "Descrizione";
            case 3 -> "Costo (€)";
            case 4 -> "Produttore";
            case 5 -> "Categoria";
            case 6 -> "Quantità";
            case 7 -> "Foto";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CarrelloProdottiModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setIdProdotto(Integer.parseInt(value.toString()));
            }
            case 1 -> riga.setNomeProdotto(value.toString());
            case 2 -> riga.setDescrizione(value.toString());
            case 3 -> {
                if (FloatExt.isParsable(value.toString()))
                    riga.setCosto(Float.parseFloat(value.toString()));
            }
            case 4 -> riga.setNomeProduttore(value.toString());
            case 5 -> riga.setNomeCategoria(value.toString());
            case 6 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setQuantita(Integer.parseInt(value.toString()));
            }
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == 7) return ImageIcon.class;
        return Object.class;
    }
}
