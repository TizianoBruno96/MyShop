package Views.TableModel;

import Utilities.IntegerExt;
import Views.Model.RigaRegistrazione;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class RegistrazioneTableModel extends AbstractTableModel {
    private List<RigaRegistrazione> righe = new ArrayList<>();

    public RegistrazioneTableModel(List<RigaRegistrazione> righe) {
        this.righe = righe;
    }

    public List<RigaRegistrazione> getRighe() {
        return righe;
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
        RigaRegistrazione riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return riga.getNome();
            case 1:
                return riga.getCognome();
            case 2:
                return riga.getUsername();
            case 3:
                return riga.getEmail();
            case 4:
                return riga.getTelefono();
            case 5:
                return riga.getEta();
            case 6:
                return riga.getResidenza();
            case 7:
                return riga.getProfessione();
            case 8:
                return riga.getPassword();
            case 9:
                return riga.getNomePuntoVendita();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Nome";
            case 1:
                return "Cognome";
            case 2:
                return "Username";
            case 3:
                return "E-mail";
            case 4:
                return "Telefono";
            case 5:
                return "Età";
            case 6:
                return "Residenza";
            case 7:
                return "Professione";
            case 8:
                return "Password";
            case 9:
                return "Nome Punto Vendita";
        }
        return null;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        RigaRegistrazione riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0:
                riga.setNome(value.toString());
            case 1:
                riga.setCognome(value.toString());
            case 2:
                riga.setUsername(value.toString());
            case 3:
                riga.setEmail(value.toString());
            case 4:
                riga.setTelefono(value.toString());
            case 5:
                if (IntegerExt.isParsable(value.toString()))
                    riga.setEta(Integer.parseInt(value.toString()));
            case 6:
                riga.setResidenza(value.toString());
            case 7:
                riga.setProfessione(value.toString());
            case 8:
                riga.setPassword(value.toString());
            case 9 :
                riga.setNomePuntoVendita(value.toString());
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 0;
    }


}
