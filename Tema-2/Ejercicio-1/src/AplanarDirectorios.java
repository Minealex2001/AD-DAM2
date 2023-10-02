import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class AplanarDirectorios {
    private final Path directorio;

    public AplanarDirectorios(Path directorio) {
        this.directorio = directorio;
    }

    public void aplanar() {
        try(Stream<Path> files = Files.walk(this.directorio).sorted(Comparator.reverseOrder())){
            files.forEach(file -> {
                if (Files.isDirectory(file)) {
                    try {
                        Files.delete(file);
                    } catch (Exception e) {
                        System.out.println("Error al borrar el directorio " + file);
                    }
                }else {
                    try {
                        Files.move(file, this.directorio.resolve(file.getFileName()));
                    } catch (Exception e) {
                        System.out.println("Error al mover el archivo " + file);
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el directorio " + this.directorio);
        }
    }
}
