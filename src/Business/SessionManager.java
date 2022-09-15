package Business;

import java.util.HashMap;

public class SessionManager {
    public static final String LOGGED_USER = "logged_user";
    private static final HashMap<String, Object> session = new HashMap<>();
    public static HashMap getSession() {
        return session;
    }
}
