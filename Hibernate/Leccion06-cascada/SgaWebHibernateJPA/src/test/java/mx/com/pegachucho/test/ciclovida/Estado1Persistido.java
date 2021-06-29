package mx.com.pegachucho.test.ciclovida;

import javax.persistence.*;
import mx.com.pegachucho.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1.- Estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("fernanhoa@hotmail.com");
        contacto.setTelefono("554718247011");
        
        //2.- Persistencia del objeto
        em.getTransaction().begin();
        
        em.persist(contacto);//antes de persist era save
        
        em.getTransaction().commit();
        
        //3.- detached
        System.out.println("contacto = " + contacto);
        
    }
}
