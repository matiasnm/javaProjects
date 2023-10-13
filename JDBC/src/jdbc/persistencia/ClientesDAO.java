package jdbc.persistencia;

import jdbc.entidades.Clientes;


public class ClientesDAO extends DAO {

    
    public void guardarClientes(Clientes cliente) throws Exception{
        try {
            if(cliente == null){
                throw new Exception("Debe indicar un cliente!");
            }
            
            String sql = "INSERT INTO clientes (id_cliente, nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES ( '" 
                    + cliente.getId_clientes() + "', '" + cliente.getNombre()+ "', '" + cliente.getCalle()
                    + "', '" + cliente.getNumero()+ "', '" + cliente.getCodigo_postal() + "', '" + cliente.getCiudad() + "', '" + cliente.getPais() 
                    + "', '" + cliente.getEmail() + "')";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void modificarClientes(Clientes cliente) throws Exception {
        try {
            if(cliente == null){
                throw new Exception("Debe indicar un cliente!");
            }
            
            String sql = "UPDATE clientes SET nombre = '" + cliente.getNombre()+ "' WHERE id_cliente = '" + cliente.getId_clientes()+ "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    

    public void eliminarClientes(Clientes cliente) throws Exception {
        int id_cliente = cliente.getId_clientes();
        try {     
            String sql = "DELETE FROM clientes WHERE nombre = '" + id_cliente + "';";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}