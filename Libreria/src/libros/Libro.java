package libros;

import java.util.Objects;

// clase general/abstracta de libros 
public class Libro {
    // att
    private String titulo;
    private String autor;
    
    // contructor vacio
    public Libro() {
    }
    // contructor param
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    // to string
    @Override
    public String toString() {
        return "(Libro)\u0009\u0009[Titulo:" + titulo + ", Autor:" + autor + "]";
    }
    
    // hashCode and equals compare based on att   
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
    @Override
    public boolean equals(Object obj) {
        // si los objetos son la misma instancia
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        // comparar basado en titulo / autor
        final Libro other = (Libro) obj;
        // mismo titulo ?
        if (Objects.equals(this.titulo, other.titulo)) {
            // mismo autor ? => true
            // diferente autor ? => false
            return Objects.equals(this.autor, other.autor);
        }
        // titulos diferentes
        return false;
    }

    // setters y getters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
}