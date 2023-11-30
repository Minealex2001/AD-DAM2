package utilities;

import com.mongodb.client.MongoCollection;
import db.DBConnection;
import entities.Drivers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;

public class OperacionesCRUDPilotos {
    MongoCollection<Drivers> drivers;
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");

    public OperacionesCRUDPilotos() {
        String username = "alejandro";
        String password = "1234";
        String ip = "ec2-44-217-231-14.compute-1.amazonaws.com";
        String database = "f1-2006";
        drivers = DBConnection.dbConnection(username, password, ip, database);
    }

    public void insertarPiloto(Drivers piloto) {
        try {
            drivers.insertOne(piloto);
        } catch (Exception e) {
            System.out.println("Error al insertar el piloto");
        }
    }

    public void modificarPiloto(Drivers driver) {
        try {
            org.bson.Document updateQuery = new org.bson.Document("$set", new org.bson.Document()
                    .append("driverid", driver.getDriverid())
                    .append("code", driver.getCode())
                    .append("forename", driver.getForename())
                    .append("surname", driver.getSurname())
                    .append("dob", driver.getDob())
                    .append("nationality", driver.getNationality())
                    .append("constructors", new org.bson.Document()
                            .append("constructorref", driver.getConstructors().getConstructorref())
                            .append("name", driver.getConstructors().getName())
                            .append("nationality", driver.getConstructors().getNationality())
                            .append("url", driver.getConstructors().getUrl()))
                    .append("url", driver.getUrl()));
            drivers.updateOne(new org.bson.Document("driverid", driver.getDriverid()), updateQuery);
        } catch (Exception e) {
            System.out.println("Error al modificar el piloto");
        }
    }

    public void eliminarPiloto(Drivers driver) {
        try {
            drivers.deleteMany(eq("code", driver.getCode()));
        } catch (Exception e) {
            System.out.println("Error al eliminar el piloto");
        }
    }

    public void leerPiloto(int driverid) {
        try {
            Drivers driver = drivers.find(eq("driverid", driverid)).first();
            System.out.println(driver);
        } catch (Exception e) {
            System.out.println("Error al leer el piloto");
        }
    }

    public void leerPilotos() {
        try {
            for (Drivers driver : drivers.find()) {
                System.out.println(driver);
            }
        } catch (Exception e) {
            System.out.println("Error al leer los pilotos");
        }
    }

    public void mostrarPilotosOrdenadoresPorEdadDescendente() {
        try {
            List<Drivers> driversList = new ArrayList<>();
            for (Drivers driver : drivers.find()) {
                driversList.add(driver);
            }
            driversList.sort(Comparator.comparing(Drivers::getAgeIn2006).reversed());
            for (Drivers driver : driversList) {
                System.out.println(driver);
            }
        } catch (Exception e) {
            System.out.println("Error al leer los pilotos");
        }
    }

    public void MostrarPilotosConEdadMayorQue(int edad) {
        try {
            List<Drivers> driversList = new ArrayList<>();
            for (Drivers driver : drivers.find()) {
                driversList.add(driver);
            }
            driversList.sort(Comparator.comparing(Drivers::getAgeIn2006).reversed());
            for (Drivers driver : driversList) {
                if (driver.getAgeIn2006() > edad) {
                    System.out.println(driver);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer los pilotos");
        }
    }
}
