package test;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.pegachucho.sga.domain.Persona;
import mx.com.pegachucho.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        
        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile); 
        ProgrammaticLogin programaticLogin = new ProgrammaticLogin();
        programaticLogin.login("admin", "admin".toCharArray()); //para convertir el password en caracteres
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.pegachucho.sga.servicio.PersonaServiceRemote"); //buscar e jndi en el servidor
        
            List<Persona> personas= personaService.listarPersonas();
            
            for (Persona p : personas) {
                System.out.println("Persona: " + p);
            }
            System.out.println("\nFin de la llamada al EJB");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
