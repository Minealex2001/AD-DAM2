import com.mongodb.client.MongoCollection;
import db.DBConnection;
import entities.Drivers;

import static com.mongodb.client.model.Filters.eq;

public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        String username = "alejandro";
        String password = "1234";
        String ip = "44.217.231.14";
        String database = "f1-2006";
        MongoCollection<Drivers> drivers = dbConnection.dbConnection(username, password, ip, database);
        System.out.println("La colección drivers tiene " + drivers.countDocuments() + " documentos");
    }
}
