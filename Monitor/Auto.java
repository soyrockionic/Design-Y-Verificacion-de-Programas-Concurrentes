package concurrente;

public class Auto implements Runnable {
    private Puente puente;
    private int id;
    
    public Auto(Puente puente, int id) {
        this.puente = puente;
        this.id = id;
    }
    
    @Override
    public void run() {
        puente.entrarPuente(id);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        puente.salirPuente(id);
    }
}