package Utilidades;

import f1.Piloto;

import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCRUDPilotos {
    private static final Path pathDB = Path.of("src","main","resources","db","f12006sqlite.db");

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

    public static List<Piloto> leerPilotos() {
        List<Piloto> pilotos = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())) {
            System.out.println("Conexión establecida");
            String sql = "SELECT * FROM drivers";
            PreparedStatement select = conexion.prepareStatement(sql);
            ResultSet resultados = select.executeQuery();
            while (resultados.next()){
                Piloto piloto = new Piloto();
                piloto.setDriverId(resultados.getInt("driverId"));
                piloto.setDriverCode(resultados.getString("driverCode"));
                piloto.setDriverForename(resultados.getString("driverForename"));
                piloto.setDriverSurname(resultados.getString("driverSurname"));
                piloto.setDriverDOB(LocalDate.parse(resultados.getString("driverDOB")));
                piloto.setDriverNationality(resultados.getString("driverNationality"));
                piloto.setConstructorId(resultados.getInt("constructorId"));
                piloto.setUrl(resultados.getString("url"));
                assert false;
                pilotos.add(piloto);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return pilotos;
    }

    public static void actualizarPiloto() {

    }

    public static void borrarPiloto() {

    }
}
