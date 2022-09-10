package Views.TableModel;

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
        return null;
    }
}
