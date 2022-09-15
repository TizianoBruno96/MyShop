package DBInterface;

public class DBUser {
    private static final DBUser instance = new DBUser();
    private String schemaName;
    private String username;
    private String pwd;

    private DBUser() {
        schemaName = "myshop";
        username = "root";
        pwd = Password.getPwd();
    }

    public static DBUser getInstance() {
        return instance;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
