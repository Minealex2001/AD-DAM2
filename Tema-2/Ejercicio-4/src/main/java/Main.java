import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DatabindException {
        Path ficheroJSON = Path.of(".","src","main","resources","books.json");
        List<Book> bookList = List.of(
                new Book("El Quijote", "Cervantes", "1234", 1605, 2000),
                new Book("El Señor de los Anillos", "Tolkien", "5678", 1954, 1000),
                new Book("El Hobbit", "Tolkien", "9012", 1937, 500)
        );

        escribirJSON(ficheroJSON, bookList);


    }

    private static void escribirJSON(Path ficheroJSON, List<Book> bookList) throws DatabindException {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ficheroJSON.toFile(), bookList);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
