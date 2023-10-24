package servicio;

import entidades.Editorial;

import java.util.List;

import persistencia.DaoEditorial;

public class EditorialServicio {
    
    private final DaoEditorial dao;
    
    public EditorialServicio() {
        this.dao = new DaoEditorial();
    }
    
    // create
    public Editorial crear(int id, String nombre, boolean alta) {
        Editorial editorial = new Editorial(id, nombre, alta);
        return editorial;
    }
    
    // read
    public List<Editorial> buscarPorNombre(String nombre) {
        try {
            List<Editorial> editoriales;
            editoriales = dao.buscarPorNombre(nombre);
            return editoriales;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    // update
    public void editar(Editorial editorial) {
        try {
            dao.editar(editorial);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }   
    
    // delete
    public void eliminar(Editorial editorial) {
        try {
            dao.eliminar(editorial.getId());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}