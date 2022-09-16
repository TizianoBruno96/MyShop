package Views.Panels;

import DAO.CategoriaDAO;
import DAO.FornitoreDAO;
import DAO.ServizioDAO;
import Model.Articoli.Fornitore;
import Model.Articoli.Servizio;
import Model.Categoria;
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
    }
}