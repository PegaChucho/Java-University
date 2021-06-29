
package mx.com.pegachucho.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.pegachucho.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EncontrarObjetoJPA {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transacción
        //Paso 1: Iniciamos una transacción
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //paso 2: ejecutar SQL select (clase, id)
        Persona persona1 = em.find(Persona.class, 1);
        
        //Paso 3: termina la transacción
        tx.commit();
                
        //objeto en estado de detached
        log.debug("Objeto recuperado: " +persona1);
        
        //Cerramos el objeto enity manager
        em.close();
    }
}
