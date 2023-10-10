package test;

import main.Funko;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Funko funkoTestUno, funkoTestDos;
    List<Funko> funkos = new ArrayList<Funko>();

    @Test
    @BeforeEach
    public void iniciar(){

        //instanciamos dos funkos para las pruebas, y las añadimos a una lista
        funkoTestUno = new Funko(Arrays.asList("15884fed", "Julen", "MARVEL", "44.15", "2023-03-01"));
        funkoTestDos = new Funko(Arrays.asList("15884fed", "Capitan America", "DISNEY", "88.50", "2020-12-08"));

        funkos.add(funkoTestUno);
        funkos.add(funkoTestDos);
    }

    @Test
    void testFunkoMasCaro() {
        //comparamos que sea igual el funko mas caro con el que nos devuelve el metodo
        assertEquals(funkoTestDos, Main.funkoMasCaro(funkos));
    }

    @Test
    void mediaPrecioFunkos() {
        //calculamos la media redondeando los decimales a solo dos
        double media = (double)(Math.round(((funkoTestDos.getPrecio() + funkoTestUno.getPrecio())/2)*100)/100);
        //comparamos la media correcta con la media que nos tiene que devolver el metodo
        assertEquals(media, Main.mediaPrecioFunkos(funkos));
    }

    @Test
    void funkosAgrupadosPorModelos() {

        HashMap<String, List<Funko>> mapTest = new HashMap<String, List<Funko>>();
        mapTest.put(funkoTestUno.getModelo(), new ArrayList<Funko>(Arrays.asList(funkoTestUno)));
        mapTest.put(funkoTestDos.getModelo(), new ArrayList<Funko>(Arrays.asList(funkoTestDos)));

        assertEquals(mapTest, Main.funkosAgrupadosPorModelos(funkos));
    }

    @Test
    void cantidadFunkos2023() {
        assertEquals(1, Main.cantidadFunkos2023(funkos));

    }

}

