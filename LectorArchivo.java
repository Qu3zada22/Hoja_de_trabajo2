import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LectorArchivo {
    private String ruta;

    public LectorArchivo(String ruta) {
        this.ruta = ruta;
    }

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