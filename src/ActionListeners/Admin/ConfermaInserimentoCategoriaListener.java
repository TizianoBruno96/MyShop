package ActionListeners.Admin;

import Business.InserimentoCategoriaBusiness;
import DAO.CategoriaDAO;
import DAO.Interfaces.ICategoriaDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfermaInserimentoCategoriaListener implements ActionListener {
    public static final String CIC_BTN = "Cic_btn";
    private final JTable tabella;
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();

    public ConfermaInserimentoCategoriaListener(JTable tabella) {
        this.tabella = tabella;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String azione = e.getActionCommand();
        if (CIC_BTN.equals(azione)) {
            String nomeCategoria = (String) tabella.getValueAt(0, 0);
            String nomeCategoriaPadre = (String) tabella.getValueAt(0, 1);

            //controllo se i campi sono vuoti e se la categoria padre esiste
            if (nomeCategoria == null || nomeCategoria.equals("")) {
                JOptionPane.showMessageDialog(null, "Inserire il nome della categoria");
            } else if (categoriaDAO.findByNome(nomeCategoria) != null)
                JOptionPane.showMessageDialog(null, "La categoria inserita esiste già");
            else {
                if (nomeCategoriaPadre == null)
                    InserimentoCategoriaBusiness.getInstance().InserisciCategoria(nomeCategoria);
                else
                    InserimentoCategoriaBusiness.getInstance().InserisciCategoria(nomeCategoria, categoriaDAO.findByNome(nomeCategoriaPadre).getIdCategoria());
            }
        }
    }
}
