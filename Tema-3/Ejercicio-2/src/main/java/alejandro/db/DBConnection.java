package alejandro.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    /**
     * Creates a connection to the database.
     * @param URL      The URL of the database.
     * @param user     The user of the database.
     * @param password The password of the database.
     * @return A connection to the database.
     * @throws SQLException If the connection fails.
     */
    public Connection dbConnection(String URL, String user, String password) throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}
