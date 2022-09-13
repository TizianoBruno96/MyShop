package Business.Bridge;



public abstract class Documento {
    protected IPdfAPI IPdfAPI;
    public Documento(IPdfAPI IPdfAPI) {
        this.IPdfAPI = IPdfAPI;
    }
    public abstract void invia(String indirizzo);
}
