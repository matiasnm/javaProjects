package jdbc.persistencia;

import java.util.Collection;
import jdbc.entidades.Casas;


public interface CasasInterfaceDAO {
    public Collection<Casas> listarCasasDisponibles() throws Exception;
    public void eliminarCasas(Casas casa) throws Exception;
    public void modificarCasas(Casas casa) throws Exception;
    public void guardarCasas(Casas casa) throws Exception; 
}
