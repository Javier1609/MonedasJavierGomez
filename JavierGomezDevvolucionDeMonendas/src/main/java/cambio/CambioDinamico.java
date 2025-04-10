package cambio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CambioDinamico {

    public static Map<Integer, Integer> devolverCambio(int[] monedas, int cantidad) {
        int[] dp = new int[cantidad + 1];
        int[] ruta = new int[cantidad + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= cantidad; i++) {
            for (int moneda : monedas) {
                if (i - moneda >= 0 && dp[i - moneda] != Integer.MAX_VALUE) {
                    if (dp[i - moneda] + 1 < dp[i]) {
                        dp[i] = dp[i - moneda] + 1;
                        ruta[i] = moneda;
                    }
                }
            }
        }

        if (dp[cantidad] == Integer.MAX_VALUE) {
            System.out.println("No es posible devolver esa cantidad con las monedas disponibles.");
            return null;
        }

        Map<Integer, Integer> resultado = new HashMap<>();
        int valorRestante = cantidad;

        while (valorRestante > 0) {
            int monedaUsada = ruta[valorRestante];
            resultado.put(monedaUsada, resultado.getOrDefault(monedaUsada, 0) + 1);
            valorRestante -= monedaUsada;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] sistemaMonetario = {1, 4, 6};
        int cantidad = 8;

        Map<Integer, Integer> cambio = devolverCambio(sistemaMonetario, cantidad);

        if (cambio != null) {
            System.out.println("Cantidad mínima de monedas: " + cambio.values().stream().mapToInt(i -> i).sum());
            System.out.println("Distribución de monedas:");
            cambio.forEach((moneda, cantidadMonedas) ->
                    System.out.println(cantidadMonedas + " moneda(s) de " + moneda + "€")
            );
        }
    }
}
