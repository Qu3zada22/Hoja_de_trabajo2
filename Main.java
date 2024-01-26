import java.io.IOException;
import java.util.List;

public class Main {
    public static List<String> obtenerExpresiones(String ruta) throws IOException {
        LectorArchivo lector = new LectorArchivo(ruta);
        return lector.leerExpresionesPrefix();
    }

    public static void main(String[] args) {
        String rutaArchivo = "datos.txt";
        try {
            List<String> expresiones = obtenerExpresiones(rutaArchivo);
            PostfixCalculator calculator = new PostfixCalculator();
            for (String expresion : expresiones) {
                int resultado = calculator.evaluate(expresion);
                System.out.println("Resultado de la expresión " + expresion + ": " + resultado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
