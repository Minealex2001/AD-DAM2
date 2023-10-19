package org.alejandro;

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
    public static void main(String[] args) throws IOException {

    ColecciondeFunkos cFunkos = new ColecciondeFunkos(Path.of(".", "src", "resources", "funkos.csv"));

    //Imprimimos el funko más caro
    System.out.println("El funko más caro es:" + cFunkos.imprimirFunkoMasCaro());

    //Imprimimos los funkos agrupados por modelo
    cFunkos.imprimirFunkoPorModelo();

    //Imprimimos la media de precio de los funkos
    System.out.println("La media de precio de los funkos es: %s€%n" + cFunkos.imprimirMediaPrecio());

    //Imprimimos el numero de funkos que hay de cada modelo
    cFunkos.imprimirNumeroFunkosModelo();

    //Imprimimos el numero de funkos que salen en 2023
    System.out.println("El numero de funkos que salen en 2023 es: " + cFunkos.imprimirNumeroFunkos2023());

    //Serializar el objeto colecciondeFunkos
    cFunkos.serializar(cFunkos);

    //Deserializar el objeto colecciondeFunkos
    cFunkos.desserializar();

    }
}