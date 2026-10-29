package concurrente;

public  class HiloMensaje implements Runnable{
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
            System.out.println("Mensaje Recibido: " + mensaje);
            try {
                Thread.sleep(delay); // Pausa entre mensajes
            } catch (InterruptedException e) {
                System.err.println("El hilo fue interrumpido");
            }
        }
    }
}