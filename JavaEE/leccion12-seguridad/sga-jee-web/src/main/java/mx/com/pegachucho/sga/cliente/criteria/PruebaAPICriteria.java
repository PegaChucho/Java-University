package mx.com.pegachucho.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import mx.com.pegachucho.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PruebaAPICriteria {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;

        //Query utilizando el API de criteria
        //1.- Consulta de todas las personas
        //Paso 1.- El objeto EntityManager crea una instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();
        //Paso 2.- Se crea un objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        //Paso 3.- Crear el objeto raiz del query
        fromPersona = criteriaQuery.from(Persona.class);
        //Paso 4.- Seleccionamos lo necesario del from (no llamamos cadenas de sql sino métodos de java)
        criteriaQuery.select(fromPersona);
        //Paso 5.- Creamos el tipo de Query typesafe
        query = em.createQuery(criteriaQuery);
        //Paso 6.- Ejecutar la consulta
        personas = query.getResultList();

        //mostrarPersonas(personas);
        //2-A. Consulta de persona con id= 6
        log.debug("\n2-A .- Cnsulta de la persona con id = 6");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 6));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);

        //2-B. Consulta de persona con id= 4
        log.debug("\n2-B .- Consulta de la persona con id = 4");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);

        // La clase Predicate permite agregar varios criterios dinámicamente
        List<Predicate> criterios = new ArrayList<Predicate>();

        //Verificamos si tenemos criteros que agregar
        Integer idPersonaParam = 4;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));

        //Agregamos los criterios
        if (criterios.isEmpty()) {
            throw new RuntimeException("Sin criterios");
        } else if (criterios.size() == 1) { //La colección tiene un solo elemento
            criteriaQuery.where(criterios.get(0)); //0 porque obtenemos el primer valor de la colección
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }

        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);

        //Se ejecuta el query
        persona = query.getSingleResult();
        log.debug(persona);

    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }
}
