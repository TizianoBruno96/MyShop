package Business.FactoryMethod;

public class NotificationFactory {
    public static Notifica getNotification(NotificationType type) {
        switch (type) {
            case SMS:
                return new NotificaSMS();
            case PUSH:
                return new NotificaPush();
            case EMAIL:
                return new NotificaEmail();
            default:
                return null;
        }
    }

    public enum NotificationType {SMS, PUSH, EMAIL}
}