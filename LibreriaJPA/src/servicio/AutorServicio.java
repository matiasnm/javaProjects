package servicio;

import entidades.Autor;

import java.util.List;

import persistencia.DaoAutor;


public class AutorServicio {
    
    private final DaoAutor dao;
    
    public AutorServicio() {
        this.dao = new DaoAutor();
    }
    
    // create
    public Autor crear(int id, String nombre, boolean alta) {
        Autor autor = new Autor(id, nombre, alta);
        return autor;
    }
    
    // update
    public void editar(Autor autor) {
        try {
            dao.editar(autor);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // delete
    public void eliminar(Autor autor) {
        try {
            dao.eliminar(autor.getId());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // read
    public List<Autor> buscarPorNombre(String nombre) {
        try {
            List<Autor> autores;
            autores = dao.buscarPorNombre(nombre);
            return autores;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    };  
}