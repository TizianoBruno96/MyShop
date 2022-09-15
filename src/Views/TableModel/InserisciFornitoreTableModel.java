package Views.TableModel;

import Views.Model.RigaInserisciFornitore;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class InserisciFornitoreTableModel extends AbstractTableModel {
    private List<RigaInserisciFornitore> righe = new ArrayList<>();

    public InserisciFornitoreTableModel(List<RigaInserisciFornitore> righe) {
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
         RigaInserisciFornitore riga  = righe.get(rowIndex);
         switch (columnIndex){
             case 0 : return riga.getNome();
             case 1 : return riga.getSito();
         }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nome Fornitore";
            case 1:
                return "Sito";

        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        RigaInserisciFornitore riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNome(value.toString());
            case 1:
                riga.setSito(value.toString());

        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0;
    }


}
