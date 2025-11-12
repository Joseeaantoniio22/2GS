
import java.util.concurrent.Semaphore;

public class SimuladorAccesos {

  public static void main(String[] args) {
    // Crea un objeto ServidorWeb
    ServidorWeb servidor = new ServidorWeb();

    Semaphore semaforo = new Semaphore(1);
    // Se crean cuatro hilos
    TerminalCliente terminal1 = new TerminalCliente(
      "Terminal cliente 1",
      servidor,
      semaforo
    );
    TerminalCliente terminal2 = new TerminalCliente(
      "Terminal cliente 2",
      servidor,
      semaforo
    );
    TerminalCliente terminal3 = new TerminalCliente(
      "Terminal cliente 3",
      servidor,
      semaforo
    );
    TerminalCliente terminal4 = new TerminalCliente(
      "Terminal cliente 4",
      servidor,
      semaforo
    );

    // Se inician los cuatro hilos
    terminal1.start();
    terminal2.start();
    terminal3.start();
    terminal4.start();
  }
}
