package Cambio;

import cambio.CambioDinamico;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CambioDinamicoTest {

    @Test
    void testCambioExacto() {
        int[] monedas = {1, 4, 6};
        int cantidad = 8;

        Map<Integer, Integer> resultado = CambioDinamico.devolverCambio(monedas, cantidad);
        assertNotNull(resultado);
        assertEquals(2, resultado.values().stream().mapToInt(i -> i).sum());
    }

    @Test
    void testCantidadNoPosible() {
        int[] monedas = {5, 10};
        int cantidad = 3;

        Map<Integer, Integer> resultado = CambioDinamico.devolverCambio(monedas, cantidad);
        assertNull(resultado);
    }

    @Test
    void testSoloUnaMoneda() {
        int[] monedas = {2};
        int cantidad = 6;

        Map<Integer, Integer> resultado = CambioDinamico.devolverCambio(monedas, cantidad);
        assertNotNull(resultado);
        assertEquals(3, resultado.get(2));
    }
}
