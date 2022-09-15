package ActionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoProduttoriListeners implements ActionListener {
    public final static String CIPL_BTN = "confermaInserimentoProduttori_btn";
    private JTable tabella;

    public ConfermaInserimentoProduttoriListeners(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIPL_BTN.equals(azione)){
            /*for (int i=0;i<10;i++){
                for (int j =0;j<10;j++){
                    String NomeProduttore = (String) tabella.getValueAt(i,j);
                    String Sito = (String) tabella.getValueAt(i,j);
                    String Citta = (String) tabella.getValueAt(i,j);
                    String Nazione = (String) tabella.getValueAt(i,j);
                }
            }*/

            /*int[] righeSelezionate = tabella.getSelectedRows();
            System.out.println(righeSelezionate[0]);
            CatalogoTableModel tModel = (CatalogoTableModel) tabella.getModel();
            for(int i=0;i<righeSelezionate.length;i++) {
                RigaCatalogo rigaSelezionata = tModel.getRighe().get(righeSelezionate[i]);
                System.out.println("ID prodotto selezionato: "+rigaSelezionata.getIdProdotto());
            }
        }*/
        }

    }
}
