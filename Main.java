import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            PostfixCalculator calculator = new PostfixCalculator();

            while ((line = reader.readLine()) != null) {
                int result = calculator.evaluateExpression(line);
                System.out.println("Resultado: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
