package Business;

import DAO.CategoriaDAO;
import DAO.FotoDAO;
import DAO.Interfaces.ICategoriaDAO;
import DAO.Interfaces.IFotoDAO;
import DAO.Interfaces.IProdottoDAO;
import DAO.Interfaces.IProduttoreDAO;
import DAO.ProdottoDAO;
import DAO.ProduttoreDAO;
import Model.Articoli.Foto;
import Model.Articoli.Prodotto;
import Model.Articoli.Produttore;
import Model.Categoria;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class InserimentoProdottoBusiness {
    private static InserimentoProdottoBusiness instance;
    IProdottoDAO prodottoDAO = ProdottoDAO.getInstance();
    IProduttoreDAO produttoreDAO = ProduttoreDAO.getInstance();
    ICategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
    IFotoDAO fotoDAO = FotoDAO.getInstance();

    public static synchronized InserimentoProdottoBusiness getInstance() {
        if (instance == null) {
            instance = new InserimentoProdottoBusiness();
        }
        return instance;
    }

    public void InserisciProdotto(String nomeProdotto, String descrizione, float costo, String nomeProduttore, String categoriaProdotto, String fotopath, String nomeFoto) {
        Produttore pro = produttoreDAO.findByNome(nomeProduttore);
        Categoria c = categoriaDAO.findByNome(categoriaProdotto);
        Prodotto p = new Prodotto(nomeProdotto, descrizione, costo);

        //inserisco il prodotto
        prodottoDAO.add(p, c, pro);
        p = prodottoDAO.findByNome(nomeProdotto);

        //TODO inserimento foto non funzionante
        //inserisco la foto
        if (fotopath != null && nomeFoto != null) {
            try (FileInputStream inputStream = new FileInputStream(fotopath)) {
                Blob blob = new SerialBlob(inputStream.readAllBytes());
                Foto foto1 = new Foto(p.getIdProdotto(), blob, nomeFoto);
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
}
