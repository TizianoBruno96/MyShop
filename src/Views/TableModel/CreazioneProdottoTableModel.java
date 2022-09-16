package Views.TableModel;

import Utilities.FloatExt;
import Utilities.IntegerExt;
import Views.Model.InserimentoProdottoModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazioneProdottoTableModel extends AbstractTableModel {
    private final List<InserimentoProdottoModel> righe;

    public CreazioneProdottoTableModel(List<InserimentoProdottoModel> righe) {
        this.righe = righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InserimentoProdottoModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNomeProdotto();
            case 1 -> riga.getDescrizione();
            case 2 -> riga.getCosto();
            case 3 -> riga.getNomeProduttore();
            case 4 -> riga.getCategoriaProdotto();
            case 5 -> riga.getDisponibilita();
            case 6 -> riga.getpCorsia();
            case 7 -> riga.getpScaffale();
            case 8 -> riga.getNomePuntoVendita();
            case 9 -> riga.getFoto();
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
            case 5 -> "Disponibilità";
            case 6 -> "Corsia";
            case 7 -> "Scaffale";
            case 8 -> "Nome Punto Vendita";
            case 9 -> "Foto";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        InserimentoProdottoModel riga = righe.get(rowIndex);
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
                if (IntegerExt.isParsable(value.toString()))
                    riga.setDisponibilita(Integer.parseInt(value.toString()));
            case 6:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpCorsia(Integer.parseInt(value.toString()));
            case 7:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpScaffale(Integer.parseInt(value.toString()));
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0;
    }


}