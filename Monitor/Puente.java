package concurrente;

public class Puente {
    
    private int cant = 0;
    
    public synchronized void entrarPuente(int id) {
        while (cant > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        cant = cant + 1;
        System.out.println("Auto " + id + " cruzando el puente");
    }
    
    public synchronized void salirPuente(int id) {
        cant = cant - 1;
        System.out.println("Auto " + id + " salio del puente");
        notifyAll();
    }
}