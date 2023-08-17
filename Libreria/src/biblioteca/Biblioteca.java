package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import libros.Libro;
import libros.Ejemplar;

// clase biblioteca -> archivo -> HashMap [ Libro : ArrayList (Ejemplar) ]
public class Biblioteca{
    // att
    private String direccion;
    public HashMap<Libro, ArrayList<Ejemplar>> archivo = new HashMap<>();
    
    // constructor vacio
    public Biblioteca() {
    }
    // constructor con param
    public Biblioteca(String direccion) {
        this.direccion = direccion;
    }
    // getters y setters
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return direccion;
    }
}
