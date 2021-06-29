package mx.com.pegachucho.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.pegachucho.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Inicia la transacción
        //Paso 1: Crea un nuevo objeto, objeto en estado transitivo
        Persona persona1 = new Persona("Alondra", "Mejia", "emejia@deloittemx.com", "0445511898180");

        //paso 2: iniciar la transacción
        tx.begin();

        //Paso 3: Ejecutar consulta SQL
        em.persist(persona1);
        log.debug("Objeto persisitido - estado de detached" + persona1);

        //Paso 4: Hacer commit o rollback para que se guarde, a partir de aqui ya se puede recuperar el id key
        tx.commit();

        //Objeto en estado detached
        log.debug("Objeto persisitido - estado de detached" + persona1);
        
        //Cerramos el objeto enity manager
        em.close();
    }
}
