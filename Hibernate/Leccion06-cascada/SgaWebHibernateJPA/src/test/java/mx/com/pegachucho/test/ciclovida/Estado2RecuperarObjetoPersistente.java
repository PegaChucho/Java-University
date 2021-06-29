package mx.com.pegachucho.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.pegachucho.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Denfinir la variable que recibirá el objeto
        Contacto contacto= null;
        
        //Recuperar un objeto de a BBDD
        contacto=em.find(Contacto.class, 3);
        
        //detached
        System.out.println("contacto = " + contacto);
        
    }
}
