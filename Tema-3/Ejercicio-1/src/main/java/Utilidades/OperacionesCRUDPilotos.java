package Utilidades;

import f1.Piloto;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCRUDPilotos {
    private static final Path pathDB = Path.of("src","main","resources","db","f12006sqlite.db");

    public static void crearPiloto(Piloto piloto) throws SQLException {
        PreparedStatement insert = null;
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())) {
            String sql = "INSERT INTO drivers (code, forename, surname, dob, nationality, constructorId, url) VALUES (?,?,?,?,?,?,?)";
            insert = conexion.prepareStatement(sql);
            insert.setString(1, piloto.getDriverCode());
            insert.setString(2, piloto.getDriverForename());
            insert.setString(3, piloto.getDriverSurname());
            insert.setString(4, piloto.getDriverDOB().toString());
            insert.setString(5, piloto.getDriverNationality());
            insert.setInt(6, piloto.getConstructorId());
            insert.setString(7, piloto.getUrl());
            insert.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            assert insert != null;
            insert.close();
        }
        System.out.println("Piloto creado");
    }

    public static Piloto leerPiloto(int driverId){

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())) {
            System.out.println("Conexión establecida");
            String sql = "SELECT * FROM drivers WHERE driverId = ?";
            PreparedStatement select = conexion.prepareStatement(sql);
            select.setInt(1, driverId);
            ResultSet resultados = select.executeQuery();
                return new Piloto(
                        resultados.getInt("driverId"),
                        resultados.getString("code"),
                        resultados.getString("forename"),
                        resultados.getString("surname"),
                        resultados.getString("dob"),
                        resultados.getString("nationality"),
                        resultados.getInt("constructorId"),
                        resultados.getString("url"));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static List<Piloto> leerPilotos() {
        List<Piloto> pilotos = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())) {
            System.out.println("Conexión establecida");
            String sql = "SELECT * FROM drivers";
            PreparedStatement select = conexion.prepareStatement(sql);
            ResultSet resultados = select.executeQuery();
            while (resultados.next()){
            pilotos.add(new Piloto(
                    resultados.getInt("driverId"),
                    resultados.getString("code"),
                    resultados.getString("forename"),
                    resultados.getString("surname"),
                    resultados.getString("dob"),
                    resultados.getString("nationality"),
                    resultados.getInt("constructorId"),
                    resultados.getString("url")
            ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Pilotos creados");
        return pilotos;
    }

    public static void actualizarPiloto(Piloto piloto, int driverId) throws SQLException {
        PreparedStatement update = null;
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())){
            String sql = "UPDATE drivers SET code = ?, forename = ?, surname = ?, dob = ?, nationality = ?, constructorId = ?, url = ? WHERE driverId = ?";
            update = conexion.prepareStatement(sql);
            update.setString(1, piloto.getDriverCode());
            update.setString(2, piloto.getDriverForename());
            update.setString(3, piloto.getDriverSurname());
            update.setString(4, piloto.getDriverDOB().toString());
            update.setString(5, piloto.getDriverNationality());
            update.setInt(6, piloto.getConstructorId());
            update.setString(7, piloto.getUrl());
            update.setInt(8, driverId);
            update.executeUpdate();
            System.out.println("Piloto actualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            assert update != null;
            update.close();

        }
    }

    public static void borrarPiloto(int driverId) {
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())){
            System.out.println("Conexión establecida");
            String sql = "DELETE FROM drivers WHERE driverId = ?";
            PreparedStatement delete = conexion.prepareStatement(sql);
            delete.setInt(1, driverId);
            delete.executeUpdate();
            System.out.println("Piloto borrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MostrarClasificacionPiloto(){
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())){
            System.out.println("Conexión establecida");
            String sql = "SELECT d.code, r.points FROM drivers d JOIN results r ON d.driverid = r.driverid GROUP BY d.code ORDER BY r.points DESC";
            PreparedStatement select = conexion.prepareStatement(sql);
            ResultSet resultados = select.executeQuery();
            while (resultados.next()){
                System.out.println(resultados.getString("code") + " " + resultados.getInt("points"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void MostrarClasificacionConstructores(){
        try(Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + pathDB.toString())){
            System.out.println("Conexión establecida");
            String sql = "SELECT c.name, r.points FROM constructors c inner join results r, drivers d ON c.constructorid = r.constructorid GROUP BY c.name ORDER BY r.points DESC";
            PreparedStatement select = conexion.prepareStatement(sql);
            ResultSet resultados = select.executeQuery();
            while (resultados.next()){
                System.out.println(resultados.getString("name") + " " + resultados.getInt("points"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
