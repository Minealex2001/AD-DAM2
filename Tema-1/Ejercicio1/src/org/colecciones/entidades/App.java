package org.colecciones.entidades;

public class App
{
    public static void main( String[] args )
    {
        BookCollection collection = new BookCollection();
        
        collection.biblioteca.add(new Book("9788422616337", "El Señor de los Anillos", "J.R.R. Tolkien", 800));
        collection.biblioteca.add(new Book("9788445077528", "El Hobbit", "J.R.R. Tolkien", 350));
        collection.biblioteca.add(new Book("9788466316781", "Cabo Trafalgar", "Arturo Pérez Reverte", 320));
        collection.biblioteca.add(new Book("9788493975074", "El corazón de la piedra", "José María García López", 560));
        collection.biblioteca.add(new Book("9788493291488", "Salmos de vísperas", "Esteban Hernández Castelló", 95));
        collection.biblioteca.add(new Book("9788420685625", "La música en las catedrales españolas del Siglo de Oro", "Robert Stevenson", 600));
        collection.biblioteca.add(new Book("9788423913077", "Luces de bohemia", "Ramón del Valle-Inclán", 296));
        collection.biblioteca.add(new Book("9788448031121", "Contando atardeceres", "La vecina rubia", 528));
        collection.biblioteca.add(new Book("9781529342079", "The Master: The Brilliant Career of Roger Federer", "Christopher Clarey", 456));
        collection.biblioteca.add(new Book("9788408264385", "La teoría de los archipiélagos", "Alice Kellen", 300));
        collection.biblioteca.add(new Book("9788423362479", "Esperando al diluvio", "Dolores Redondo", 576));
        collection.biblioteca.add(new Book("9788466367349", "El italiano", "Arturo Pérez Reverte", 400));
        collection.biblioteca.add(new Book("9788466359290", "Línea de fuego", "Arturo Pérez Reverte", 688));

        collection.librosmasqui();
        System.out.println("-----------------------");
        collection.librosmastri();
        System.out.println("-----------------------");
        collection.titulolibrosmasqui();
        System.out.println("-----------------------");
        collection.totalpag();
        System.out.println("-----------------------");
        collection.titulotresmaspag();
        System.out.println("-----------------------");
        collection.pormpagtit();
        System.out.println("-----------------------");
        collection.autores();
        System.out.println("-----------------------");
        collection.autoresmaslibros();
        System.out.println("-----------------------");
        collection.libromayor();
    }
}