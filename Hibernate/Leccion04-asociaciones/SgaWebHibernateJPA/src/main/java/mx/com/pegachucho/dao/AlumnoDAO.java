package mx.com.pegachucho.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.pegachucho.domain.Alumno;

public class AlumnoDAO extends GenericDAO{



    public List<Alumno> listar() {
        String hql = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query q = em.createQuery(hql); //Recuperamos objetos, no registros
        List<Alumno> alumnos = q.getResultList();
        return q.getResultList();
    }

    public void insertar(Alumno a) {
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
    
    public void modificar(Alumno a) {
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
    
    public void eliminar(Alumno a){
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
    
    public Alumno buscarPorID (Alumno a){
        return em.find(Alumno.class, a.getIdAlumno());
    }
}