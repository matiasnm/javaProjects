package persistencia;

import entidades.Autor;
import java.util.List;
import javax.persistence.TypedQuery;


public class DaoAutor extends Dao<Autor> {
    
    // create
    public void guardar(Autor autor) {
        super.create(autor);
    }
    
    // read
    public Autor buscarPorId(int id) throws Exception {
        try {
            conectar();
            Autor autor = em.find(Autor.class, id);
            return autor;
        } catch(Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }  
    }

    public List<Autor> buscarPorNombre(String nombre) throws Exception {
        try {
            conectar();
            TypedQuery<Autor> consulta;
            consulta = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre ", Autor.class)
                    .setParameter("nombre", "%" + nombre + "%");
            return consulta.getResultList();
        } catch(Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
        
    public List<Autor> listarTodos() throws Exception {
        try {
            conectar();
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
            return autores;
        } catch(Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }       
    }
    
    // update
    public void editar(Autor autor) {
        super.update(autor);
    }
    
    // delete
    public void eliminar(int id) throws Exception {
        Autor autor = buscarPorId(id);
        super.delete(autor);
    }
}