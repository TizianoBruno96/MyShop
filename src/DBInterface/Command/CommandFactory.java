package DBInterface.Command;

public class CommandFactory {
    public static IDBOperation getCommand(CommandType type, String sql) {
        switch (type) {
            case WRITE:
                return new WriteOperation(sql);
            case READ:
                return new ReadOperation(sql);
            case UPDATE:
                return new UpdateOperation(sql);
            case REMOVE:
                return new RemoveOperation(sql);
            default:
                return null;
        }
    }

    public enum CommandType {
        WRITE,
        READ,
        UPDATE,
        REMOVE
    }
}
