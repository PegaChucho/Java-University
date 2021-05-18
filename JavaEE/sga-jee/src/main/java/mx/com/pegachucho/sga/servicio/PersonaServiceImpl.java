
package mx.com.pegachucho.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.pegachucho.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas= new ArrayList<>();
        personas.add(new Persona(1, "Jesus", "Perez", "jperezgarcia@deloittemx.com", "5538780254"));
        personas.add(new Persona(2, "Eva", "Garcia", "evita55@gmail.com", "5538780254"));
        return personas;
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
    }

    @Override
    public void modificarPersona(Persona persona) {
    }

    @Override
    public void eliminarPersona(Persona persona) {
    }
    
}
