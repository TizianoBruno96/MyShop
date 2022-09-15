package Business;

import DAO.*;
import DAO.Interfaces.*;
import Model.Articoli.Foto;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

public class InserimentoProdottoBusiness {
    private static InserimentoProdottoBusiness instance;
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IPosizioneDAO posizioneDAO = PosizioneDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IFotoDAO fotoDAO = FotoDAO.getInstance();

    public static synchronized InserimentoProdottoBusiness getInstance() {
        if (instance == null) {
            instance = new InserimentoProdottoBusiness();
        }
        return instance;
    }

    public void InserisciProdotto(String nomeProdotto, String descrizione, float costo, String nomeProduttore, String categoriaProdotto, int disponibilita, int pCorsia, int pScaffale, File foto) {
        Produttore pro = produttoreDAO.findByNome(nomeProduttore);
        Categoria c = categoriaDAO.findByNome(categoriaProdotto);
        Prodotto p = new Prodotto(nomeProdotto, descrizione, costo);

        //inserisco il prodotto
        prodottoDAO.add(p, c, pro);
        //TODO idmagazzino da modificare
        posizioneDAO.addProdottoInPosizione(p, pCorsia, pScaffale, 1, disponibilita);
        p = prodottoDAO.findByNome(nomeProdotto);

        //inserisco la foto
        try {
            InputStream inputStream = new FileInputStream(foto);
            Blob blob = new SerialBlob(inputStream.readAllBytes());
            //TODO modificare metodo di inserimento della foto
            Foto foto1 = new Foto(p.getIdProdotto(), blob, "Lavandino");
            fotoDAO.add(foto1);
        } catch (SQLException e) {
            System.out.println("Errore nel database");
        } catch (FileNotFoundException e) {
            System.out.println("Foto non trovata");
        } catch (IOException e) {
            System.out.println("Errore di I/O");
        }
    }
}
