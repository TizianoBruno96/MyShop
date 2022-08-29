package DAO;

import Model.ProdottoComposito;

import java.util.ArrayList;

public interface IProdottoCompositoDAO {
    ProdottoComposito findByIDFiglio(int idProdottoFiglio);
    ProdottoComposito findByIDPadre(int idProdottoPadre);
    ArrayList<ProdottoComposito> findAll();
    int add(ProdottoComposito prodottoComposito);
    int removeByIDFiglio(int idProdottoFiglio);
    int removeByIDPadre(int idProdottoPadre);
    int update(ProdottoComposito prodottoComposito);
}
