package test;

import mx.com.pegachucho.dao.PersonaDAO;
import mx.com.pegachucho.domain.Persona;

public class OperacionesHibernateJPA {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        personaDAO.listar();
        
        //insertar persona
        Persona persona1 = new Persona(28,"Jefferson", "Gutierritos", "joshpeck@nikelodeon.com", "5511898180");
        //personaDAO.insertar(persona1);
        
        //encontrar una persona
        Persona personaMod= new Persona(28);
        personaMod=personaDAO.buscarPersonaID(personaMod);
        System.out.println("Persona enontrada: " + personaMod);
        
        //modificar persona
        personaMod.setEmail("joshnichols@nikelodeon.com");
//        personaDAO.modificar(personaMod);
//        personaDAO.listar();

        //eliminamos a la persona
        personaDAO.eliminar(personaMod);
        personaDAO.listar();
    }
}
