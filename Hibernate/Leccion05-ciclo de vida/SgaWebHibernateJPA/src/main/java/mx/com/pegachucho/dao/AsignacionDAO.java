package mx.com.pegachucho.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static mx.com.pegachucho.dao.GenericDAO.em;
import mx.com.pegachucho.domain.Asignacion;

public class AsignacionDAO extends GenericDAO{



    public List<Asignacion> listar() {
        String hql = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query q = em.createQuery(hql); //Recuperamos objetos, no registros
        List<Asignacion> asignaciones = q.getResultList();
        return q.getResultList();
    }

    public void insertar(Asignacion a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void modificar(Asignacion a) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
    }
    
    public void eliminar(Asignacion a){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(a));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
    }
    
    public Asignacion buscarPorID (Asignacion a){
        return em.find(Asignacion.class, a.getIdAsignacion());
    }

}