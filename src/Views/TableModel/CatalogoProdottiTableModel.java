package Views.TableModel;

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
    public List<RigaCatalogoProdotti> getIntestazione() {
        return righe;
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
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RigaCatalogoProdotti riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return riga.getNomeProdotto();
            case 1:
                return riga.getDescrizione();
            case 2:
                return riga.getPrezzo();
            case 3:
                return riga.getNomeProduttore();
            case 4:
                return riga.getCategoria();
           // case 6 :
               // UtenteDAO uDao = new UtenteDAO();

        }
        return null;
    }

    @Override //questo metodo serve per dare l'intestazione alle colonne
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0 : return "Nome Prodotto";
            case 1 : return "Descrizione";
            case 2 : return "Costo (€)";
            case 3 : return "Nome Produttore";
            case 4 : return "Categoria";
            case 5 : return "Foto Prodotto";
        }
        return null;
    }

}
