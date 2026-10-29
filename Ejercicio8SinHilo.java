package concurrente;

public class Ejercicio8SinHilo {

    private static boolean isPrime(int n) {
        int k = 2;
        while (k * k <= n && n % k != 0)
            k++;
        return n >= 2 && k * k > n;
    }

    public static void main(String[] args) {
        int N = 1000000; // Numero hasta el cual contar primos
        int contador = 0;

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= N; i++) {
            if (isPrime(i)) {
                contador++;
            }
        }

        long fin = System.currentTimeMillis();

        System.out.println("Total de numeros primos entre 1 y " + N + ": " + contador);
        System.out.println("Tiempo de ejecucion sin hilos: " + (fin - inicio) + " ms");
    }
}