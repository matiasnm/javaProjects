
package persona;

public abstract class Persona {
    
    static String[] ESTADOS = {"Indefinido", "Soltera", "Casada", "Divorciada", "Viuda"};

    private String nombre;
    private String apellido;
    private int dni;
    private int estado; 
    private final String tipo;
    
    protected Persona(String tipo) {
        this.tipo = tipo;
    }
    
    public void setDatos(String nombre, String apellido, int dni, int estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.estado = estado;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setApellido(String apellido) {
        this.apellido = apellido;
    }

    protected void setDni(int dni) {
        this.dni = dni;
    }

    protected void setEstado(int estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        String msg = "\n" + nombre + " " + apellido;
        if (dni == 0) {
            msg +=  "\n DNI: Indefinido";
        }
        else {
            msg += "\n DNI: " + dni;
        }
        msg +=  "\n ESTADO: " + ESTADOS[estado] +
                "\n TIPO: " + tipo;
        
        return msg;
    }
}
