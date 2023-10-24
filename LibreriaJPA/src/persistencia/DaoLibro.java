package persistencia;

import entidades.Libro;
import java.util.List;
import javax.persistence.TypedQuery;


public class DaoLibro extends Dao<Libro> {
    
    // create
    public void guardar(Libro libro) {
        super.create(libro);
    }
    
    // read
    public Libro buscarPorId(String id) throws Exception {
        try {
            conectar();
            Libro libro = em.find(Libro.class, id);
            return libro;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }  
    }

    public List<Libro> buscarPorTitulo(String titulo) throws Exception {
        try {
            conectar();
            TypedQuery<Libro> consulta;
            consulta = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class).setParameter("titulo", "%" + titulo + "%");
            return consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
    
    public List<Libro> buscarPorEditorial(String editorial) throws Exception {
        try {
            conectar();
            TypedQuery<Libro> consulta;
            consulta = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :editorial", Libro.class).setParameter("editorial", "%" + editorial + "%");
            return consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
        
    public List<Libro> buscarPorAutor(String autor) throws Exception {
        try {
            conectar();
        TypedQuery<Libro> consulta;
        consulta = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor", Libro.class).setParameter("autor", "%" + autor + "%");
        return consulta.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
        
    public List<Libro> listarTodos() throws Exception {
        try {
            conectar();
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
            return libros;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectar();
        }
    }
    
    // update
    public void editar(Libro libro) {
        super.update(libro);
    }
    
    // delete
    public void eliminar(String id) throws Exception {
        Libro libro = buscarPorId(id);
        super.delete(libro);
    }
}