package mx.com.pegachucho.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.pegachucho.domain.Persona;

public class PersonaDAO {

    //Como se trata de una prueba local, es responsabilidad nuestra abrir y cerrar las conexionesa la bbdd
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDAO() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }

    public List<Persona> listar() {
        String hql = "SELECT p FROM Persona p";
        Query q = em.createQuery(hql); //Recuperamos objetos, no registros
        List<Persona> personas = q.getResultList();
        //mostrarPersonas(personas);
        return personas;
    }

    public void insertar(Persona persona) {
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally{
//            if (em != null) {
//                em.close();
//            }
        }
    }
    
    public void modificar(Persona persona) {
        try {
            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally{
//            if (em != null) {
//                em.close();
//            }
        }
    }
    
    public void eliminar(Persona persona){
        try {
            em.getTransaction().begin();
            em.remove(em.merge(persona));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally{
//            if (em != null) {
//                em.close();
//            }
        }
    }
    
    public Persona buscarPersonaID (Persona p){
        return em.find(Persona.class, p.getIdPersona());
    }

    private void mostrarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            System.out.println("Personas: " + p);
        }
    }
}
