package principal;

import Utilidades.OperacionesCRUDPilotos;
import f1.Piloto;

import java.util.List;

/**
 * Clase principal para probar el CRUD de pilotos
 */
public class Principal {
    public static void main(String[] args){
        // Prueba de CRUD de pilotos
        int driverId = 39;
        // Crear piloto de prueba
        Piloto pilotoPrueba = new Piloto(39, "NOR", "Lando", "Norris", "1999-11-13", "British", 1, "https://en.wikipedia.org/wiki/Lando_Norris");
        Piloto pilotoPrueba2 = new Piloto(39, "RIC", "Daniel", "Ricciardo", "1989-07-01", "Australian", 1, "https://en.wikipedia.org/wiki/Daniel_Ricciardo");
        // Crear piloto
        OperacionesCRUDPilotos.crearPiloto(pilotoPrueba);
        // Leer piloto
        Piloto pilotoTest = OperacionesCRUDPilotos.leerPiloto(39);
        // Mostrar piloto
        System.out.println(pilotoTest);
        // Actualizar piloto
        OperacionesCRUDPilotos.actualizarPiloto(pilotoPrueba2, driverId);
        // Borrar piloto
        OperacionesCRUDPilotos.borrarPiloto(39);
        // Mostrar clasificación de pilotos
        OperacionesCRUDPilotos.MostrarClasificacionPiloto();
        // Mostrar clasificación de constructores
        OperacionesCRUDPilotos.MostrarClasificacionConstructores();
        // Leer pilotos
        List<Piloto> pilotos = OperacionesCRUDPilotos.leerPilotos();
        // Mostrar pilotos
        for (Piloto piloto : pilotos) {
            System.out.println(piloto);
        }
    }
}
