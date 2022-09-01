package DBInterface;

public class DBUser {
    private static DBUser instance = new DBUser();
    private String schemaName;
    private String username;
    private String pwd;

    private DBUser() {
        schemaName = "myshop";
        username = "root";
        pwd = "Der0net09620.";
    }

    public static DBUser getInstance() {
        return instance;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}
