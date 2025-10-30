import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

public class ProcesoA {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
        Random numRandom = new Random();
        String letras = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 15; i++) {
            int longitud = numRandom.nextInt(11) + 5; // Te da aleatoriamente 11 valores. El +5 indica que sea desde 5-15
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < longitud; j++) {
                sb.append(letras.charAt(numRandom.nextInt(letras.length())));
            }

            writer.println(sb.toString());
        }
        writer.close();
    }
}
