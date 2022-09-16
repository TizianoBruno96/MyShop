package ActionListeners;

import DAO.Interfaces.*;
import DAO.OrdineProdottoDAO;
import DAO.OrdineServizioDAO;
import DAO.ProdottoDAO;
import DAO.ServizioDAO;
import Model.ListaAcquisto;
import Views.AccessoUtente;
import Views.Model.CarrelloProdottiModel;
import Views.Model.CatalogoServiziModel;
import Views.TableModel.CarrelloProdottiTableModel;
import Views.TableModel.CatalogoServiziTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaRimozioneListener implements ActionListener {
    public final static String CRL_BTN = "crl_btn";
    private JTable tableProdotti;
    private JTable tableServizi;
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IServizioDAO servizioDAO = ServizioDAO.getInstance();
    IOrdineProdottoDAO ordineProdottoDAO = OrdineProdottoDAO.getInstance();
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = DAO.ListaAcquistoDAO.getInstance();
    public ConfermaRimozioneListener(JTable tableProdotti, JTable tableServizi) {
        this.tableProdotti = tableProdotti;
        this.tableServizi = tableServizi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(CRL_BTN)) {
            int[] prodottiSelectedRows = tableProdotti.getSelectedRows();
            int[] serviziSelectedRows = tableServizi.getSelectedRows();
            CarrelloProdottiTableModel prodottiTableModel = (CarrelloProdottiTableModel) tableProdotti.getModel();
            CatalogoServiziTableModel serviziTableModel = (CatalogoServiziTableModel) tableServizi.getModel();

            ListaAcquisto ls = listaAcquistoDAO.findByIDUtente(AccessoUtente.getIdUtente());

            for(int i : prodottiSelectedRows) {
                CarrelloProdottiModel prodotto = prodottiTableModel.getRighe().get(i);
                ordineProdottoDAO.removeByID(prodotto.getIdProdotto(), ls.getIdListaAcquisto());
            }

            for(int i : serviziSelectedRows) {
                CatalogoServiziModel servizio = serviziTableModel.getRighe().get(i);
                ordineServizioDAO.removeByID(servizio.getIdServizio(), ls.getIdListaAcquisto());
            }
        }
    }
}
