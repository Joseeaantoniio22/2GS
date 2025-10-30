import java.io.IOException;

public class Ejecutor {
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
                System.out.println("Ejecución número " + (i + 1));
                String orden = "cmd /c start cmd /K \"java ProcesoA.java | java ProcesoB.java | java ProcesoC.java";
                String[] comando = orden.split(" ");
                Runtime.getRuntime().exec(comando);
            } catch (IOException e) {
                System.out.println("Error al ejecutar los procesos: " + e.getMessage());
            }
        }
    }
}
