package concurrente;

public class Ejercicio8CincoHilos {

    private static boolean isPrime(int n) {
        int k = 2;
        while (k * k <= n && n % k != 0)
            k++;
        return n >= 2 && k * k > n;
    }

    static class ContadorPrimosThread extends Thread {
        private int inicio, fin, contador;

        public ContadorPrimosThread(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
            this.contador = 0;
        }

        public void run() {
            for (int i = inicio; i <= fin; i++) {
                if (isPrime(i)) {
                    contador++;
                }
            }
        }

        public int getContador() {
            return contador;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int N = 1000000;
        int nroHilos = 5;
        int rango = N / nroHilos;
        
        long inicioTiempo = System.currentTimeMillis();
        
        ContadorPrimosThread[] hilos = new ContadorPrimosThread[nroHilos];

        // Crear y lanzar los hilos
        for (int i = 0; i < nroHilos; i++) {
            int inicio = i * rango + 1;
            int fin = (i == nroHilos - 1) ? N : (inicio + rango - 1);
            hilos[i] = new ContadorPrimosThread(inicio, fin);
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        int totalPrimos = 0;
        for (ContadorPrimosThread hilo : hilos) {
            hilo.join();
            totalPrimos += hilo.getContador();
        }

        long finTiempo = System.currentTimeMillis();

        System.out.println("Total de numeros primos entre 1 y " + N + ": " + totalPrimos);
        System.out.println("Tiempo de ejecucion con 5 hilos: " + (finTiempo - inicioTiempo) + " ms");
    }
}