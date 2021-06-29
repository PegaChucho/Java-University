package mx.com.pegachucho.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.pegachucho.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transacción
        //Paso 1: Iniciamos la transacción
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2: Ejecutamos un sql de tipo select
        Persona persona1 = em.find(Persona.class, 14);
        
        //Paso 3; termina la primera transacción
        tx.commit();
        
        //objeto en estado de detached 
        log.debug("Objeto recuperado modificado: " + persona1);
        
        //Paso 4 inicio de la segunda transaccion
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //paso 5: Hacer un merge con la bbdd para actualizarla y ejecutamos el sql delete
        em.remove(em.merge(persona1));
        
        //paso 6: terminar la segunda transacción
        tx2.commit();
        
        //objeto en estado de detached 
        //El objeto aun existe en memoria pero ya no existe en la base de datos :C adiosito
        log.debug("Objeto recuperado modificado: " + persona1);
        
        //Cerramos el objeto enity manager
        em.close();
    }
}
