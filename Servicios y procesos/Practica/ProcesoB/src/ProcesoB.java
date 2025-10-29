import java.io.*;

public class ProcesoB {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true)
        ) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                int longitud = linea.length();
                writer.println(linea + "," + longitud);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
