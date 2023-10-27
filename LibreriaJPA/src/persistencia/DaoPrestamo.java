
package persistencia;

import entidades.Prestamo;
import java.util.List;
import javax.persistence.TypedQuery;

public class DaoPrestamo extends Dao<Prestamo>  {
    
    // create
    public void guardar(Prestamo prestamo) {
        super.create(prestamo);
    }
    
    // read
    public Prestamo buscarPorId(int id) throws Exception {
        try {
            conectar();
            Prestamo prestamo = em.find(Prestamo.class, id);
            return prestamo;
        } catch(Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }      
    }
    
    public List<Prestamo> buscarPorCliente(int id) throws Exception {
        try {
            conectar();
            TypedQuery<Prestamo> consulta;
            consulta = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.id = :id", Prestamo.class)
                    .setParameter("id", id);
            return consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
    
    public List<Prestamo> buscarPorCliente_Altas(int id) throws Exception {
        try {
            conectar();
            TypedQuery<Prestamo> consulta;
            consulta = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.id = :id AND p.alta = true", Prestamo.class)
                    .setParameter("id", id);
            return consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
    
    //update
    public void editar(Prestamo prestamo) {
        super.update(prestamo);
    }
    
    // delete
    public void eliminar(int id) throws Exception {
        Prestamo prestamo = buscarPorId(id);
        super.delete(prestamo);
    }
}