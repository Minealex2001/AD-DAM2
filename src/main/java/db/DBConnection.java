package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection dbConnection(String URL, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, user, password);
        return connection;
    }
}
