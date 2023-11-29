package utilities;

import com.mongodb.client.MongoCollection;
import entities.Drivers;

import java.util.logging.Logger;

public class OperacionesCRUDPilotos {
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");

    public void insertarPiloto(MongoCollection<Drivers> drivers, Drivers piloto){
        try {
            drivers.insertOne(piloto);
        }catch (Exception e){
            System.out.println("Error al insertar el piloto");
        }
    }
}
