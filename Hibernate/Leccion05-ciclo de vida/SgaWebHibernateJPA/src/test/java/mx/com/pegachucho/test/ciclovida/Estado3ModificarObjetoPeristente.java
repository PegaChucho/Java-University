package mx.com.pegachucho.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.pegachucho.domain.Contacto;

public class Estado3ModificarObjetoPeristente {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Denfinir la variable que recibirá el objeto
        Contacto contacto= null;
        
        //Recuperar un objeto de a BBDD
        //1.- Estado detached
        contacto=em.find(Contacto.class, 1);
        
        //Modificamos el objeto
        contacto.setEmail("jesus_perez_0123@hotmail.com");
        em.getTransaction().begin();
        
        //2,- persistente
        em.merge(contacto);
        
        em.getTransaction().commit();//se guarda en la base de datos
        
        
        //detached
        System.out.println("contacto = " + contacto);
        
    }
}
