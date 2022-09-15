package Views.TableModel;

import Utilities.IntegerExt;
import Views.Model.RigaCreazioneManager;
import Views.Model.RigaCreazionePuntoVendita;
import Views.Model.RigaInserisciProdotto;
import Views.Model.RigaInserisciProduttore;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class InserisciProduttoreTableModel extends AbstractTableModel {
    private List<RigaInserisciProduttore> righe = new ArrayList<>();

    public InserisciProduttoreTableModel(List<RigaInserisciProduttore> righe) {
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
        RigaInserisciProduttore riga = righe.get(rowIndex);
        switch (columnIndex){
            case 0 : return riga.getNomeProduttore();
            case 1 : return riga.getSito();
            case 2 : return riga.getCitta();
            case 3 : return riga.getNazione();
        }
        return null;
    }
    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0 : return "Nome Produttore";
            case 1 : return "Sito";
            case 2 : return "Città";
            case 3 : return "Nazione";
        }
        return null;
    }

    @Override
    public void setValueAt(Object value,int rowIndex, int columnIndex){
        RigaInserisciProduttore riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNomeProduttore(value.toString());
            case 1:
                riga.setSito(value.toString());
            case 2:
                riga.setCitta(value.toString());
            case 3:
                riga.setNazione(value.toString());
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0 ;
    }


}
