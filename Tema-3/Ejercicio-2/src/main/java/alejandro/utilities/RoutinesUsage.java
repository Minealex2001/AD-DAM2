package alejandro.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contains the methods to use the routines created in the database.
 */
public class RoutinesUsage {

    /**
     * This method calls the routine get_drivers_standings() and prints the results.
     * @param connection Connection to the database.
     * @throws SQLException If there is an error executing the query.
     */
    public void getDriverStandings(Connection connection) throws SQLException {
        PreparedStatement select;
        try {
            String query = "SELECT * FROM get_drivers_standings()";
            select = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new SQLException("Error creating the query.\n Error: " + e.getMessage());
        }
        ResultSet resultSet = select.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("driver") + " " + resultSet.getString("points"));
        }
    }

    /**
     * This method calls the routine get_results_by_driver() and prints the results.
     * @param connection Connection to the database.
     * @param driver Driver to search.
     * @throws SQLException If there is an error executing the query.
     */
    public void getResultsByDriver(Connection connection, String driver) throws SQLException {
        PreparedStatement select;
        try {
            String query = "SELECT * FROM get_results_by_driver(?)";
            select = connection.prepareStatement(query);
            select.setString(1, driver );
        } catch (SQLException e) {
            throw new SQLException("Error creating the query.\n Error: " + e.getMessage());
        }
        ResultSet resultSet = select.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("round") + " | " + resultSet.getString("circuit") + " | " + resultSet.getString("result") +
                                " | " + resultSet.getString("points") + " | " + resultSet.getString("date"));
        }
    }
}
