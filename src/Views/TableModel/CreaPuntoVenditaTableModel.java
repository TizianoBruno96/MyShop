package Views.TableModel;

import Utilities.IntegerExt;
import Views.Model.RigaCreazioneManager;
import Views.Model.RigaCreazionePuntoVendita;
import Views.Model.RigaRegistrazione;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CreaPuntoVenditaTableModel extends AbstractTableModel {
    private List<RigaCreazionePuntoVendita> righe = new ArrayList<>();

    public CreaPuntoVenditaTableModel(List<RigaCreazionePuntoVendita> righe) {
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
        RigaCreazionePuntoVendita riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return riga.getCitta();
            case 1:
                return riga.getNome();
            case 2:
                return riga.getIndirizzo();
            case 3:
                return riga.getUsernameManager();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0 : return "Città";
            case 1 : return "Nome";
            case 2 : return "Indirizzo";
            case 3 : return "Username Manager";
        }
        return null;
    }

    @Override
    public void setValueAt(Object value,int rowIndex, int columnIndex){
        RigaCreazionePuntoVendita riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setCitta(value.toString());
            case 1:
                riga.setNome(value.toString());
            case 2:
                riga.setIndirizzo(value.toString());
            case 3 :
                riga.setUsernameManager(value.toString());
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0 ;
    }

}
