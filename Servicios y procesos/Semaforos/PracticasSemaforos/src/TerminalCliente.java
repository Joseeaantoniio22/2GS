import java.util.Random;
import java.util.concurrent.Semaphore;

// Clase que representa un terminal cliente que simula acceder a un servidor web
public class TerminalCliente extends Thread {

  private ServidorWeb servidor;
  private Semaphore semaforo;

  public TerminalCliente(String nombre, ServidorWeb servidor, Semaphore semaforo) {
    this.setName(nombre);
    this.servidor = servidor;
    this.semaforo = semaforo;
  }

  @Override
  public void run() {
    try {
      Random espera = new Random();
      // Se simulan 10 accesos al servidor
      for (int i = 1; i <= 10; i++) {
        Thread.sleep(espera.nextInt(501) + 500);
        semaforo.acquire();
        servidor.incrementaCuenta();
        semaforo.release();
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
