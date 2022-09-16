package ActionListeners;

import Business.InserimentoServizioBusiness;
import DAO.CategoriaDAO;
import DAO.FornitoreDAO;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IFornitoreDAO;
import Model.Articoli.Fornitore;
import Model.Categoria;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoServizioListener implements ActionListener {
    public final static String CISL_BTN = "CISL_BTN";
    private final JTable table;
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    public ConfermaInserimentoServizioListener(JTable table) {
        this.table = table;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CISL_BTN.equals(azione)) {
            String nome = (String) table.getValueAt(0, 0);
            float costo = (float) table.getValueAt(0, 1);
            String nomefornitore = (String) table.getValueAt(0, 2);
            String nomecategoria = (String) table.getValueAt(0, 3);

            //Controllo che i campi non siano vuoti e che il servizio non esista già
            if (nome == null || nome.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il nome del servizio");
            else if (costo == 0)
                JOptionPane.showMessageDialog(null, "Inserire il costo del servizio");
            else if (nomefornitore == null || nomefornitore.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire il nome del fornitore");
            else if (!fornitoreDAO.checkNome(nomefornitore))
                JOptionPane.showMessageDialog(null, "Il fornitore inserito non esiste");
            else if (nomecategoria == null || nomecategoria.equals(""))
                JOptionPane.showMessageDialog(null, "Inserire la categoria del servizio");
            else if (categoriaDAO.findByNome(nomecategoria) == null)
                JOptionPane.showMessageDialog(null, "La categoria inserita non esiste");
            else {
                Categoria categoria = categoriaDAO.findByNome(nomecategoria);
                Fornitore fornitore = fornitoreDAO.findByNome(nomefornitore);
                InserimentoServizioBusiness.getInstance().InserisciServizio(nome, costo, fornitore.getIdFornitore(), categoria.getIdCategoria());
            }
        }
    }
}
