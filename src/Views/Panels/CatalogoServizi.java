package Views.Panels;

import ActionListeners.OrdineProdottoListener;
import ActionListeners.OrdineServizioListener;
import DAO.CategoriaDAO;
import DAO.FornitoreDAO;
import DAO.ServizioDAO;
import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;
import Model.Categoria;
import Views.AccessoUtente;
import Views.Model.CatalogoServiziModel;
import Views.TableModel.CatalogoServiziTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoServizi extends JPanel {
    public CatalogoServizi() {
        setLayout(new BorderLayout());
        List<CatalogoServiziModel> righe = new ArrayList<>();

        ArrayList<Servizio> servizi = ServizioDAO.getInstance().findAll();

        for (Servizio s : servizi) {
            Categoria categoria = CategoriaDAO.getInstance().findByID(s.getIdCategoria());
            Fornitore fornitore = FornitoreDAO.getInstance().findByID(s.getIdFornitore());
            //Recensione recensione = RecensioneDAO.getInstance().findByProdotto();

            CatalogoServiziModel riga = new CatalogoServiziModel();

            riga.setNomeServizio(s.getNome());
            riga.setCosto(s.getCosto());
            riga.setCategoria(categoria.getNome());
            riga.setFornitore(fornitore.getNome());
            riga.setIdServizio(s.getIdServizio());
            //riga.setCommento(s.);
            righe.add(riga);
        }


        CatalogoServiziTableModel tableModel = new CatalogoServiziTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);
        add(scrollPane, BorderLayout.CENTER);
        tabella.setRowHeight(50);

        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        if (AccessoUtente.getTipo() != null) {
            JButton inserimentoLista = new JButton("Inserisci nel carrello");
            inserimentoLista.setActionCommand(OrdineServizioListener.ORDINESERVIZIO_BTN);
            OrdineServizioListener ordineServizioListener = new OrdineServizioListener(tabella);
            inserimentoLista.addActionListener(ordineServizioListener);
            if (AccessoUtente.getTipo().equals("MN")){
                JButton rifornisciMagazzino = new JButton("Rifornisci Magazzino");
                pannelloAzioni.add(rifornisciMagazzino);
            }
            pannelloAzioni.add(inserimentoLista);
        }
    }
}
