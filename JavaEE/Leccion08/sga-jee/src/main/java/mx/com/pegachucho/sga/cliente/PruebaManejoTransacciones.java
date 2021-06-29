
package mx.com.pegachucho.sga.cliente;

import javax.naming.*;
import mx.com.pegachucho.sga.domain.Persona;
import org.apache.logging.log4j.*;
import mx.com.pegachucho.sga.servicio.PersonaServiceRemote;


public class PruebaManejoTransacciones {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.pegachucho.sga.servicio.PersonaServiceRemote");
            
            log.debug("Iniciando prueba Manejo Transaccional PersonaService");
            
            //Buscar un objeto persona
            Persona persona1= personaService.encontrarPersonaPorId(new Persona(13));
            
            log.debug("Persona recuperada: "+persona1);
            
            //Cambiar el apellido
            //persona1.setApellido("cambio con error.........................................................................................................................................................");
            persona1.setApellido("Rodelas");
            
            personaService.modificarPersona(persona1);
            log.debug("Objeto modificado: "+persona1);
            log.debug("FIN de la prueba transaccional");
            
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
    }
}
