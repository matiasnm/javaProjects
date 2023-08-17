package libros;

public class servicioLibro {

    public servicioLibro() {
    }
    public static Libro crear_libro(String titulo, String autor) {
        Libro nuevoLibro = new Libro(titulo, autor);
        return nuevoLibro;
    }
    public static Ejemplar crear_ejemplar(long id, String edicion, Boolean estado) {
        Ejemplar nuevoEjemplar = new Ejemplar(id, edicion, estado);
        return nuevoEjemplar;
    }
}
