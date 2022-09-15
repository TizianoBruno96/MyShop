package Views.TableModel;

import Utilities.IntegerExt;
import Views.Model.RigaCatalogoProdotti;
import Views.Model.RigaCreazionePuntoVendita;
import Views.Model.RigaInserisciProdotto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class InserisciProdottoTableModel extends AbstractTableModel {
    private List<RigaInserisciProdotto> righe = new ArrayList<>();

    public InserisciProdottoTableModel(List<RigaInserisciProdotto> righe) {
        this.righe = righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RigaInserisciProdotto riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return riga.getNomeProdotto();
            case 1:
                return riga.getDescrizione();
            case 2:
                return riga.getCosto();
            case 3:
                return riga.getNomeProduttore();
            case 4:
                return riga.getCategoriaProdotto();
            case 5:
                return riga.getDisponibilita();
            case 6:
                return riga.getpCorsia();
            case 7:
                return riga.getpScaffale();
            case 8:
                return riga.getFoto();
        }
        return null;
    }


    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0 : return "Nome Prodotto";
            case 1 : return "Descrizione";
            case 2 : return "Costo";
            case 3 : return "Nome Produttore";
            case 4 : return "Categoria";
            case 5 : return "Disponibilità";
            case 6 : return "Corsia";
            case 7 : return "Scaffale";
            case 8 : return "Foto";
        }
        return null;
    }

    @Override
    public void setValueAt(Object value,int rowIndex, int columnIndex){
        RigaInserisciProdotto riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNomeProdotto(value.toString());
            case 1:
                riga.setDescrizione(value.toString());
            case 2:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setCosto(Integer.parseInt(value.toString()));
            case 3 :
                riga.setNomeProduttore(value.toString());
            case 4:
                riga.setCategoriaProdotto(value.toString());
            case 5:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setDisponibilita(Integer.parseInt(value.toString()));
            case 6:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpCorsia(Integer.parseInt(value.toString()));
            case 7 :
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpScaffale(Integer.parseInt(value.toString()));
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0 ;
    }




}
