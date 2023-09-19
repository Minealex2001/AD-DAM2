package org.colecciones.entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BookCollection {
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros.
    // ArrayList
    // Crea los métodos solicitados en el enunciado del ejercicio

    ArrayList<Book> biblioteca = new ArrayList<>();

    public void librosmasqui() {
        int total = 0;
        for (Book col : biblioteca) {
            if (col.pages() > 500) {
                total++;
            }
        }
        System.out.println("1. El numero total de libros con más de 300 paginas son: " + total);
    }

    public void librosmastri() {
        int total = 0;
        for (Book col : biblioteca) {
            if (col.pages() < 300) {
                total++;
            }
        }
        System.out.println("2. El numero total de libros con menos de 300 paginas son: " + total);
    }

    public void titulolibrosmasqui() {
        System.out.println("3. El titulo de los libros con más de 500 paginas son: ");
        for (Book col : biblioteca) {
            if (col.pages() > 500) {
                System.out.println(col.title());
            }
        }

    }

    public void titulotresmaspag() {
        System.out.println("4. El titulo de los 3 libros con más paginas son: ");
        biblioteca.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.pages() - o1.pages();
            }
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(biblioteca.get(i).title());
        }

    }

    public void totalpag() {
        int pagtot = 0;
        for (Book col : biblioteca) {
            pagtot += col.pages();
        }
        System.out.println("5. El numero total de paginas son: " + pagtot);
    }

    public void pormpagtit() {
        System.out.println("6. Los libros con más paginas que el pormedio: ");
        int pagtot = 0;
        int totallibros = 0;
        int porm = 0;
        for (Book col : biblioteca) {
            pagtot += col.pages();
            totallibros++;
        }
        porm = pagtot / totallibros;
        for (Book col : biblioteca) {
            if (col.pages() > porm) {
                System.out.println(col.title());
            }
        }
    }

    public void autores() {
        System.out.println("7. Los autores de todos los libros son: ");
        HashMap<String, String> nombre = new HashMap<>();

        for (Book col: biblioteca) {
            if (!nombre.containsKey(col.author())){
                nombre.put(col.author(),col.title());
            }
        }
        for (Map.Entry<String,String> entry : nombre.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    public void autoresmaslibros() {
        System.out.println("8. Los autores con más de un libro son: ");
        HashMap<String, String> nombre = new HashMap<>();
        for (Book col: biblioteca) {
            if (!nombre.containsValue(col.author())){
                nombre.put(col.title(), col.author());
            }
        }
        for (Map.Entry<String,String> entry : nombre.entrySet()){
            if (entry.ge)
        }
    }

    public void libromayor() {
        System.out.println("9. El titulo libro con más paginas: ");
        biblioteca.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.pages() - o2.pages();
            }
        });
        System.out.println(biblioteca.get(0).title());

    }

    public ArrayList<String> colecciontitulos() {
        ArrayList<String> titulos = new ArrayList<String>();
        for (Book col : biblioteca) {
        titulos.add(col.title());
        }
        return titulos;
    }
}

