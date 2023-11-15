package alejandro;

import alejandro.db.DBConnection;
import alejandro.utilities.RoutinesUsage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        RoutinesUsage routinesUsage = new RoutinesUsage();
        String database = "jdbc:postgresql://accesoadatos.cfqcg5f1lvv6.us-east-1.rds.amazonaws.com:5432/f12006";
        String user = "postgres";
        String password = "75123366";
        Connection connection = null;

        try {
            connection = dbConnection.dbConnection(database, user, password);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database.\n Error: " + e.getMessage());
        }
        System.out.println("Connection to the database was successful.");

        try{
            assert connection != null;
            ResultSet resultSet = routinesUsage.getDriverStandings(connection);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("driver_name") + " " + resultSet.getString("points"));
            }
        } catch (SQLException e) {
            System.err.println("Error executing the query.\n Error: " + e.getMessage());
        }

    }
}
