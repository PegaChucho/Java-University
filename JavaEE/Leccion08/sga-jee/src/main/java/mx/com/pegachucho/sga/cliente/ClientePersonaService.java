
package mx.com.pegachucho.sga.cliente;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import mx.com.pegachucho.sga.domain.Persona;
import mx.com.pegachucho.sga.servicio.PersonaServiceRemote;


public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService= (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.pegachucho.sga.servicio.PersonaServiceRemote");
        
            List<Persona> personas = personaService.listarPersonas();
            
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            
            System.out.println("\nFin de la llamada al EJB desde el cliente");
        
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
