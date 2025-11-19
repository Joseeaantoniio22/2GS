
/**
 * @author 2º DAM-T
 * @version 1.0
 * @since 2025-10-23
 *
 * Licencia: GNU General Public License v3.0 (GPL-3.0)
 * @see https://www.gnu.org/licenses/gpl-3.0.html
 */
import java.io.*;
import java.net.*;

/**
 * Clase que gestiona la comunicación con un solo jugador y guarda en un fichero
 * los mensajes que va recibiendo de él.
 */
class ManejadorRegistroJugador implements Runnable {

    final String REGISTRO = ".." + File.separator + "registro.txt"; // Fichero de registro de mensajes

    private Socket canalComunicación;
    private BufferedReader flujoEntrada;

    public ManejadorRegistroJugador(Socket socket) {
        this.canalComunicación = socket;
    }

    @Override
    public void run() {
        try {
            try {
                // Redirigimos la salida estándar al fichero de registro
                PrintStream ps = new PrintStream(
                        new BufferedOutputStream(new FileOutputStream(new File(REGISTRO), false)), true);
                System.setOut(ps);
            } catch (Exception e) {
                System.err.println("Registrador: No se ha podido redirigir la salida al fichero de registro.");
                throw new Exception("Error redirigiendo la salida estándar.");
            }

            //Asigna al objeto 'flujoEntrada' un BufferedReader que se cree a partir de un InputStreamReader.
            //Este InputStreamReader se creará, a su vez, a partir del flujo de entrada (InputStream) del socket 'canalComunicación' 
            flujoEntrada = new BufferedReader(new InputStreamReader(canalComunicación.getInputStream()));
            String mensajeEntrada; // Valores que iremos leyendo de 'canalComunicación'

            // Crea un bucle para leer mensajes de 'flujoEntrada' mientras haya datos disponibles (es decir, mientras readLine() no devuelva null)
            // Cuando llegen datos, guárdalos en el archivo de registro con un simple println. Imprímelos también por consola.
            while ((mensajeEntrada = flujoEntrada.readLine()) != null) {
                System.out.println(mensajeEntrada);
                System.out.println("Mensaje recibido: " + mensajeEntrada);
            }
        } catch (IOException ex) {
            System.err.println("Registrador: No se ha podido establecer conexión con el jugador "
                    + canalComunicación.getInetAddress());

        } catch (Exception ex) {
            System.err.println(
                    "Registrador: Error redirigiendo la salida estándar al fichero de registro para el jugador ");

        } finally {
            // Nos aseguramos de que se cierran los recursos que estamos utilizando
            if (flujoEntrada != null)
                try {
                flujoEntrada.close();
            } catch (IOException ex) {
                System.err.println("Registrador: No se ha podido cerrar el BufferedReader.");
            }
            if (canalComunicación != null)
                try {
                canalComunicación.close();
            } catch (IOException ex) {
                System.err.println("Registrador: No se ha podido cerrar el canal de comunicación.");
            }
        }
    }
}
