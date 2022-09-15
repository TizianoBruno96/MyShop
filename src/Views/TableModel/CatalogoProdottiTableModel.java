package Views.TableModel;

import Utilities.FloatExt;
import Utilities.IntegerExt;
import Views.AccessoUtente;
import Views.Model.RigaCatalogoProdotti;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CatalogoProdottiTableModel extends AbstractTableModel {

    private List<RigaCatalogoProdotti> righe = new ArrayList<>(); //implemento RigaCatalogo in una classe apparte e mi indica cosa deve contenere ogni riga

    public CatalogoProdottiTableModel(List<RigaCatalogoProdotti> intestazione) {
        this.righe = intestazione;
    }

    public List<RigaCatalogoProdotti> getRighe() {
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
        RigaCatalogoProdotti riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return riga.getIdProdotto();
            case 1:
                return riga.getNomeProdotto();
            case 2:
                return riga.getDescrizione();
            case 3:
                return riga.getCosto();
            case 4:
                return riga.getNomeProduttore();
            case 5:
                return riga.getCategoriaProdotto();
            case 6:
                return riga.getDisponibilita();
            case 7:
                return riga.getCommento();
            case 8:
                return riga.getVoto();
            case 9:
                return riga.getpCorsia();
            case 10:
                return riga.getpScaffale();
            case 11:
                return riga.getFoto();

        }
        return null;
    }

    @Override //questo metodo serve per dare l'intestazione alle colonne
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id Prodotto";
            case 1:
                return "Nome Prodotto";
            case 2:
                return "Descrizione";
            case 3:
                return "Costo (€)";
            case 4:
                return "Nome Produttore";
            case 5:
                return "Categoria";
            case 6:
                return "Disponibilità";
            case 7:
                return "Commento";
            case 8:
                return "Voto(da 1 a 5)";
            case 9:
                return "Corsia";
            case 10:
                return "Scaffale";
            case 11:
                return "Foto Prodotto";
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        RigaCatalogoProdotti riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setIdProdotto(Integer.parseInt(value.toString()));
            case 1:
                  riga.setNomeProdotto(value.toString());
            case 2:
                riga.setDescrizione(value.toString());
            case 3:
                if (FloatExt.isParsable(value.toString()))
                    riga.setCosto(Float.parseFloat(value.toString()));
            case 4:
                riga.setNomeProduttore(value.toString());
            case 5:
                riga.setCategoriaProdotto(value.toString());
            case 6:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setDisponibilita(Integer.parseInt(value.toString()));
            case 7:
                riga.setCommento(value.toString());
            case 8:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setVoto(Integer.parseInt(value.toString()));
            case 9:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpCorsia(Integer.parseInt(value.toString()));
            case 10:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setpScaffale(Integer.parseInt(value.toString()));
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
