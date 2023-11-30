import entities.Constructor;
import entities.Drivers;
import utilities.OperacionesCRUDPilotos;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        OperacionesCRUDPilotos crud = new OperacionesCRUDPilotos();

        Constructor constructor = new Constructor("1", "McLaren", "British", "http://en.wikipedia.org/wiki/McLaren");
        Drivers piloto = new Drivers(4, "NOR", "Lando", "Norris", java.sql.Date.valueOf(LocalDate.of(1999, 11, 13)), "British", constructor, "http://en.wikipedia.org/wiki/Lando_Norris");
        Drivers piloto2 = new Drivers(4, "RIC", "Daniel", "Ricciardo", java.sql.Date.valueOf(LocalDate.of(1989, 7, 1)), "Australian", constructor, "http://en.wikipedia.org/wiki/Daniel_Ricciardo");
        crud.insertarPiloto(piloto);
//        crud.leerPiloto(4);
        crud.modificarPiloto(piloto2);
//        crud.leerPiloto(4);
//        crud.leerPilotos();
//        crud.mostrarPilotosOrdenadoresPorEdadDescendente();
        crud.MostrarPilotosConEdadMayorQue(30
        );
        crud.eliminarPiloto(piloto);
        crud.dbClose();
    }
}