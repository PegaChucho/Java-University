package mx.com.pegachucho.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static mx.com.pegachucho.dao.GenericDAO.em;
import mx.com.pegachucho.domain.Contacto;

public class ContactoDAO extends GenericDAO{



    public List<Contacto> listar() {
        String hql = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query q = em.createQuery(hql); //Recuperamos objetos, no registros
        List<Contacto> contactos = q.getResultList();
        return q.getResultList();
    }

    public void insertar(Contacto c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void modificar(Contacto c) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
    }
    
    public void eliminar(Contacto c){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(c));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
    }
    
    public Contacto buscarPorID (Contacto c){
        return em.find(Contacto.class, c.getIdContacto());
    }

}
