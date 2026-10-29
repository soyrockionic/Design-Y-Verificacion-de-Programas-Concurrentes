package concurrente;

public class Ejercicio8DosHilos {
    
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
        int mitad = N / 2;

        long inicioTiempo = System.currentTimeMillis();

        // Crear dos hilos para dividir el trabajo
        ContadorPrimosThread hilo1 = new ContadorPrimosThread(1, mitad);
        ContadorPrimosThread hilo2 = new ContadorPrimosThread(mitad + 1, N);

        hilo1.start();
        hilo2.start();

        // Esperar a que ambos hilos terminen
        hilo1.join();
        hilo2.join();

        int totalPrimos = hilo1.getContador() + hilo2.getContador();

        long finTiempo = System.currentTimeMillis();

        System.out.println("Total de numeros primos entre 1 y " + N + ": " + totalPrimos);
        System.out.println("Tiempo de ejecucion con 2 hilos: " + (finTiempo - inicioTiempo) + " ms");
    }
}