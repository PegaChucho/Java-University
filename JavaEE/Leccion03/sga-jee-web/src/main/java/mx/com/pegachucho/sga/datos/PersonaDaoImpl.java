
package mx.com.pegachucho.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.pegachucho.sga.domain.Persona;

@Stateless
public class PersonaDaoImpl implements iPersonaDAO{
    
    //Inyectamos el PersistentUnit PU dentro del entityManager
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        //creamos un query directamente para buscar a una persona por su email
        Query query= em.createQuery("from Persona p where p.email =: email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        //sincronizamos el estado con la bbdd y eliminamos el objeto
        em.remove(em.merge(persona));
    }
}
