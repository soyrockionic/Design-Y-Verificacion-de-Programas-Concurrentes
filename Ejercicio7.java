package concurrente;

public class Ejercicio7 {
    
    public static void main(String[] args) {
        int k = 5; // Numero de repeticiones

        // Crear hilos con diferentes delays
        Thread hiloPing = new Thread(new HiloMensaje("Ping", k, 500)); // 500 ms delay
        Thread hiloPong = new Thread(new HiloMensaje("Pong", k, 800)); // 800 ms delay

        // Iniciar los hilos
        hiloPing.start();
        hiloPong.start();
        
    }
    
}