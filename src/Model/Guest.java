package Model;

public class Guest {
    private int idGuest;
    private String IPGuest;

    public Guest() {
        this.idGuest = -1;
        this.IPGuest = "";
    }

    public Guest(int idGuest, String IPGuest) {
        this.idGuest = idGuest;
        this.IPGuest = IPGuest;
    }

    public void setIPGuest(String IPGuest) {
        this.IPGuest = IPGuest;
    }

    public String getIPGuest() {
        return IPGuest;
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
