package org.alejandro;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class ColecciondeFunkos implements Serializable {
    final String COMMA_DELIMITER = ",";
    List<Funko> listaCSV = new ArrayList<>();
    public ColecciondeFunkos(Path path) throws IOException{
        //Leer el fichero de funkos.csv y crear una lista de objetos main.Funko
        try (
                Stream<String> contenidoFichero = lines(Path.of(".", "src", "resources", "funkos.csv"))) {
            listaCSV = contenidoFichero.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).skip(1).map(l -> new Funko(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4))).toList();

            //Ordenar la lista por precio
            listaCSV = listaCSV.stream().sorted(Comparator.comparing(Funko::getPrecio)).toList();
        } catch (
                IOException e) {
            e.printStackTrace(System.out);
        }
    }


    //Imprimimos el funko más caro
    public String imprimirFunkoMasCaro() {
        return "El funko más caro es: " + listaCSV.get(listaCSV.size() - 1).getNombre() + " y cuesta " + listaCSV.get(listaCSV.size() - 1).getPrecio() + "€";
    }

    //Imprimimos los funkos agrupados por modelo
    public void imprimirFunkoPorModelo() {
        listaCSV.stream().sorted(Comparator.comparing(Funko::getModelo)).forEach(System.out::println);
    }
    //Imprimimos la media de precio de los funkos
    public double imprimirMediaPrecio() {
        return listaCSV.stream().mapToDouble(Funko::getPrecio).average().getAsDouble();
    }
    //Imprimimos el numero de funkos que hay de cada modelo
    public void imprimirNumeroFunkosModelo() {
        listaCSV.stream().sorted(Comparator.comparing(Funko::getModelo)).forEach(System.out::println);
    }

    //Imprimimos el numero de funkos que salen en 2023
    public long imprimirNumeroFunkos2023() {
    return listaCSV.stream().filter(f -> f.getFechaLanzamiento().equals("2023")).count();
    };

    public boolean serializar(ColecciondeFunkos colecciondeFunkos) {
        boolean serializado = false;
        try(FileOutputStream fos = new FileOutputStream(Path.of(".", "src", "resources", "funkos.dat").toString());
            //Serializar el objeto colecciondeFunkos
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(colecciondeFunkos);
            serializado = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return serializado;
    }

    public static ColecciondeFunkos desserializar(){
        ColecciondeFunkos coleccionFunkos = null;
        try(FileInputStream fis = new FileInputStream(Path.of(".", "src", "resources", "funkos.dat").toString());
            //Serializar el objeto colecciondeFunkos
            ObjectInputStream ois = new ObjectInputStream(fis)){
            coleccionFunkos = (ColecciondeFunkos) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return coleccionFunkos;
    }


}
