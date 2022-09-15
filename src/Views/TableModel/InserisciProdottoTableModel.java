package Views.TableModel;

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
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
