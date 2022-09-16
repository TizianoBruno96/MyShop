package Views.Panels;

import ActionListeners.OrdineProdottoListener;
import ActionListeners.PaginaProdottoListener;
import DAO.*;
import DAO.Interfaces.*;
import Model.Articoli.Foto;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;
import Model.Posizione;
import Views.AccessoUtente;
import Views.FinestraPrincipale;
import Views.Model.CatalogoProdottiModel;
import Views.TableModel.CatalogoProdottiTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogoProdotti extends JPanel {
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
    IMagazzinoDAO magazzinoDAO = MagazzinoDAO.getInstance();
    IRecensioneDAO recensioneDAO = RecensioneDAO.getInstance();
    IFotoDAO fotoDAO = FotoDAO.getInstance();

    public CatalogoProdotti(FinestraPrincipale frame) {
        setLayout(new BorderLayout());
        List<CatalogoProdottiModel> righe = new ArrayList<>();
        ArrayList<Prodotto> prodotti = prodottoDAO.findAll();

        for (Prodotto p : prodotti) {
            Categoria categoria = categoriaDAO.findByID(p.getIdCategoria());
            Produttore produttore = produttoreDAO.findByID(p.getIdProduttore());
            CatalogoProdottiModel riga = new CatalogoProdottiModel();

            riga.setIdProdotto(p.getIdProdotto());
            riga.setNomeProdotto(p.getNome());
            riga.setDescrizione(p.getDescrizione());
            riga.setCosto(p.getCosto());
            riga.setNomeProduttore(produttore.getNome());
            riga.setCategoriaProdotto(categoria.getNome());
            ArrayList<Posizione> posizioni = posizioneDAO.find(p.getIdProdotto(), magazzinoDAO.findByID(1).getIdMagazzino());
            int quantita = 0;
            for (Posizione pro : posizioni) {
                quantita += pro.getQuantita();
            }
            if (posizioni.size() == 0) {
                riga.setpCorsia(0);
                riga.setpScaffale(0);
            } else {
                riga.setpCorsia(posizioni.get(0).getpCorsia());
                riga.setpScaffale(posizioni.get(0).getpScaffale());
            }
            riga.setDisponibilita(quantita);
            if (recensioneDAO.findByProdotto(p.getIdProdotto()).size() > 0) {
                riga.setCommento(recensioneDAO.findByProdotto(p.getIdProdotto()).get(0).getCommento());
                riga.setVoto(recensioneDAO.findByProdotto(p.getIdProdotto()).get(0).getVoto());
            }


            if (fotoDAO.findByProdotto(p.getIdProdotto()).size() > 0) {
                Foto foto = fotoDAO.findByProdotto(p.getIdProdotto()).get(0);
                //TODO: sistemare input delle foto, l'inserimento del blob non funziona
                //stampo la foto
                try {
                    ImageIcon icon = new ImageIcon(ImageIO.read(foto.getValore().getBinaryStream()));
                    Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    if (image != null) {
                        icon = new ImageIcon(image);
                    }
                    riga.setFoto(icon);
                } catch (IOException e) {
                    System.out.println("Errore caricamento immagine");
                } catch (SQLException e) {
                    System.out.println("Errore caricamento immagine da database");
                }
            }
            righe.add(riga);
        }


        CatalogoProdottiTableModel tableModel = new CatalogoProdottiTableModel(righe);
        JTable tabella = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabella);//aggiungo la tabella in un pannello scrollabile
        add(scrollPane, BorderLayout.CENTER);
        tabella.setRowHeight(100);


        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        if (AccessoUtente.getTipo() != null) {
            JButton inserimentoLista = new JButton("Inserisci nel carrello");
            inserimentoLista.setActionCommand(OrdineProdottoListener.ORDINEPRODOTTO_BTN);
            OrdineProdottoListener ordineProdottoListener = new OrdineProdottoListener(tabella);
            inserimentoLista.addActionListener(ordineProdottoListener);

            if (AccessoUtente.getTipo().equals("MN")) {
                JButton rifornisciMagazzino = new JButton("Rifornisci Magazzino");
                pannelloAzioni.add(rifornisciMagazzino);
            }
            pannelloAzioni.add(inserimentoLista);
        }
        //aggiungo un pulsante per accedere alla pagina del prodotto
        JButton dettagliProdotto = new JButton("Dettagli Prodotto");
        dettagliProdotto.setActionCommand(PaginaProdottoListener.PPL_BTN);
        PaginaProdottoListener paginaProdottoListener = new PaginaProdottoListener(tabella, frame);
        dettagliProdotto.addActionListener(paginaProdottoListener);
        pannelloAzioni.add(dettagliProdotto);
        add(pannelloAzioni, BorderLayout.SOUTH);
    }
}
