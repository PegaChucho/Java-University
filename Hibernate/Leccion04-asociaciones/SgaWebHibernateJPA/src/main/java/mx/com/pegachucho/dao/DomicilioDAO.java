package mx.com.pegachucho.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static mx.com.pegachucho.dao.GenericDAO.em;
import mx.com.pegachucho.domain.Domicilio;

public class DomicilioDAO extends GenericDAO{



    public List<Domicilio> listar() {
        String hql = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query q = em.createQuery(hql); //Recuperamos objetos, no registros
        List<Domicilio> domicilios = q.getResultList();
        return q.getResultList();
    }

    public void insertar(Domicilio d) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void modificar(Domicilio d) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
    }
    
    public void eliminar(Domicilio d){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(d));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } 
    }
    
    public Domicilio buscarPorID (Domicilio d){
        return em.find(Domicilio.class, d.getIdDomicilio());
    }

}