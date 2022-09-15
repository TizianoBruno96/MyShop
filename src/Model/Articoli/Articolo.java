package Model.Articoli;

import Business.AbstractFactory.IArticolo;

public class Articolo implements IArticolo {

    private float costo;

    public Articolo() {
        this.costo = 0.0f;
    }

    public Articolo(float costo) {
        this.costo = costo;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
