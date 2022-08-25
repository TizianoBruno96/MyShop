package ModelFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IFactory<T> {
    T create(ResultSet rs) throws SQLException;
}