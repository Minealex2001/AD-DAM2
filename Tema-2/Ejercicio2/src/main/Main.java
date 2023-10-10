package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

/*
 * Class MainActivity
 *
 * This class is used to create a main.Main object
 * and run the program.
 * @version 1.0
 * @since 2023-05-10
 * @author Alejandro Sánchez PInto
 * @GitHub <a href="https://github.com/Minealex2001/AD-DAM2">...</a>
 */
public class Main {
    public static void main(String[] args){
        final String COMMA_DELIMITER = ",";
        List<Funko> listaCSV = new ArrayList<>();

        //Leer el fichero de funkos.csv y crear una lista de objetos main.Funko
        try (Stream<String> contenidoFichero = lines(Path.of(".", "src", "resources", "funkos.csv"))) {
             listaCSV = contenidoFichero.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).map(l -> new Funko(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4))).toList();

            //Ordenar la lista por precio
            listaCSV = listaCSV.stream().sorted(Comparator.comparing(Funko::getPrecio)).toList();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        //Imprimimos el funko más caro
        System.out.println("El funko más caro es: " + listaCSV.get(listaCSV.size() - 1).getNombre() + " y cuesta " + listaCSV.get(listaCSV.size() - 1).getPrecio() + "€");

        //Imprimimos los funkos agrupados por modelo
        listaCSV.stream().sorted(Comparator.comparing(Funko::getModelo)).forEach(System.out::println);

        //Imprimimos la media de precio de los funkos
        System.out.printf("La media de precio de los funkos es: %s€%n", listaCSV.stream().mapToDouble(Funko::getPrecio).average().getAsDouble());

        //Imprimimos el numero de funkos que hay de cada modelo
        listaCSV.stream().sorted(Comparator.comparing(Funko::getModelo)).forEach(System.out::println);

        //Imprimimos el numero de funkos que salen en 2023
        System.out.println("El numero de funkos que salen en 2023 es: " + listaCSV.stream().filter(f -> f.getFechaLanzamiento().equals("2023")).count());
    }
}