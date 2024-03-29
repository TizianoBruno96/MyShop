package Views.Model;

import javax.swing.*;

public class CatalogoProdottiModel {
    private int IdProdotto;
    private String nomeProdotto;
    private String descrizione;
    private float costo;
    private String nomeProduttore;
    private String categoriaProdotto;
    private int Disponibilita;
    private int pCorsia;
    private int pScaffale;
    private String commento;
    private int voto;
    private ImageIcon foto;

    public int getIdProdotto() {
        return IdProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        IdProdotto = idProdotto;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getNomeProduttore() {
        return nomeProduttore;
    }

    public void setNomeProduttore(String nomeProduttore) {
        this.nomeProduttore = nomeProduttore;
    }

    public String getCategoriaProdotto() {
        return categoriaProdotto;
    }

    public void setCategoriaProdotto(String categoriaProdotto) {
        this.categoriaProdotto = categoriaProdotto;
    }

    public int getDisponibilita() {
        return Disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        Disponibilita = disponibilita;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public int getpCorsia() {
        return pCorsia;
    }

    public void setpCorsia(int pCorsia) {
        this.pCorsia = pCorsia;
    }

    public int getpScaffale() {
        return pScaffale;
    }

    public void setpScaffale(int pScaffale) {
        this.pScaffale = pScaffale;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
}
