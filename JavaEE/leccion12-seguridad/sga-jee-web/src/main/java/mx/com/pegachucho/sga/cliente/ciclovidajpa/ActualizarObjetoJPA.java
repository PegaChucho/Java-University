package mx.com.pegachucho.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static mx.com.pegachucho.sga.cliente.ciclovidajpa.EncontrarObjetoJPA.log;
import mx.com.pegachucho.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transacción
        //Paso 1: Iniciamos una transacción
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2 ejecutar el sql select para encontrar el objeto deseado
        //El id proporcionado debe existir en la bbdd
        Persona persona1 = em.find(Persona.class, 14);

        //paso 3: termina la primer atransacción
        tx.commit();

        //objeto en estado de detached
        log.debug("Objeto recuperado: " + persona1);

        //paso 4: mandar a llamar el metodo setValue para modificar el registro
        persona1.setTelefono("54129555");

        //paso 5 crear nueva transaccion
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        //Paso 6: Update del objeto modificado
        em.merge(persona1);
        //em.flush(); //Se c¿vacian los objetos en la bbdd pero sin terminar la transacción

        //Paso 7: Termina la transacción
        tx2.commit();

        //objeto en estado de detached modificado
        log.debug("Objeto recuperado modificado: " + persona1);

        //Cerramos el objeto enity manager
        em.close();
    }
}
