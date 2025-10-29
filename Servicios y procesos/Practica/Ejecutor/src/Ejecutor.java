import java.io.IOException;

public class Ejecutor {
    public static void main(String[] args) {
        // Comprobación de argumentos
        if (args.length != 1) {
            System.out.println("Uso: java Ejecutor <num_veces>");
            return;
        }

        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("El argumento debe ser un número.");
            return;
        }

        if (n <= 0 || n >= 10) {
            System.out.println("El número debe ser positivo y menor que 10.");
            return;
        }

        // Ejecución de los procesos
        for (int i = 0; i < n; i++) {
            try {
                System.out.println("Ejecución número " + (i + 1));

                // Comando para Windows:
                // Abre una nueva consola y ejecuta los tres procesos conectados por tuberías
                String orden = "cmd /c start cmd /K \"java ProcesoA.java | java ProcesoB.java | java ProcesoC.java";

                // Dividimos la cadena en un array (requerido por exec)
                String[] comando = orden.split(" ");

                // Ejecutamos el comando
                Runtime.getRuntime().exec(comando);

            } catch (IOException e) {
                System.out.println("Error al ejecutar los procesos: " + e.getMessage());
            }
        }
    }
}
