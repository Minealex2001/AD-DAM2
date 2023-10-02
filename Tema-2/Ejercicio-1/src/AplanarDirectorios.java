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

    public void aplanar(){
        try (Stream<Path> files = Files.walk(this.directorio).sorted(Comparator.reverseOrder())) {
            files.forEach(file -> {
                try {
                    if (!Files.isSameFile(file, this.directorio))
                        if (Files.isDirectory(file))
                            Files.delete(file);
                        else
                            Files.move(file.toAbsolutePath(), this.directorio.resolve(file.getFileName()));
                } catch (IOException e) {
                    System.out.println("Error al mover el archivo " + file.getFileName() + " al directorio " + this.directorio + ".");
                }
            });
        }catch (IOException e) {
            throw new RuntimeException("Error al leer el directorio " + this.directorio + ".");
        }
    }
}
