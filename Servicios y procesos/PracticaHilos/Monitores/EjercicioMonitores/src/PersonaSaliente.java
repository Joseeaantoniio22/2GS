import java.util.Random;

public class PersonaSaliente extends Thread {

  private RecursoJardin jardin;

  public PersonaSaliente(String nombre, RecursoJardin j) {
    this.setName(nombre);
    this.jardin = j;
  }

  @Override
  public void run() {
    try {
      // Establecemos una espera aleatoria para lograr que se mezclen hilos entrantes y salientes  
      Random espera = new Random();
      Thread.sleep(espera.nextInt(501) + 500);
      // Invoca al método que decrementa la cuenta de accesos al jardín
      jardin.decrementaCuenta();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
