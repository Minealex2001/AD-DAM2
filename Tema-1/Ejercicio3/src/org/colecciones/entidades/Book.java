package org.colecciones.entidades;

import java.util.Comparator;

public record Book(String isbn, String title, String author, int pages) implements Comparable<Book>{

    @Override
    public int compareTo(Book o) {
        return this.title().compareTo(o.title);
    }
}