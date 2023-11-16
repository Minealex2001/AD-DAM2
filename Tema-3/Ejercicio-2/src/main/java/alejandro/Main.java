package alejandro;

import alejandro.db.DBConnection;
import alejandro.entities.Constructor;
import alejandro.entities.Piloto;
import alejandro.utilities.RoutinesUsage;
import alejandro.utilities.Transaccions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        RoutinesUsage routinesUsage = new RoutinesUsage();
        Transaccions transaccions = new Transaccions();
        String database = "jdbc:postgresql://accesoadatos.cfqcg5f1lvv6.us-east-1.rds.amazonaws.com:5432/f12006";
        String user = "postgres";
        String password = "75123366";
        Connection connection = null;

        connection = createConnection(connection, dbConnection, database, user, password);

//        getDriverStandings(connection, routinesUsage);
//
//        getResultsByDriver(routinesUsage, connection);

        Constructor constructor1 = new Constructor("mclaren", "McLaren", "British", null);
        Piloto piloto1 = new Piloto("nor", "Lando", "Norris", "1999-11-13", "British", constructor1, null);
        Piloto piloto2 = new Piloto("nor", "Daniel", "Ricciardo", "1989-06-01", "Australian", constructor1, null);
        Piloto piloto3 = new Piloto("sai", "Carlos", "Sainz", "1994-09-01", "Spanish", constructor1, null);

        transaccions.transaccion(piloto1, piloto2, connection);
        transaccions.transaccion2(piloto1, piloto3, connection);

        try {
            dbConnection.closeConnection(connection);
        } catch (SQLException e) {
            System.err.println("Error closing the connection.\n Error: " + e.getMessage());
        }

    }

    private static Connection createConnection(Connection connection, DBConnection dbConnection, String database, String user, String password) {
        try {
            connection = dbConnection.dbConnection(database, user, password);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database.\n Error: " + e.getMessage());
        }
        System.out.println("Connection to the database was successful.");
        return connection;
    }

    private static void getDriverStandings(Connection connection, RoutinesUsage routinesUsage) {
        try {
            assert connection != null;
            routinesUsage.getDriverStandings(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getResultsByDriver(RoutinesUsage routinesUsage, Connection connection){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the driver's code: ");
        String code;
        try {
            code = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            routinesUsage.getResultsByDriver(connection, code);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
