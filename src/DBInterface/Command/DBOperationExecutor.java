package DBInterface.Command;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBOperationExecutor {

    private final List<IDBOperation> DBOperationList = new ArrayList<>();

    public DBOperationResult executeOperation(IDBOperation operation) {
        DBOperationList.add(operation);
        return operation.execute();
    }
}
