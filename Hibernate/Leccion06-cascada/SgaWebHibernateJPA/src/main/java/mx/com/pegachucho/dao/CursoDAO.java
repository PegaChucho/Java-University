package mx.com.pegachucho.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static mx.com.pegachucho.dao.GenericDAO.em;
import mx.com.pegachucho.domain.Curso;

public class CursoDAO extends GenericDAO{

    public List<Curso> listar() {
        String hql = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query q = em.createQuery(hql); //Recuperamos objetos, no registros
        List<Curso> cursos = q.getResultList();
        return q.getResultList();
    }

    public void insertar(Curso c) {
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
    
    public void modificar(Curso c) {
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
    
    public void eliminar(Curso c){
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
    
    public Curso buscarPorID (Curso c){
        return em.find(Curso.class, c.getIdCurso());
    }

}
