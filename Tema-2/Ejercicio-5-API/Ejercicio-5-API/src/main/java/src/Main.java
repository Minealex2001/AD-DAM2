package src;

import src.funcionalidad.funcion;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        funcion funcion = new funcion();
        funcion.leerDrivers().forEach(System.out::println);

    }
}
