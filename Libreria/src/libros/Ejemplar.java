package libros;


// clase particular/fisica de libros
public class Ejemplar {
    // att
    private long id;
    private String edicion;
    private Boolean estado;
    
    // constructor vacio
    public Ejemplar() {
    }
    // constructor param
    public Ejemplar(long id, String edicion, Boolean estado) {
        this.id = id;
        this.edicion = edicion;
        this.estado = estado;
    }
    // to string
    @Override
    public String toString() {
        String disponible = (estado)? "Disponible" : "No disponible";
        return "(Ejemplar)\u0009 ->[id:" + id + ", Edición:" + edicion + ", Estado:" + disponible + "]";
    }
    //setters y getters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEdicion() {
        return edicion;
    }
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }   
}
