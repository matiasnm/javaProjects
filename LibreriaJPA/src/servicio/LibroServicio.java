package servicio;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import persistencia.DaoLibro;


public class LibroServicio {
    
    private final DaoLibro dao;
    
    public LibroServicio() {
        this.dao = new DaoLibro();
    }
    
    // create 
    public Libro crear(String isbn, String titulo, int anio, int ejemplares, int ejemplaresPrestados, int ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        Libro libro;
        try {
            libro = new Libro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, alta, autor, editorial);
            dao.guardar(libro);
            return libro;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    // read
    public Libro buscarPorId(String isbn){
        Libro libro;
        try {
            libro = dao.buscarPorId(isbn);
            return libro;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
        
    public List<Libro> buscarPorTitulo(String titulo){
            List<Libro> libros;
        try {
            libros = dao.buscarPorTitulo(titulo);
            return libros;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Libro> buscarPorAutor(String autor){
            List<Libro> libros;
        try {
            libros = dao.buscarPorAutor(autor);
            return libros;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
        
    public List<Libro> buscarPorEditorial(String editorial){
            List<Libro> libros;
        try {
            libros = dao.buscarPorEditorial(editorial);
            return libros;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Libro> listarTodos() {
        try {
            List<Libro> libros;
            libros = dao.listarTodos();
            return libros;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    // update
    public void editar(Libro libro) {
        try {
            dao.editar(libro);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // delete
    public void eliminar(Libro libro) {
        try {
            dao.eliminar(libro.getIsbn());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // contador prestar/devolver
    public Boolean prestar(Libro libro) {
        int prestados = libro.getEjemplaresPrestados();
        int restantes = libro.getEjemplaresRestantes();
        int total = libro.getEjemplares();
        if (total > 0) {
            if (restantes > 0) {
                libro.setEjemplaresPrestados(prestados + 1);
                libro.setEjemplaresRestantes(restantes - 1);
                return true;
            }
        }
        return false;
    }
    
    public void devolver(Libro libro) {
        int prestados = libro.getEjemplaresPrestados();
        int restantes = libro.getEjemplaresRestantes();
        libro.setEjemplaresPrestados(prestados - 1);
        libro.setEjemplaresRestantes(restantes + 1);
    }
}