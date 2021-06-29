package mx.com.pegachucho.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import mx.com.pegachucho.sga.domain.Persona;
import mx.com.pegachucho.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class ClientesAsociacionesJPA {

    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //No se necesita crear una transacción
        List<Persona> personas = (List<Persona>) em.createNamedQuery("Persona.findAll").getResultList();

        //Cerramos la conexion
        em.close();

        //Imprimir los objetos de tipo persona
        for (Persona persona : personas) {
            log.debug("Persona: " + persona);
            //Recuperamos los usuarios de cada persona
            for (Usuario usuario : persona.getUsuarioList()) {
                log.debug("usuario: "+usuario);
            }
        }
    }
    
}
