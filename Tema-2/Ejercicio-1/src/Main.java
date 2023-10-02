import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        AplanarDirectorios aplanarDirectorios = new AplanarDirectorios(Paths.get("\\wsl.localhost\\kali-linux\\tmp\\niats"));
        aplanarDirectorios.aplanar();
    }
}
