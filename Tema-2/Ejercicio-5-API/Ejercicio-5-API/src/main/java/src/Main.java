package src;

import src.funcionalidad.Funcion;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Funcion funcion = new Funcion();
        Path ficheroJSON = Path.of("src/main/resources/drivers.json");
        Funcion.escribirJSON(ficheroJSON);

    }
}
