
public class SimuladorJardín {

  public static void main(String[] args) {
    // Crea un objeto RecursoJardín
    RecursoJardin jardin = new RecursoJardin();

    // Entrada de 10 hilos al jardín
    for (int i = 1; i <= 10; i++) {
      (new PersonaEntrante("Persona entrante " + i, jardin)).start();
    }

    // Salida de 15 hilos del jardín
    for (int i = 1; i <= 15; i++) {
      (new PersonaSaliente("Persona saliente " + i, jardin)).start();
    }
  }
}
