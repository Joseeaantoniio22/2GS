
import java.io.*;

public class ProcesoC {

    public static void main(String[] args) {
        int totalVocales = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 2) {
                    continue;
                }

                String palabra = partes[0];
                int longitud = Integer.parseInt(partes[1]);
                int vocales = contarVocales(palabra);

                totalVocales += vocales;

                System.out.println("Cadena: " + palabra + " | Longitud: " + longitud + " | Vocales: " + vocales);
            }

            System.out.println("Total de vocales procesadas: " + totalVocales);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int contarVocales(String palabra) {
        int contador = 0;
        String vocales = "aeiou";
        for (char c : palabra.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }
}
