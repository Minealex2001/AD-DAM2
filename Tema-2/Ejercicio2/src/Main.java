import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * Class MainActivity
 *
 * This class is used to create a Main object
 * and run the program.
 * @version 1.0
 * @since 2023-05-10
 * @author Alejandro Sánchez PInto
 * @GitHub <a href="https://github.com/Minealex2001/AD-DAM2">...</a>
 */
public class Main {
    public static void main(String[] args){
        final String COMMA_DELIMITER = ",";

        try (Stream<String> contenidoFichero = Files.lines(Path.of(".", "src", "resources", "funkos.csv"))) {
            List<Funko> listaCSV = contenidoFichero.map(l -> Arrays.asList(l.split(COMMA_DELIMITER))).map(l -> new Funko(l.get(0), l.get(1), l.get(2), l.get(3), l.get(4))).toList();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }
}