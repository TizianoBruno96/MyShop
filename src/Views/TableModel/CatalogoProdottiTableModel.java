package Views.TableModel;

import Utilities.FloatExt;
import Utilities.IntegerExt;
import Views.Model.CatalogoProdottiModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CatalogoProdottiTableModel extends AbstractTableModel {

    private List<CatalogoProdottiModel> righe; //implemento RigaCatalogo in una classe apparte e mi indica cosa deve contenere ogni riga

    public CatalogoProdottiTableModel(List<CatalogoProdottiModel> intestazione) {
        this.righe = intestazione;
    }

    public List<CatalogoProdottiModel> getRighe() {
        return righe;
    }

    @Override
    public int getRowCount() {
        return righe.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CatalogoProdottiModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getIdProdotto();
            case 1 -> riga.getNomeProdotto();
            case 2 -> riga.getDescrizione();
            case 3 -> riga.getCosto();
            case 4 -> riga.getNomeProduttore();
            case 5 -> riga.getCategoriaProdotto();
            case 6 -> riga.getDisponibilita();
            case 7 -> riga.getCommento();
            case 8 -> riga.getVoto();
            case 9 -> riga.getpCorsia();
            case 10 -> riga.getpScaffale();
            case 11 -> riga.getFoto();
            default -> null;
        };
    }

    @Override //questo metodo serve per dare l'intestazione alle colonne
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Id Prodotto";
            case 1 -> "Nome Prodotto";
            case 2 -> "Descrizione";
            case 3 -> "Costo (€)";
            case 4 -> "Nome Produttore";
            case 5 -> "Categoria";
            case 6 -> "Disponibilità";
            case 7 -> "Commento";
            case 8 -> "Voto(da 1 a 5)";
            case 9 -> "Corsia";
            case 10 -> "Scaffale";
            case 11 -> "Foto Prodotto";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        CatalogoProdottiModel riga = righe.get(rowIndex);
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
            case 5 -> riga.setCategoriaProdotto(value.toString());
            case 6 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setDisponibilita(Integer.parseInt(value.toString()));
            }
            case 7 -> riga.setCommento(value.toString());
            case 8 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setVoto(Integer.parseInt(value.toString()));
            }
            case 9 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpCorsia(Integer.parseInt(value.toString()));
            }
            case 10 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpScaffale(Integer.parseInt(value.toString()));
            }
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0;
    }


    @Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == 11) return ImageIcon.class;
        return Object.class;
    }


}
