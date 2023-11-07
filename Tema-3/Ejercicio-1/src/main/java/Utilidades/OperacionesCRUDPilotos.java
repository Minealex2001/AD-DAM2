package Utilidades;

import f1.Piloto;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperacionesCRUDPilotos {
    static Path pathDB = Path.of("src","main","resources","db","f12006sqlite.db");

    public static void crearPiloto(Piloto piloto) throws SQLException {
        PreparedStatement insert = null;
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())) {
            String sql = "INSERT INTO drivers (driverId, driverCode, driverForename, driverSurname, driverDOB, driverNationality, constructorId, url) VALUES (?,?,?,?,?,?,?,?)";
            insert = conexion.prepareStatement(sql);
            insert.setInt(1, piloto.getDriverId());
            insert.setString(2, piloto.getDriverCode());
            insert.setString(3, piloto.getDriverForename());
            insert.setString(4, piloto.getDriverSurname());
            insert.setString(5, piloto.getDriverDOB().toString());
            insert.setString(6, piloto.getDriverNationality());
            insert.setInt(7, piloto.getConstructorId());
            insert.setString(8, piloto.getUrl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Piloto creado");
            assert insert != null;
            insert.close();
        }


    }

    public static void leerPiloto() {

    }

    public static void actualizarPiloto() {

    }

    public static void borrarPiloto() {

    }
}
