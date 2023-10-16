package org.alejandro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ColecciondeFunkosTest {

    private ColecciondeFunkos coleccion;

    @BeforeEach
    void setUp() {
        try {
            // Asegúrate de que tienes un archivo "funkos.csv" válido en la ubicación especificada.
            coleccion = new ColecciondeFunkos(Path.of(".", "src", "resources", "funkos.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testImprimirFunkoMasCaro() {
        String resultado = coleccion.imprimirFunkoMasCaro();
        assertNotNull(resultado);
        assertTrue(resultado.contains(" y cuesta "));
    }

    @Test
    public void testImprimirFunkoPorModelo() {
        // Agrega aserciones para verificar la salida de este método
        // (puedes redirigir la salida estándar a un ByteArrayOutputStream si es necesario).
    }

    @Test
    public void testImprimirMediaPrecio() {
        double media = coleccion.imprimirMediaPrecio();
        // Define un valor esperado en función de los datos de prueba en "funkos.csv".
        double valorEsperado = 0;
        assertEquals(valorEsperado, media, 0.01);
    }

    @Test
    public void testImprimirNumeroFunkosModelo() {
        // Agrega aserciones para verificar la salida de este método
        // (puedes redirigir la salida estándar a un ByteArrayOutputStream si es necesario).
    }

    @Test
    public void testImprimirNumeroFunkos2023() {
        long cantidad = coleccion.imprimirNumeroFunkos2023();
        // Define un valor esperado en función de los datos de prueba en "funkos.csv".
        short valorEsperado = 0;
        assertEquals(valorEsperado, cantidad);
    }

    @Test
    public void testSerializarYDesserializar() {
        // Realiza la serialización y deserialización de la colección.
        boolean serializado = coleccion.serializar(coleccion);
        assertEquals(true, serializado);

        ColecciondeFunkos deserializedColeccion = ColecciondeFunkos.desserializar();
        assertNotNull(deserializedColeccion);
        // Agrega aserciones para comparar la colección original con la desserializada.
    }
}
