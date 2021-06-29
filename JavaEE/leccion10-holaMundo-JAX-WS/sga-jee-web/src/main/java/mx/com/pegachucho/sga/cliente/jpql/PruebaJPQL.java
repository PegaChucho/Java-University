package mx.com.pegachucho.sga.cliente.jpql;

import java.util.*;
import javax.persistence.*;
import mx.com.pegachucho.sga.domain.Persona;
import mx.com.pegachucho.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //solo será una cosnulta sin transacción
        //1.-Consultar los objetos de tipo persona:
        log.debug("\n1. Consulta de todas las personas");
        jpql = "select p from Persona p"; //p es el alias
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //2. consulta a una persona con llave primeria (id)
        log.debug("\n2. Consulta de la persona con un id");
        jpql = "select p from Persona p where p.idPersona = 13";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        //log.debug(persona);

        //3. Consulta d ela persona por nombre
        log.debug("\n3. Consulta d ela persona por nombre");
        jpql = "select p from Persona p where p.nombre = 'Eva'";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //4. Consulta de datos individuales, se crea una tupla de tipo objeto de tres columnas
        log.debug("\n4. Consulta de datos individuales (tupla)");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Mail from Persona P";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String Nombre = (String) tupla[0];
            String Apellido = (String) tupla[1];
            String Mail = (String) tupla[2];
            //log.debug("Nombre: "+Nombre+", Apellido: "+Apellido+", Mail: "+Mail);
        }

        //5. Obtiene el objeto perosna y el id, se crea una tupla de dos columnas
        log.debug("\n5. Obtiene el objeto perosna y el id, se crea una tupla de dos columnas");
        jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            //log.debug("Objeto persona: "+persona+", ID: "+idPersona);
        }

        //6. Consultas de todas las personas
        log.debug("\n6. Consultas de todas las personas recuperando solo ID");
        //creamos un nuevo objeto de tipo persona para recuperar solo idPersona
        jpql = "select new mx.com.pegachucho.sga.domain.Persona(p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //7.- Regresa el valor minimo y maximo de idpersona
        log.debug("\n7. Regresa el valor minimo y maximo de idpersona");
        jpql = "select min(p.idPersona) as MinID, max(p.idPersona) as MaxID, count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            int idMin = (int) tupla[0];
            int idMax = (int) tupla[1];
            Long count = (Long) tupla[2];
            //log.debug("idMin: "+idMin+", idMax: "+idMax+", Contador: "+count);
        }

        //8.- Cuenta los nombres d elas personas que son distintos
        log.debug("\n8. Cuenta los nombres de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //log.debug("No. de personas con nombres distintos: " + contador);
        
        //9. Concatena y convierte a mayúsculas el nombre y apellido
        log.debug("\n9. Concatena y convierte a mayúsculas el nombre y apellido");
        jpql= "select CONCAT(p.nombre, ' ', p.apellido) as nombre from Persona p ";
        nombres= em.createQuery(jpql).getResultList();
        for (String nombreCompleto : nombres) {
            //log.debug("Nombre completo: "+nombreCompleto);
        }
        
        //10. Obtiene el objeto persona con ID igual al parámetro proporcionado PARAMEROS
        log.debug("\n10. Obtiene el objeto persona con ID igual al parámetro proporcionado");
        int idPersona = 1;
        jpql="select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        //definimos el :parámetro y el valor que le queremos pasar
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        //log.debug(persona);
        
        //11. Obtener la persona que tengan una letra A en su nombre sean mayusculas o minusculas
        log.debug("\n11. Obtener la persona que tengan una letra A en su nombre sean mayusculas o minusculas");
        jpql ="select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametro = "%a%"; //los porcentajes representan que puede estar al inicio o dentro o al final del nombre
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametro);
        personas =  q.getResultList();
        //mostrarPersonas(personas);
        
        //12. Uso de between
        log.debug("\n12. Uso de between");
         jpql ="select p from Persona p where p.idPersona between 1 and 10";
         personas = em.createQuery(jpql).getResultList();
         //mostrarPersonas(personas);
         
         //13. Uso del ordenamiento
         log.debug("\n13. Uso de ordenamiento y filtrado");
         jpql ="select p from Persona p where p.idPersona > 3 order by p.nombre desc, p.apellido desc";
         personas = em.createQuery(jpql).getResultList();
         //mostrarPersonas(personas);
         
         //14. Uso de subqueries
        log.debug("\n14. Uso de subqueries");
        jpql ="select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //15. Uso de join con lazy loading
        log.debug("\n15. Uso de join con lazy loading");
        jpql ="select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        //mostrarUsuarios(usuarios);
        
        //16. Uso de left join con eager loading
        log.debug("\n16. Uso de left join con eager loading");
        jpql ="select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            log.debug(usuario);
        }
    }

}
