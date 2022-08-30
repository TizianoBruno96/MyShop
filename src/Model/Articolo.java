package Model;

import Business.AbstractFactory.IArticolo;

public class Articolo implements IArticolo {

    private float costo;

    public Articolo() {
        this.costo = 0;
    }

    public Articolo(float costo) {
        this.costo = costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getCosto() {
        return this.costo;
    }
}
