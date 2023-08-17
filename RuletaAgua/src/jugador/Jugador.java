package jugador;

import revolver.Revolver;

public class Jugador {

    private int id;
    private String nombre;
    private Boolean mojado = false;

    public Jugador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMojado(Boolean mojado) {
        this.mojado = mojado;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Boolean getMojado() {
        return mojado;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", mojado=" + mojado + '}';
    }

    public Boolean disparar(Revolver r) {
        if (r.mojar()) {
            mojado = true;
        }
        r.siguiente();
        return mojado;
    }
}
