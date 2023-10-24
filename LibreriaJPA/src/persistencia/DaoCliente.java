package persistencia;

import entidades.Cliente;


public class DaoCliente extends Dao<Cliente> {

    // create
    public void guardar(Cliente cliente) {
        super.create(cliente);
    }
    
    // read
    public Cliente buscarPorId(int id) throws Exception {
        try {
            conectar();
            Cliente cliente = em.find(Cliente.class, id);
            return cliente;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
    
    // update
    public void editar(Cliente cliente) throws Exception {
        super.update(cliente);
    }
    
    // delete
    public void eliminar(int id) throws Exception {
        Cliente cliente = buscarPorId(id);
        super.delete(cliente);
    }
}