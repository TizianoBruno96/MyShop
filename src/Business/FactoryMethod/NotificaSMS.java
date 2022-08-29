package Business.FactoryMethod;

public class NotificaSMS extends Notifica {
    @Override
    public void inviaNotifica() {
        System.out.println("Notifica inviata via SMS");
    }
}
