package Views;

import ActionListeners.CarrelloListeners;
import DAO.*;
import DAO.Interfaces.*;
import Model.Articoli.Foto;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.Posizione;
import Views.Model.RigaCatalogoProdotti;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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
        IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
        IMagazzinoDAO magazzinoDAO = MagazzinoDAO.getInstance();
        IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();
        IFotoDAO fotoDAO = FotoDAO.getInstance();


        ArrayList<Prodotto> prodotti = prodottoDAO.findAll();

        for (Prodotto p: prodotti) {
            Categoria categoria = categoriaDAO.findByID(p.getIdCategoria());
            Produttore produttore = produttoreDAO.findByID(p.getIdProduttore());
            RigaCatalogoProdotti riga = new RigaCatalogoProdotti();


            riga.setIdProdotto(p.getIdProdotto());
            riga.setNomeProdotto(p.getNome());
            riga.setDescrizione(p.getDescrizione());
            riga.setCosto(p.getCosto());
            riga.setNomeProduttore(produttore.getNome());
            riga.setCategoriaProdotto(categoria.getNome());
            ArrayList<Posizione> posizioni = posizioneDAO.find(p.getIdProdotto(),magazzinoDAO.findByID(1).getIdMagazzino());
            int quantita=0;
            for (Posizione pro : posizioni){
                quantita += pro.getQuantita();
            }
            riga.setpCorsia(posizioni.get(0).getpCorsia());
            riga.setpScaffale(posizioni.get(0).getpScaffale());
            riga.setDisponibilita(quantita);
            if (recensioneDAO.findByProdotto(p.getIdProdotto()).size()>0) {
                riga.setCommento(recensioneDAO.findByProdotto(p.getIdProdotto()).get(0).getCommento());
                riga.setVoto(recensioneDAO.findByProdotto(p.getIdProdotto()).get(0).getVoto());
            }


            if ( fotoDAO.findByProdotto(p.getIdProdotto()).size()>0) {
                Foto foto = fotoDAO.findByProdotto(p.getIdProdotto()).get(0);
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(foto.getValore().getBinaryStream()));
                    Image image = icon.getImage();
                    Image image2 = image.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH);
                    icon=new ImageIcon(image2);
                    riga.setFoto(icon);

                } catch (IOException e) {
                    //throw new RuntimeException(e);
                    e.printStackTrace();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            righe.add(riga);

        }




        CatalogoProdottiTableModel tableModel = new CatalogoProdottiTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);//aggiungo la tabella in un pannello scrollabile
        add(scrollPane,BorderLayout.CENTER);
        tabella.setRowHeight(100);







    }
}
