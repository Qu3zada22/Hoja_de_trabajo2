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
            for (String expresion : expresiones) {
                PostfixCalculator calculator = new PostfixCalculator();
                Boolean flag = calculator.evaluate(expresion);
                if (flag) {
                    int resultado = calculator.returnResult();
                    System.out.println("Resultado de la expresión " + expresion + ": " + resultado);
                }
            }
        } catch (IOException e) {
            System.out.println("Error de sintaxis.");
        }
    }
}
