package org.colecciones.entidades;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class BookCollection {
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros.
    // ArrayList
    // Crea los métodos solicitados en el enunciado del ejercicio

    ArrayList<Book> biblioteca = new ArrayList<>();

    public void librosmasqui() {
        long total = biblioteca.stream().filter(p -> p.pages()>500).count();
        System.out.println("1. El numero total de libros con más de 500 paginas son: " + total);
    }

    public void librosmastri() {
        long total = biblioteca.stream().filter(p -> p.pages()<300).count();
        System.out.println("2. El numero total de libros con menos de 300 paginas son: " + total);
    }

    public void titulolibrosmasqui() {
        System.out.println("3. El titulo de los libros con más de 500 paginas son: ");
        biblioteca.stream().filter(p -> p.pages()>500).map(Book::title).forEach(System.out::println);

    }

    public void titulotresmaspag() {
        System.out.println("4. El titulo de los 3 libros con más paginas son: ");
        biblioteca.stream().sorted((p1, p2) -> p2.pages() - p1.pages()).map(Book::title).limit(3).forEach(System.out::println);
    }

    public void totalpag() {
        int pagtot = 0;
        pagtot = biblioteca.stream().mapToInt(Book::pages).sum();
        System.out.println("5. El numero total de paginas son: " + pagtot);
    }

    public void pormpagtit() {
        System.out.println("6. Los libros con más paginas que el pormedio: ");
        //biblioteca.stream().mapToDouble(Book::pages).average().stream().filter(p1 -> )
        biblioteca.stream().filter(p1 -> p1.pages() > biblioteca.stream().collect(Collectors.averagingInt(Book::pages))).map(Book::title).forEach(System.out::println);
    }

    public void autores() {
        System.out.println("7. Los autores de todos los libros son: ");
        //biblioteca.stream().collect(Collectors.groupingBy(Book::author)).forEach(System.out::println);
        biblioteca.stream().map(Book::author).distinct().forEach(System.out::println);
    }

    public void autoresmaslibros() {
        Map<String, Long> authorBookCount = biblioteca.stream().collect(Collectors.groupingBy(Book::author, Collectors.counting()));
        authorBookCount.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(Entry -> System.out.println(Entry.getKey()));
    }

    public void libromayor() {
        System.out.println("9. El titulo del libro con más paginas: ");
        biblioteca.stream().sorted((p1, p2) -> p2.pages() - p1.pages()).map(Book::title).limit(1).forEach(System.out::println);

    }

    public ArrayList<String> colTitles(){
        return new ArrayList<String>(biblioteca.stream().map(Book::title).toList());
    }

    public ArrayList<String> colecciontitulos() {
        ArrayList<String> titulos = new ArrayList<String>();
        for (Book col : biblioteca) {
            titulos.add(col.title());
        }
        return titulos;
    }
}

