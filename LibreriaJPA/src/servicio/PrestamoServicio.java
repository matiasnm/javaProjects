package servicio;

import entidades.Cliente;
import entidades.Libro;
import entidades.Prestamo;

import java.util.Date;
import java.util.List;

import persistencia.DaoPrestamo;


public class PrestamoServicio {
    
    private final DaoPrestamo dao;
    
    public PrestamoServicio() {
        this.dao = new DaoPrestamo();
    }
    
    // create
    public Prestamo crear(int id, Date desde, Date hasta, Cliente cliente, Libro libro) {
        Prestamo prestamo;
        try {
            prestamo = new Prestamo(id, desde, hasta, cliente, libro);
            dao.guardar(prestamo);
            return prestamo;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    // read
    public Prestamo buscarPorId(int id) {
        Prestamo prestamo;
        try {
            prestamo = dao.buscarPorId(id);
            return prestamo;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Prestamo> buscarPorCliente(int id) {
        List<Prestamo> prestamos;
        try {
            prestamos = dao.buscarPorCliente(id);
            return prestamos;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    // update
    public void editar(Prestamo prestamo) {
        try {
            dao.editar(prestamo);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // delete
    public void eliminar(Prestamo prestamo) {
        try {
            dao.eliminar(prestamo.getId());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}