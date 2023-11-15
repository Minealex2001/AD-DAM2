package alejandro.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoutinesUsage {

    public ResultSet getDriverStandings(Connection connection) throws SQLException {
        PreparedStatement select;
        try {
            String query = "SELECT * FROM get_drivers_standings()";
            select = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new SQLException("Error creating the query.\n Error: " + e.getMessage());
        }

        return select.executeQuery();
    }
}
