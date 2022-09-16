package Views.Panels;

import ActionListeners.ConfermaAcquistoListener;
import ActionListeners.ConfermaRimozioneListener;
import DAO.CategoriaDAO;
import DAO.FornitoreDAO;
import DAO.Interfaces.*;
import DAO.OrdineServizioDAO;
import Model.*;
import Model.Articoli.*;
import Model.ListaAcquisto;
import Views.AccessoUtente;
import Views.Model.CarrelloProdottiModel;
import Views.Model.CatalogoServiziModel;
import Views.TableModel.CarrelloProdottiTableModel;
import Views.TableModel.CatalogoServiziTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SfogliaCarrello extends JPanel {
    IOrdineServizioDAO ordineServizioDAO = OrdineServizioDAO.getInstance();
    IOrdineProdottoDAO ordineProdottoDAO = DAO.OrdineProdottoDAO.getInstance();
    IServizioDAO servizioDAO = DAO.ServizioDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IFornitoreDAO fornitoreDAO = FornitoreDAO.getInstance();
    IProdottoDAO prodottoDAO = DAO.ProdottoDAO.getInstance();
    IProduttoreDAO produttoreDAO = DAO.ProduttoreDAO.getInstance();
    IListaAcquistoDAO listaAcquistoDAO = DAO.ListaAcquistoDAO.getInstance();
    IFotoDAO fotoDAO = DAO.FotoDAO.getInstance();

    public SfogliaCarrello() {
        if(AccessoUtente.getTipo() == null){
            JOptionPane.showMessageDialog(null, "Non sei loggato");
            return;
        }
        setLayout(new BorderLayout());
        List<CarrelloProdottiModel> righeProdotti = new ArrayList<>();
        List<CatalogoServiziModel> righeServizi = new ArrayList<>();
        ListaAcquisto ls = listaAcquistoDAO.findByID(AccessoUtente.getIdUtente());

        ArrayList<OrdineServizio> ordiniServizio = ordineServizioDAO.findByIDListaAcquisto(ls.getIdListaAcquisto());
        ArrayList<OrdineProdotto> ordiniProdotto = ordineProdottoDAO.findByListaAcquisto(ls.getIdListaAcquisto());
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        ArrayList<Servizio> servizi = new ArrayList<>();

        for (OrdineProdotto o : ordiniProdotto) {
            prodotti.add(prodottoDAO.findByID(o.getIdProdotto()));
        }
        for (OrdineServizio o : ordiniServizio) {
            servizi.add(servizioDAO.findByID(o.getIdServizio()));
        }

        for (Prodotto p : prodotti) {
            Categoria c = categoriaDAO.findByID(p.getIdCategoria());
            Produttore pr = produttoreDAO.findByID(p.getIdProduttore());
            CarrelloProdottiModel riga = new CarrelloProdottiModel();

            riga.setIdProdotto(p.getIdProdotto());
            riga.setNomeProdotto(p.getNome());
            riga.setDescrizione(p.getDescrizione());
            riga.setCosto(p.getCosto());
            riga.setNomeProduttore(pr.getNome());
            riga.setNomeCategoria(c.getNome());
            riga.setQuantita(ordineProdottoDAO.find(p, ls).getQuantita());

            if (fotoDAO.findByProdotto(p.getIdProdotto()).size() > 0) {
                Foto foto = fotoDAO.findByProdotto(p.getIdProdotto()).get(0);
                //TODO: sistemare input delle foto, l'inserimento del blob nel database non funziona
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

            righeProdotti.add(riga);
        }

        for (Servizio s : servizi) {
            CatalogoServiziModel riga = new CatalogoServiziModel();
            Fornitore f = fornitoreDAO.findByID(s.getIdFornitore());
            Categoria c = categoriaDAO.findByID(s.getIdCategoria());

            riga.setIdServizio(s.getIdServizio());
            riga.setNomeServizio(s.getNome());
            riga.setCosto(s.getCosto());
            riga.setFornitore(f.getNome());
            riga.setCategoria(c.getNome());

            righeServizi.add(riga);
        }

        //aggiungo la tabella dei prodotti
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new JLabel("Prodotti"), BorderLayout.NORTH);
        JTable tableProdotti = new JTable(new CarrelloProdottiTableModel(righeProdotti));
        p.add(new JScrollPane(tableProdotti), BorderLayout.CENTER);
        add(p, BorderLayout.WEST);

        //aggiungo la tabella dei servizi
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(new JLabel("Servizi"), BorderLayout.NORTH);
        JTable tableServizi = new JTable(new CatalogoServiziTableModel(righeServizi));
        p2.add(new JScrollPane(tableServizi), BorderLayout.CENTER);
        add(p2, BorderLayout.EAST);

        //mostro il costo totale
        listaAcquistoDAO.updateCostoTot(ls);
        ls = listaAcquistoDAO.findByID(ls.getIdListaAcquisto());
        add(new JLabel("Costo totale: " + ls.getCostoTot()), BorderLayout.SOUTH);

        //aggiungo pulsante di acquisto
        JPanel pannelloAzioni = new JPanel();
        pannelloAzioni.setLayout(new FlowLayout());
        JButton acquista = new JButton("Acquista");
        acquista.setActionCommand(ConfermaAcquistoListener.CAL_BTN);
        ConfermaAcquistoListener confermaAcquistoListener = new ConfermaAcquistoListener();
        acquista.addActionListener(confermaAcquistoListener);
        pannelloAzioni.add(acquista);

        //aggiungo pulsante di rimozione di prodotti e servizi
        JButton rimuovi = new JButton("Rimuovi");
        rimuovi.setActionCommand(ConfermaRimozioneListener.CRL_BTN);
        ConfermaRimozioneListener confermaRimozioneListener = new ConfermaRimozioneListener(tableProdotti, tableServizi);
        rimuovi.addActionListener(confermaRimozioneListener);
        pannelloAzioni.add(rimuovi);

        add(pannelloAzioni, BorderLayout.NORTH);
    }
}
