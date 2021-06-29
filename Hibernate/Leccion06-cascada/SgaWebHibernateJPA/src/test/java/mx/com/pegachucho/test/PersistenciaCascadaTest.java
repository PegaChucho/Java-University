package mx.com.pegachucho.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.pegachucho.domain.Alumno;
import mx.com.pegachucho.domain.Contacto;
import mx.com.pegachucho.domain.Domicilio;

public class PersistenciaCascadaTest {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //Con la persistencia en cascada con guardar el objeto de alumno se guardaran automaticamente
        //el somicilio y el contacto en las tablas correspondientes
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Antonio Roanova");
        domicilio.setNoCalle("24");
        domicilio.setCp(7230);
        domicilio.setPais("México");
        
        Contacto contacto = new Contacto();
        contacto.setEmail("susanahoria@gmail.com");
        contacto.setTelefono("5567690331");
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Susana");
        alumno.setApellido("Tellez");
        alumno.setContacto(contacto);
        alumno.setDomicilio(domicilio);
        
        em.getTransaction().begin();
        em.persist(alumno);//solo se persiste al alumno!
        em.getTransaction().commit();
        
        System.out.println("alumno = " + alumno);
        
    }
}
