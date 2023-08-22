
package alumno;

import java.util.Objects;


public class Alumno {
    private String nombre;
    private int dni;
    private int votos;

    public Alumno() {
    }

    public Alumno(String nombre, int dni, int votos) {
        this.nombre = nombre;
        this.dni = dni;
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getVotos() {
        return votos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    public void addVoto() {
        this.votos += 1;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) obj;
        return dni == other.dni;
    }
    
    @Override
    public String toString() {
        // 30
        int n = 26 - nombre.length();
        //String espacios = " ".repeat(x); java11...
        String espacios = " ";
        for (int i = 0; i < n; i++) {
            espacios += " ";
        }
        return "Nombre: " + nombre + "," + espacios + "dni: " + dni + ", votos: " + votos;
    }
    
}
