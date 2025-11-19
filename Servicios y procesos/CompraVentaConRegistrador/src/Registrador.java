
/**
 * @author 2º DAM-T
 * @version 1.0
 * @since 2025-10-23
 * 
 * Licencia: GNU General Public License v3.0 (GPL-3.0)
 * @see https://www.gnu.org/licenses/gpl-3.0.html
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que crea un proceso servidor para gestionar la conexión por red de los
 * procesos jugadores y atender los mensajes que envíen en hilos separados.
 */
public class Registrador {

    public static void main(String[] args) {

        final int PUERTO = 12345; // Puerto de escucha de conexiones

        try ( /* Crea un socket llamado 'servidor' que escuche en el puerto PUERTO las peticiones de conexión de los jugadores */ 
            ServerSocket servidor = new ServerSocket(PUERTO);        
        ) {
            System.out.println("Servidor escuchando en el puerto " + PUERTO);

            // Bucle infinito para aceptar jugadores de forma concurrente
            while (true) {

                // Acepta una conexión entrante y guárdala en un socket llamado 'socketClienteJugador'
                Socket socketClienteJugador = servidor.accept();
                System.err.println("Registrador: Nuevo jugador conectado desde " + socketClienteJugador.getInetAddress());

                // Crea y lanza un hilo para atender al jugador conectado
                // La lógica de atención al jugador se encuentra en la clase ManejadorRegistroJugador
                Thread jugador = new Thread(new ManejadorRegistroJugador(socketClienteJugador));
                jugador.start();
            }

        } catch (IOException e) {
            System.err.println("Registrador: No se ha podido abrir el puerto de escucha.");
        }
    }
}