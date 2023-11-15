import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String database = "accesoadatos.cfqcg5f1lvv6.us-east-1.rds.amazonaws.com";
        String user = "postgres";
        String password = "75123366";

        Connection connection = DBConnection.dbConnection(database, user, password);
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://accesoadatos.cfqcg5f1lvv6.us-east-1.rds.amazonaws.com:3306/accesoadatos", "admin", "admin123")){
            System.out.println("Database connected!");
        } catch (Exception SQLException) {
            System.out.println("Error connecting to the database");
        }
    }
}
