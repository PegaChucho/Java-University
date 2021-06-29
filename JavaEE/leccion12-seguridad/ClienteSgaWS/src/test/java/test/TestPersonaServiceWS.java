package test;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;
import java.util.List;
import javax.xml.ws.BindingProvider;

public class TestPersonaServiceWS {
    public static void main(String[] args) {
        
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");
        
        System.out.println("Ejecutando servicio");
        List<Persona> personas = personaService.listarPersonas();
        for (Persona persona : personas) {
            System.out.println("ID: " + persona.getIdPersona()+", Nombre: "+persona.getNombre()
            + ", Apellido: "+persona.getApellido()+", E-mail: "+persona.getEmail()
            +", Télefono: "+persona.getTelefono());
        }
        System.out.println("Fin del servicio");
    }
}
