package concurrente;

import java.util.concurrent.Semaphore;

public class Detector {
    
    private final Semaphore semaforo = new Semaphore(3);
    
    public void usarDetector(int idPersona) {
        try {
            semaforo.acquire();  // Bloquea
            System.out.println("Persona " + idPersona + " usando detector ");
            Thread.sleep(2000);
            System.out.println("Persona " + idPersona + " termino");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaforo.release();  // Libera
        }
    }
    
    public static void main(String[] args) throws InterruptedException {    
        Detector detector = new Detector();
        int n = 10;
        Thread[] p = new Thread[n];
        
        for (int i = 0; i < n; i++) {
            int id = i+1;
            p[i] = new Thread(() -> detector.usarDetector(id));
            p[i].start();
            Thread.sleep(500);
        }
        
        for (Thread thread : p) {
            thread.join();
        }
    }   
}