import com.mongodb.client.MongoCollection;
import db.DBConnection;
import entities.Constructor;
import entities.Drivers;
import utilities.OperacionesCRUDPilotos;

import java.time.LocalDate;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;

public class Main {
    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        DBConnection dbConnection = new DBConnection();
        OperacionesCRUDPilotos crud = new OperacionesCRUDPilotos();

        String username = "alejandro";
        String password = "1234";
        String ip = "ec2-44-217-231-14.compute-1.amazonaws.com";
        String database = "f1-2006";
        MongoCollection<Drivers> drivers = dbConnection.dbConnection(username, password, ip, database);

        Constructor constructor = new Constructor("1", "McLaren", "British", "http://en.wikipedia.org/wiki/McLaren");
        Drivers piloto = new Drivers(4, "NOR", "Lando", "Norris", java.sql.Date.valueOf(LocalDate.of(1999, 11, 13)), "British", constructor, "http://en.wikipedia.org/wiki/Lando_Norris");
        crud.insertarPiloto(drivers, piloto);

    }
}
