package Views;

import ActionListeners.ScritturaRecensioneListener;
import DAO.CategoriaDAO;
import DAO.Interfaces.*;
import DAO.ProduttoreDAO;
import Model.Articoli.Foto;
import Model.Articoli.Prodotto;
import Model.Recensione;
import Views.Model.RecensioniModel;
import Views.TableModel.RecensioniTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaginaProdotto extends JPanel {
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IFotoDAO fotoDAO = DAO.FotoDAO.getInstance();
    IRecensioneDAO recensioneDAO = DAO.RecensioneDAO.getInstance();
    IUtenteDAO utenteDAO = DAO.UtenteDAO.getInstance();

    public PaginaProdotto(Prodotto prodotto) {
        //mostro le informazioni del prodotto
        JPanel pannelloInfo = new JPanel();
        List<JPanel> pannelliFoto = new ArrayList<>();

        pannelloInfo.setLayout(new BoxLayout(pannelloInfo, BoxLayout.Y_AXIS));

        JLabel nome = new JLabel("Nome prodotto: " + prodotto.getNome());
        JLabel descrizione = new JLabel(prodotto.getDescrizione());
        JLabel prezzo = new JLabel("Prezzo: " + prodotto.getCosto() + "€");
        JLabel produttore = new JLabel("Produttore: " + produttoreDAO.findByID(prodotto.getIdProduttore()).getNome());
        JLabel categoria = new JLabel("Categoria: " + categoriaDAO.findByID(prodotto.getIdCategoria()).getNome());

        pannelloInfo.add(nome);
        pannelloInfo.add(descrizione);
        pannelloInfo.add(prezzo);
        pannelloInfo.add(produttore);
        pannelloInfo.add(categoria);


        //mostro le foto del prodotto
        JLabel fotoLabel;
        if (fotoDAO.findByProdotto(prodotto.getIdProdotto()).size() > 0) {
            ArrayList<Foto> f = fotoDAO.findByProdotto(prodotto.getIdProdotto());
            //TODO: sistemare input delle foto, l'inserimento del blob non funziona
            //stampo la foto
            try {
                for (Foto foto : f) {
                    JPanel pannelloFoto = new JPanel();
                    pannelloFoto.setLayout(new BoxLayout(pannelloFoto, BoxLayout.Y_AXIS));
                    ImageIcon icon = new ImageIcon(ImageIO.read(foto.getValore().getBinaryStream()));
                    Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    icon = new ImageIcon(image);
                    fotoLabel = new JLabel(icon);
                    pannelloFoto.add(fotoLabel);
                    pannelliFoto.add(pannelloFoto);
                }
            } catch (IOException e) {
                System.out.println("Errore caricamento immagine");
            } catch (SQLException e) {
                System.out.println("Errore caricamento immagine da database");
            }
        } else {
            fotoLabel = new JLabel("Nessuna foto disponibile");
            pannelloInfo.add(fotoLabel);
        }

        //inserisco una tabella di recensioni
        ArrayList<Recensione> recensioni = recensioneDAO.findByProdotto(prodotto.getIdProdotto());
        ArrayList<RecensioniModel> righe = new ArrayList<>();
        for (Recensione recensione : recensioni) {
            RecensioniModel recensioniModel1 = new RecensioniModel();
            recensioniModel1.setRecensione(recensione.getCommento());
            recensioniModel1.setUsernameUtente(utenteDAO.findByID(recensione.getIdUtente()).getUsername());
            recensioniModel1.setIdRecensione(recensione.getIdRecensione());
            recensioniModel1.setVoto(recensione.getVoto());
            recensioniModel1.setData(recensione.getData().toString());
            righe.add(recensioniModel1);
        }

        RecensioniTableModel recensioniTableModel = new RecensioniTableModel(righe);
        JTable recensioniTable = new JTable(recensioniTableModel);
        recensioniTable.setFillsViewportHeight(true);
        recensioniTable.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(recensioniTable);

        //ridimensiono i pannelli per ottenere una migliore visualizzazione
        pannelloInfo.setPreferredSize(new Dimension(500, 100));
        for (JPanel pannelloFoto : pannelliFoto) {
            pannelloFoto.setPreferredSize(new Dimension(100, 100));
        }
        scrollPane.setPreferredSize(new Dimension(500, 100));

        //aggiungo i pannelli al pannello principale
        this.add(pannelloInfo);
        for (JPanel pannelloFoto : pannelliFoto) {
            this.add(pannelloFoto);
        }
        this.add(scrollPane);

        if (AccessoUtente.getTipo() != null) {
            //aggiungo un pulsante per scrivere una recensione
            JButton scriviRecensione = new JButton("Recensisci");
            JPanel pannelloRecensione = new JPanel();
            ScritturaRecensioneListener scritturaRecensioneListener = new ScritturaRecensioneListener(new JPanel(), prodotto);
            scriviRecensione.addActionListener(scritturaRecensioneListener);
            scriviRecensione.setActionCommand(ScritturaRecensioneListener.SR_BTN);
            pannelloRecensione.add(scriviRecensione);
            pannelloRecensione.add(scrollPane);
            this.add(pannelloRecensione);
        }
    }
}
