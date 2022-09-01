package Business.FactoryMethod;

public class NotificaEmail extends Notifica {
    @Override
    public void inviaNotifica() {
        System.out.println("Notifica inviata via email");
    }
}
