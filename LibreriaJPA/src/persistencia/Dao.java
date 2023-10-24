package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class Dao<T> {   

    protected final EntityManagerFactory EMF;
    protected EntityManager em;

    public Dao() {
        this.EMF = Persistence.createEntityManagerFactory("LibreriaJPAPU");
        this.em =  EMF.createEntityManager();
    }
    
    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    // CRUD
    // create -> persist
    protected void create(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    // read -> em.createQuery em.find...
    
    // update -> merge
    protected void update(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    // delete -> remove
    protected void delete(T objeto) {
        conectar();
        em.getTransaction().begin();
        T objetoJPA = em.merge(objeto);
        em.remove(objetoJPA);
        em.getTransaction().commit();
        desconectar();
    }
    
}