package Views.Panels;

import ActionListeners.OrdineServizioListener;
import DAO.CategoriaDAO;
import DAO.FornitoreDAO;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IFornitoreDAO;
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
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
    ServizioDAO servizioDAO = ServizioDAO.getInstance();

    public CatalogoServizi() {
        setLayout(new BorderLayout());
        List<CatalogoServiziModel> righe = new ArrayList<>();

        ArrayList<Servizio> servizi = servizioDAO.findAll();

        for (Servizio s : servizi) {
            Categoria categoria = categoriaDAO.findByID(s.getIdCategoria());
            Fornitore fornitore = fornitoreDAO.findByID(s.getIdFornitore());

            CatalogoServiziModel riga = new CatalogoServiziModel();

            riga.setNomeServizio(s.getNome());
            riga.setCosto(s.getCosto());
            riga.setCategoria(categoria.getNome());
            riga.setFornitore(fornitore.getNome());
            riga.setIdServizio(s.getIdServizio());
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
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
