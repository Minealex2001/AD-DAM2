package principal;

import Utilidades.OperacionesCRUDPilotos;
import f1.Piloto;

import java.sql.SQLException;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws SQLException {
//        int driverId = 39;
//        Piloto pilotoPrueba = new Piloto(39, "NOR", "Lando", "Norris", "1999-11-13", "British", 1, "https://en.wikipedia.org/wiki/Lando_Norris");
//        Piloto pilotoPrueba2 = new Piloto(39, "RIC", "Daniel", "Ricciardo", "1989-07-01", "Australian", 1, "https://en.wikipedia.org/wiki/Daniel_Ricciardo");
//        OperacionesCRUDPilotos.crearPiloto(pilotoPrueba);
//        Piloto pilotoTest = OperacionesCRUDPilotos.leerPiloto(39);
//        System.out.println(pilotoTest);
//        OperacionesCRUDPilotos.actualizarPiloto(pilotoPrueba2, driverId);
//        OperacionesCRUDPilotos.borrarPiloto(39);
//        OperacionesCRUDPilotos.MostrarClasificacionPiloto();
        OperacionesCRUDPilotos.MostrarClasificacionConstructores();
//        List<Piloto> pilotos = OperacionesCRUDPilotos.leerPilotos();
//        for (Piloto piloto : pilotos) {
//            System.out.println(piloto);
//        }
    }
}
