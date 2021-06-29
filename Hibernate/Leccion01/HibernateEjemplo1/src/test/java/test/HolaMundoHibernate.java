package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.pegachucho.domain.Persona;

public class HolaMundoHibernate {
    public static void main(String[] args) {
        
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager em= emf.createEntityManager();
        
        Query q = em.createQuery(hql);
        List<Persona> personas= q.getResultList();
        for (Persona p : personas) {
            System.out.println("Persona: " + p);
        }
    }
}
