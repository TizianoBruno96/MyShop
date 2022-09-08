package Business;

import java.util.HashMap;

public class SessionManager {

    public static final String LOGGED_USER = "logged_user";
    public static final String LOGGED_MANAGER = " logged_manager";
    public static final String LOGGED_ADMIN = "logged_admin";
    private static HashMap<String ,Object> session = new HashMap<>();
    public static HashMap getSession(){
        return session;
    }

}
