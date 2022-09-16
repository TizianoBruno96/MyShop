package Views.TableModel;

import Utilities.IntegerExt;
import Views.AccessoUtente;
import Views.Model.RegistrazioneModel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RegistrazioneTableModel extends AbstractTableModel {
    private final List<RegistrazioneModel> righe;

    public RegistrazioneTableModel(List<RegistrazioneModel> righe) {
        this.righe = righe;
    }

    public List<RegistrazioneModel> getRighe() {
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
        RegistrazioneModel riga = righe.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> riga.getNome();
            case 1 -> riga.getCognome();
            case 2 -> riga.getUsername();
            case 3 -> riga.getEmail();
            case 4 -> riga.getTelefono();
            case 5 -> riga.getEta();
            case 6 -> riga.getResidenza();
            case 7 -> riga.getProfessione();
            case 8 -> riga.getPassword();
            case 9 -> riga.getNomePuntoVendita();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Nome";
            case 1 -> "Cognome";
            case 2 -> "Username";
            case 3 -> "E-mail";
            case 4 -> "Telefono";
            case 5 -> "Età";
            case 6 -> "Residenza";
            case 7 -> "Professione";
            case 8 -> "Password";
            case 9 -> "Nome Punto Vendita";
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        RegistrazioneModel riga = righe.get(rowIndex);
        switch (columnIndex) {
            case 0 -> riga.setNome(value.toString());
            case 1 -> riga.setCognome(value.toString());
            case 2 -> riga.setUsername(value.toString());
            case 3 -> riga.setEmail(value.toString());
            case 4 -> riga.setTelefono(value.toString());
            case 5 -> {
                if (IntegerExt.isParsable(value.toString()))
                    riga.setEta(Integer.parseInt(value.toString()));
            }
            case 6 -> riga.setResidenza(value.toString());
            case 7 -> riga.setProfessione(value.toString());
            case 8 -> riga.setPassword(value.toString());
            case 9 -> riga.setNomePuntoVendita(value.toString());
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return AccessoUtente.getTipo().equals("AM");
    }
}
