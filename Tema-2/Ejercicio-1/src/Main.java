import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Path> listaArchivos = Files.walk(Paths.get("/tmp/niats")).toList();
        listaArchivos.stream().findAny();
    }
}
