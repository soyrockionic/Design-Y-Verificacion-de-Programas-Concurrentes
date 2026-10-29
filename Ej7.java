package concurrente;

public class Ej7{

   private static class HiloMensaje extends Thread {
        private String mensaje;
        private int repeticiones;
        private int delay;

        public HiloMensaje(String mensaje, int repeticiones, int delay) {
            this.mensaje = mensaje;
            this.repeticiones = repeticiones;
            this.delay = delay;
        }

        @Override
        public void run() {
            for (int i = 0; i < repeticiones; i++) {
                System.out.println("Mensaje Recibido: " + mensaje + " " + i);
                try {
                    Thread.sleep(delay); // Pausa entre mensajes
                } catch (InterruptedException e) {
                    System.err.println("El hilo fue interrumpido");
                }
            }
        }
    }
   
    public static void main(String[] args) throws InterruptedException {
        int k = 5; // Numero de repeticiones

        HiloMensaje hiloPing = new HiloMensaje("Ping", k, 500); // 500 ms delay
        HiloMensaje hiloPong = new HiloMensaje("Pong", k, 800); // 800 ms delay

        hiloPing.start();
        hiloPong.start();      
    }
 
}