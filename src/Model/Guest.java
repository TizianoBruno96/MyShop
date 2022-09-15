package Model;

public class Guest {
    private int idGuest;
    private String IPGuest;

    public Guest() {
        this.idGuest = 0;
        this.IPGuest = "";
    }

    public Guest(String IPGuest) {
        this.idGuest = 0;
        this.IPGuest = IPGuest;
    }

    public String getIPGuest() {
        return IPGuest;
    }

    public void setIPGuest(String IPGuest) {
        this.IPGuest = IPGuest;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public String toString() {
        return "IP: " + IPGuest;
    }
}
