package testclientews;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;
import java.util.List;

public class TestpersonaServiceWS {
    public static void main(String[] args) {
        
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
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
