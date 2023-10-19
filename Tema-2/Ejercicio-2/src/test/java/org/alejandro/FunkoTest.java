package org.alejandro;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FunkoTest {

    @Test
    public void testConstructor() {
        String id = "1";
        String nombre = "Funko1";
        String modelo = "Modelo1";
        String precioString = "10.50";
        String fechaLanzamiento = "2023-01-01";

        Funko funko = new Funko(id, nombre, modelo, precioString, fechaLanzamiento);

        assertEquals(id, funko.getId());
        assertEquals(nombre, funko.getNombre());
        assertEquals(modelo, funko.getModelo());
        assertEquals(10.50, funko.getPrecio(), 0.01);
        assertEquals(fechaLanzamiento, funko.getFechaLanzamiento());
    }

    @Test
    public void testConstructorWithInvalidPrice() {
        String id = "2";
        String nombre = "Funko2";
        String modelo = "Modelo2";
        String precioString = "invalid";
        String fechaLanzamiento = "2023-01-01";

        Funko funko = new Funko(id, nombre, modelo, precioString, fechaLanzamiento);

        assertEquals(id, funko.getId());
        assertEquals(nombre, funko.getNombre());
        assertEquals(modelo, funko.getModelo());
        assertEquals(0.0, funko.getPrecio(), 0.01); // Precio debería ser 0.0 debido al valor inválido.
        assertEquals(fechaLanzamiento, funko.getFechaLanzamiento());
    }

    @Test
    public void testToString() {
        String id = "3";
        String nombre = "Funko3";
        String modelo = "Modelo3";
        String precioString = "15.75";
        String fechaLanzamiento = "2023-01-01";

        Funko funko = new Funko(id, nombre, modelo, precioString, fechaLanzamiento);

        String expectedToString = "main.Funko{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + 15.75 +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';

        assertEquals(expectedToString, funko.toString());
    }
}
