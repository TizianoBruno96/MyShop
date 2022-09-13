package Model.Utenti;

public class Manager {
    int idManager;

    public Manager(int idManager) {
        this.idManager = idManager;
    }

    public Manager() {
        int idManager = 0;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }
}
