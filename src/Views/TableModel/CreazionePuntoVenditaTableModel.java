package Views.TableModel;

import Utilities.FloatExt;
import Utilities.IntegerExt;
import Views.AccessoUtente;
import Views.Model.CreazionePuntoVenditaModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreazionePuntoVenditaTableModel extends AbstractTableModel {
    private final List<CreazionePuntoVenditaModel> righe;

    public CreazionePuntoVenditaTableModel(List<CreazionePuntoVenditaModel> righe) {
        this.righe = righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CreazionePuntoVenditaModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getCitta();
            case 1 -> riga.getNome();
            case 2 -> riga.getIndirizzo();
            case 3 -> riga.getUsernameManager();
            case 4 -> riga.getMaxCorsia();
            case 5 -> riga.getMaxScaffale();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Città";
            case 1 -> "Nome";
            case 2 -> "Indirizzo";
            case 3 -> "Username Manager";
            case 4 -> "Numero max corsie magazzino";
            case 5 -> "Numero max scaffali magazzino";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CreazionePuntoVenditaModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setCitta(value.toString());
            case 1:
                riga.setNome(value.toString());
            case 2:
                riga.setIndirizzo(value.toString());
            case 3:
                riga.setUsernameManager(value.toString());
            case 4 :
                if (IntegerExt.isParsable(value.toString()))
                    riga.setMaxCorsia(Integer.parseInt(value.toString()));
            case 5 :
                if (IntegerExt.isParsable(value.toString()))
                    riga.setMaxScaffale(Integer.parseInt(value.toString()));
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return AccessoUtente.getTipo().equals("AM");
    }
}
