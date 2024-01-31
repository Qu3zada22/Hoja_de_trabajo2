import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para leer expresiones desde un archivo de texto.
 * 
 * @author Jonathan Díaz
 * @author Anggie Quezada
 */
class LectorArchivo {
    private String ruta;

    /**
     * Constructor que recibe la ruta del archivo a leer.
     * 
     * @param ruta Ruta del archivo a leer.
     */
    public LectorArchivo(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Lee las expresiones en formato prefix desde el archivo.
     * 
     * @return Lista de expresiones en formato prefix.
     * @throws IOException Si hay un error al leer el archivo.
     */
    public List<String> leerExpresionesPrefix() throws IOException {
        List<String> expresiones = new ArrayList<>();
        BufferedReader lector = new BufferedReader(new FileReader(ruta));
        String linea;
        while ((linea = lector.readLine()) != null) {
            linea = linea.trim();
            expresiones.add(linea);
        }
        lector.close();
        return expresiones;
    }
}
