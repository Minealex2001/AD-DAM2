package org.alejandro;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ColecciondeFunkosMokitoTest {

    @Test
    public void testImprimirNumeroFunkos2023() throws IOException {
        // Crea una instancia de la colección con datos de prueba
        ColecciondeFunkos coleccion = new ColecciondeFunkos(Path.of("path/fake.csv"));

        // Crea una lista de Funkos simulada para el objeto coleccion.listaCSV
        List<Funko> mockFunkos = new ArrayList<>();
        Funko funko1 = Mockito.mock(Funko.class);
        Funko funko2 = Mockito.mock(Funko.class);

        when(funko1.getFechaLanzamiento()).thenReturn("2023");
        when(funko2.getFechaLanzamiento()).thenReturn("2024");

        mockFunkos.add(funko1);
        mockFunkos.add(funko2);

        coleccion.listaCSV = mockFunkos;

        long resultado = coleccion.imprimirNumeroFunkos2023();

        assertEquals(1, resultado);
    }

    @Test
    public void testSerializar() throws IOException {
        // Crear una instancia de la colección con datos de prueba
        ColecciondeFunkos coleccion = new ColecciondeFunkos(Path.of("path/fake.csv"));

        // Crear un mock de ObjectOutputStream
        ObjectOutputStream mockObjectOutputStream = mock(ObjectOutputStream.class);

        try {
            // Redirigir la llamada al constructor de ObjectOutputStream para devolver el mock
            whenNew(ObjectOutputStream.class).withAnyArguments().thenReturn(mockObjectOutputStream);

            // Llamar al método a probar
            boolean resultado = coleccion.serializar(coleccion);

            // Verificar que se llamó al método writeObject
            verify(mockObjectOutputStream, times(1)).writeObject(coleccion);
            assertTrue(resultado);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
