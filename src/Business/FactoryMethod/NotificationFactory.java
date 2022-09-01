package Business.FactoryMethod;

public class NotificationFactory {
    public enum NotificationType {SMS, PUSH, EMAIL}

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
}