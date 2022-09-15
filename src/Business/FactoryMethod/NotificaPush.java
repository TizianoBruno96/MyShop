package Business.FactoryMethod;

public class NotificaPush extends Notifica {
    @Override
    public void inviaNotifica() {
        System.out.println("Notifica inviata via push");
    }
}
