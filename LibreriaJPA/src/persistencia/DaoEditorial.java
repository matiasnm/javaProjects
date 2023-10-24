package persistencia;

import entidades.Editorial;
import java.util.List;
import javax.persistence.TypedQuery;


public class DaoEditorial extends Dao<Editorial> {
    
    // create
    public void guardar(Editorial editorial) {
        super.create(editorial);
    }
    
    // read
    public Editorial buscarPorId(int id) throws Exception {
        try {
            conectar();
            Editorial libro = em.find(Editorial.class, id);
            return libro;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }

    public List<Editorial> buscarPorNombre(String nombre) throws Exception {
        try {
            conectar();
            TypedQuery<Editorial> consulta;
            consulta = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre", Editorial.class).setParameter("nombre", nombre);
            return consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
        
    public List<Editorial> listarTodos() throws Exception {
        try {
            conectar();
            List<Editorial> libros = em.createQuery("SELECT e FROM Editorial e", Editorial.class).getResultList();
            return libros;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
    
    // update
    public void editar(Editorial libro) {
        super.update(libro);
    }
    
    // remove
    public void eliminar(int id) throws Exception {
        Editorial libro = buscarPorId(id);
        super.delete(libro);
    }
}