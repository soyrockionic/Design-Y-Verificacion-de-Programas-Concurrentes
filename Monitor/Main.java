package concurrente;

public class Main {
    
    public static void main(String[] args) {
        Puente puente = new Puente();
        int m = 5;
        
        Thread[] autos = new Thread[m];
        
        for (int i = 1; i <= m; i++) {
            autos[i-1] = new Thread(new Auto(puente, i));
            autos[i-1].start();
        }
        
        for (Thread auto : autos) {
            try {
                auto.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}