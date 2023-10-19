import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path ficheroJSON = Path.of(".","src","main","resources","books.json");
        List<Book> bookList = new ArrayList<>(){{
                add(new Book("El Quijote", "Cervantes", 1234, 1605, 2000));
                add(new Book("El Señor de los Anillos", "Tolkien", 5678, 1954, 1000));
                add(new Book("El Hobbit", "Tolkien", 9012, 1937, 500));
        }};
        menu(bookList);
        escribirJSON(ficheroJSON, bookList);
        List<Book> jsonDeserializado = leerJSON(ficheroJSON);
    }

    private static void menu(List<Book> bookList) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        do{
        System.out.println("Bienvenido a la biblioteca");
        System.out.println("1. Añadir libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Mostrar todos los libros");
        System.out.println("4. Salir");
        System.out.print("Opcion: ");
        opcion = Integer.parseInt(br.readLine());
        switch (opcion) {
            case 1:
                System.out.println("Introduce el título del libro :");
                String titulo = br.readLine();
                System.out.println("Introduce el autor del libro:");
                String autor = br.readLine();
                System.out.println("Introduce el ISBN del libro:");
                int isbn = Integer.parseInt(br.readLine());
                System.out.println("Introduce el año del libro:");
                int year = Integer.parseInt(br.readLine());
                System.out.println("Introduce el número de páginas del libro :");
                int pages = Integer.parseInt(br.readLine());
                bookList.add(new Book(titulo, autor, isbn, year, pages));
                break;
            case 2:
                System.out.println("Quieres buscar por titulo o por autor?");
                String busqueda = br.readLine();
                switch (busqueda) {
                    case "titulo":
                        System.out.println("Introduce el título del libro :");
                        String tituloBusqueda = br.readLine();
                        System.out.println(buscarLibroPorTituloOAutor(tituloBusqueda, null, bookList));
                        break;
                    case "autor":
                        System.out.println("Introduce el autor del libro :");
                        String autorBusqueda = br.readLine();
                        System.out.println(buscarLibroPorTituloOAutor(null, autorBusqueda, bookList));
                        break;
                }
                break;
            case 3:
                for (Book books : bookList) {
                    System.out.println(books.toString());
                }
                break;
            default:
                break;
        }
        }while (opcion != 4) ;
    }

    private static List<Book> leerJSON(Path ruta) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(ruta.toFile(), new TypeReference<List<Book>>() {
        });
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

    private static String buscarLibroPorTituloOAutor(String titulo, String autor, List<Book> bookList) {
        for (Book book : bookList) {
            if (book.getTitle().equals(titulo) || book.getAuthor().equals(autor)) {
                return book.toString();
            }
        }
        return null;
    }
}
