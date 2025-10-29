import java.io.*;

public class ProcesoD {
    public static void main(String[] args) {
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

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("\n=== EJECUCIÓN " + (i + 1) + " ===");

                // Crear los tres procesos
                Process pA = Runtime.getRuntime().exec("java ProcesoA");
                Process pB = Runtime.getRuntime().exec("java ProcesoB");
                Process pC = Runtime.getRuntime().exec("java ProcesoC");

                // Conectar A → B → C
                conectarProcesos(pA.getInputStream(), pB.getOutputStream());
                conectarProcesos(pB.getInputStream(), pC.getOutputStream());

                // Mostrar la salida del proceso C
                mostrarSalida(pC);

                // Esperar a que todos terminen
                pA.waitFor();
                pB.waitFor();
                pC.waitFor();

            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    // Conecta la salida de un proceso con la entrada de otro
    private static void conectarProcesos(InputStream in, OutputStream out) {
        new Thread(() -> {
            try {
                int dato;
                while ((dato = in.read()) != -1) {
                    out.write(dato);
                }
                out.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }).start();
    }

    // Muestra en consola lo que produce el proceso C
    private static void mostrarSalida(Process proceso) {
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }).start();
    }
}
