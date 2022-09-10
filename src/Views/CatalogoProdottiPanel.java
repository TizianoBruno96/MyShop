package Views;

import ActionListeners.CarrelloListeners;
import DAO.*;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Views.Model.RigaCatalogoProdotti;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoProdottiPanel extends JPanel {
    public CatalogoProdottiPanel() {
        setLayout(new BorderLayout());
        List<RigaCatalogoProdotti> righe = new ArrayList<>();
        IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
        ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
        IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
        //IFotoDAO fotoDAO = FotoDAO.getInstance();


        ArrayList<Prodotto> prodotti = prodottoDAO.findAll();

        for (Prodotto p: prodotti) {
            Categoria categoria = categoriaDAO.findByID(p.getIdCategoria());
            Produttore produttore = produttoreDAO.findByID(p.getIdProduttore());
            //ArrayList<Foto> foto = fotoDAO.findByProdotto(p.getIdProdotto());
            RigaCatalogoProdotti riga = new RigaCatalogoProdotti();

            //riga.setFoto(foto[0]);
            riga.setNomeProdotto(p.getNome());
            riga.setDescrizione(p.getDescrizione());
            riga.setPrezzo(p.getCosto());
            riga.setNomeProduttore(produttore.getNome());
            riga.setCategoria(categoria.getNome());
            righe.add(riga);
        }






        CatalogoProdottiTableModel tableModel = new CatalogoProdottiTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);//aggiungo la tabella in un pannello scrollabile
        add(scrollPane,BorderLayout.CENTER);
        tabella.setRowHeight(50);




        JPanel pulsantiAzioneTabella = new JPanel();
        pulsantiAzioneTabella.setLayout(new FlowLayout());
        JButton mettiNelCarrello = new JButton("Metti nel carrello");
        pulsantiAzioneTabella.add(mettiNelCarrello);
        add(mettiNelCarrello,BorderLayout.SOUTH);
        CarrelloListeners carrelloListeners = new CarrelloListeners(tabella);
        carrelloListeners.setTabella(tabella);
        mettiNelCarrello.setActionCommand(CarrelloListeners.METTINELCARRELLO_BTN);
        mettiNelCarrello.addActionListener(carrelloListeners);




    }
}
