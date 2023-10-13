package jdbc.persistencia;

import jdbc.entidades.Clientes;

public interface ClientesInterfaceDAO {
    public void eliminarClientes(Clientes cliente) throws Exception;
    public void modificarClientes(Clientes cliente) throws Exception;
    public void guardarClientes(Clientes cliente) throws Exception;
}