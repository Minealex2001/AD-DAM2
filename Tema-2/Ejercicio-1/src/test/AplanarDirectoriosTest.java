package test;

import org.junit.jupiter.api.Test;
import src.*;

import java.nio.file.Path;

public class AplanarDirectoriosTest {

    @Test
    public void aplanar_directorio_vacio() throws IOException {
        Path directorio = Path.of("C:/aTemporal/niats");
        AplanarDirectorios aplanarDirectorios = new AplanarDirectorios(directorio);
        aplanarDirectorios.aplanar();

        assertTrue(directorio.isEmpty());
    }

    @Test
    public void aplanar_directorio_con_archivos() throws IOException {
        Path directorio = Path.of("C:/aTemporal/niats");
        directorio.mkdir(parents=true, exist_ok=true);

        Path archivo1 = directorio.resolve("archivo1.txt");
        Files.createFile(archivo1);

        Path archivo2 = directorio.resolve("archivo2.txt");
        Files.createFile(archivo2);

        AplanarDirectorios aplanarDirectorios = new AplanarDirectorios(directorio);
        aplanarDirectorios.aplanar();

        assertTrue(archivo1.exists());
        assertTrue(archivo2.exists());
    }

    @Test
    public void aplanar_directorio_con_subdirectorios() throws IOException {
        Path directorio = Path.of("C:/aTemporal/niats");
        directorio.mkdir(parents=true, exist_ok=true);

        Path subdirectorio = directorio.resolve("subdirectorio");
        subdirectorio.mkdir();

        Path archivo1 = subdirectorio.resolve("archivo1.txt");
        Files.createFile(archivo1);

        Path archivo2 = subdirectorio.resolve("archivo2.txt");
        Files.createFile(archivo2);

        AplanarDirectorios aplanarDirectorios = new AplanarDirectorios(directorio);
        aplanarDirectorios.aplanar();

        assertTrue(archivo1.exists());
        assertTrue(archivo2.exists());
    }
}
