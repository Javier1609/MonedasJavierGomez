package cambio;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] sistemaMonetario = {1, 4, 6};
        int cantidad = 8;

        Map<Integer, Integer> resultado = CambioDinamico.devolverCambio(sistemaMonetario, cantidad);

        if (resultado != null) {
            System.out.println("Cantidad mínima de monedas: " +
                    resultado.values().stream().mapToInt(i -> i).sum());
            resultado.forEach((moneda, veces) ->
                    System.out.printf("%d moneda(s) de %d€\n", veces, moneda));
        }
    }
}
