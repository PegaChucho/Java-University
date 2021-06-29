package mx.com.pegachucho.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.pegachucho.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoSesionLargaJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transacción
        //Paso 1: Iniciamos la transacción
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2: Ejecutamos el sql select
        Persona persona1 = em.find(Persona.class, 14);

        //objeto en estado de detached 
        log.debug("Objeto recuperado modificado: " + persona1);

        //paso 3: Modificar el registro
        persona1.setEmail("emejialba@deloittemx.com");
        persona1.setNombre("Felicitas");

        //paso 4: Termina la transacción
        tx.commit();

        //objeto en estado de detached 
        log.debug("Objeto recuperado modificado: " + persona1);

        //Cerramos el objeto enity manager
        em.close();
    }
}
