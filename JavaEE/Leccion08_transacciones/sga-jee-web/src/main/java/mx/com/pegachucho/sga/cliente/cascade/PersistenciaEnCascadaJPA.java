package mx.com.pegachucho.sga.cliente.cascade;

import javax.persistence.*;
import mx.com.pegachucho.sga.domain.Persona;
import mx.com.pegachucho.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PersistenciaEnCascadaJPA {
    static Logger log= LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //paso 1: Crear un objeto
        //Objeto en estado transitivo
        Persona persona1= new Persona("Mario", "Moreno", "cantinflas@televisa.com", "5511898180");
        
        //Crear objeto usuario con un adependencia con la persona (se crea un nuevo contructor 
        Usuario usuario1 = new Usuario("cantinflas1911", "asus0rden3sJ3f3", persona1);
        
        //paso 3 persistimos el objeto usuario y solo ese objeto (aqui esta la persistencia en cascada)
        em.persist(usuario1);
        
        //Paso 4:Guardamos los cambios en la bbdd
        tx.commit();
        
        //Objetos en estados detached
        log.debug("persona: "+persona1);
        log.debug("usuario: "+usuario1);
        
        //Paso 5: cerramos la transaccion
        em.close();
    }
}
