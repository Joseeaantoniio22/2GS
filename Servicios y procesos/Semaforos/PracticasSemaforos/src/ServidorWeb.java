// Clase que simula un servidor web que cuenta los accesos realizados desde los clientes
public class ServidorWeb {

  private int cuenta;

  public ServidorWeb() {
    cuenta = 0;
  }

  // Método sincronizado (monitor)
  public void incrementaCuenta() {
    // Muestra el hilo que entra en el método
    System.out.print(
      Thread.currentThread().getName() + " realiza una solicitud al servidor: "
    );
    cuenta++;
    // Cuenta cada acceso al servidor y muestra el número de accesos
    System.out.println(cuenta + " accesos realizados hasta ahora.");
  }
}
