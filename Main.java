import java.io.IOException;
import java.util.List;

/**
 * Clase principal que contiene el método main para leer expresiones desde un
 * archivo y calcular sus resultados.
 * 
 * @author Jonathan Díaz
 * @author Anggie Quezada
 */
public class Main {

    /**
     * Obtiene expresiones desde un archivo utilizando la clase LectorArchivo.
     * 
     * @param ruta Ruta del archivo que contiene las expresiones.
     * @return Lista de expresiones en formato prefix.
     * @throws IOException Si hay un error al leer el archivo.
     */
    public static List<String> obtenerExpresiones(String ruta) throws IOException {
        LectorArchivo lector = new LectorArchivo(ruta);
        return lector.leerExpresionesPrefix();
    }

    /**
     * Método principal que lee expresiones desde un archivo, las evalúa y muestra
     * los resultados.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        String rutaArchivo = "datos.txt";
        try {
            List<String> expresiones = obtenerExpresiones(rutaArchivo);
            for (String expresion : expresiones) {
                PostfixCalculator calculator = new PostfixCalculator();
                int resultado = calculator.calcular(expresion);
                System.out.println("Resultado de la expresión " + expresion + ": " + resultado);
                }
        } catch (Exception e) {
            System.out.println("Error de sintaxis al leer el archivo.");
        }
    }
}
