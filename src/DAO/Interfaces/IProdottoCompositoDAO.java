package DAO.Interfaces;

import Model.Articoli.Prodotto;
import Model.Articoli.ProdottoComposito;

import java.util.ArrayList;

public interface IProdottoCompositoDAO {
    ProdottoComposito find(Prodotto prodottoPadre, Prodotto prodottoFiglio);

    ProdottoComposito find(int idProdottoPadre, int idProdottoFiglio);

    ArrayList<ProdottoComposito> findByIDFiglio(int idProdottoFiglio);

    ArrayList<ProdottoComposito> findByIDPadre(int idProdottoPadre);

    ArrayList<ProdottoComposito> findAll();

    int add(ProdottoComposito prodottoComposito);

    int remove(int idProdottoPadre, int idProdottoFiglio);

    int removeByIDFiglio(int idProdottoFiglio);

    int removeByIDPadre(int idProdottoPadre);

    int update(ProdottoComposito prodottoComposito);
}
