package ActionListeners;

import DAO.Interfaces.IListaAcquistoDAO;
import DAO.Interfaces.IOrdineProdottoDAO;
import DAO.ListaAcquistoDAO;
import DAO.OrdineProdottoDAO;
import DAO.ProdottoDAO;
import Model.ListaAcquisto;
import Model.OrdineProdotto;
import Views.AccessoUtente;
import Views.Model.CatalogoProdottiModel;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InserimentoListaListeners implements ActionListener {
    public static final String INSERISCINELLALISTA_BTN = "Inseiscinellalista_btn";
    private final JTable tabella;
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = ListaAcquistoDAO.getInstance();


    public InserimentoListaListeners(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (INSERISCINELLALISTA_BTN.equals(azione)) {
            int[] righeSelezionate = tabella.getSelectedRows();
            CatalogoProdottiTableModel tModel = (CatalogoProdottiTableModel) tabella.getModel();
            for(int i=0;i<righeSelezionate.length;i++) {
                CatalogoProdottiModel rigaSelezionata = tModel.getRighe().get(righeSelezionate[i]);
                int idProdotto = rigaSelezionata.getIdProdotto();
                ListaAcquisto la = listaAcquistoDAO.findByIDUtente(AccessoUtente.getIdUtente());
                ordineProdottoDAO.add(new OrdineProdotto(idProdotto,la.getIdListaAcquisto(),1));
            }
        }
    }
}
