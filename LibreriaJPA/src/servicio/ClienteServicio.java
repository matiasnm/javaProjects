package servicio;

import entidades.Cliente;

import persistencia.DaoCliente;


public class ClienteServicio {
    
    private final DaoCliente dao;
    
    public ClienteServicio() {
        this.dao = new DaoCliente();
    }

    // create 
    public Cliente crear(int id, String dni, String nombre, String apellido, String telefono) {
        Cliente cliente;
        try {
            cliente = new Cliente(id, dni, nombre, apellido, telefono);
            dao.guardar(cliente);
            return cliente;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    // read
    public Cliente buscarPorId(int id){
        Cliente cliente;
        try {
            cliente = dao.buscarPorId(id);
            return cliente;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    // update
    public void editar(Cliente cliente) {
        try {
            dao.editar(cliente);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // delete
    public void eliminar(Cliente cliente) {
        try {
            dao.eliminar(cliente.getId());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}