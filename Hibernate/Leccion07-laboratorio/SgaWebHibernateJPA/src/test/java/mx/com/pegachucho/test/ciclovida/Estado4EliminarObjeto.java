package mx.com.pegachucho.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.pegachucho.dao.ContactoDAO;
import mx.com.pegachucho.domain.Contacto;

public class Estado4EliminarObjeto {

    public static void main(String[] args) {
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
            EntityManager em = emf.createEntityManager();
        try {

            //Denfinir la variable que recibirá el objeto
            Contacto contacto = null;

            //Recuperar un objeto de a BBDD
            //1.- Estado detached
            contacto = em.find(Contacto.class, 3);

            //Modificamos el objeto
            em.getTransaction().begin();

            //2.- remove
            em.remove(em.merge(contacto));

            em.getTransaction().commit();//se guarda en la base de datos

            //detached
            ContactoDAO contactoDao = new ContactoDAO();
            contactoDao.listar();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }

    }
}
